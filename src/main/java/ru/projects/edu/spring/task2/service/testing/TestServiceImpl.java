package ru.projects.edu.spring.task2.service.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.config.MessageService;
import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.dao.TestDao;
import ru.projects.edu.spring.task2.domain.Student;
import ru.projects.edu.spring.task2.service.student.StudentService;
import ru.projects.edu.spring.task2.utils.TestUtils;

import java.util.Map;
import java.util.Scanner;

@Service
@Qualifier("testService")
public class TestServiceImpl implements TestService{
  private Map<Integer,String> questionsTestMap;
  private Map<Integer,String> answersTestMap;
  private final TestDao testDao;
  private final StudentDao studentDao;
  private Student student;
  private final MessageSource messageSource;
  private final MessageService messageService;

  @Autowired
  public TestServiceImpl(TestDao testDao, StudentDao studentDao, MessageService messageService, MessageSource messageSource){
    this.testDao = testDao;
    this.studentDao = studentDao;
    this.messageService = messageService;
    this.messageSource = messageSource;
  }

  @Override
  public void start() {
    student = studentDao.getStudent();
    questionsTestMap = testDao.getQuestions();
    answersTestMap = testDao.getAnswers();
    String line = null;
    for(Map.Entry<Integer,String>question:questionsTestMap.entrySet()){
      line = TestUtils.getInputText(String.format("- %s %d: %s", messageSource.getMessage("question",null,MessageService.locale),
          question.getKey(),question.getValue()));
      if(line.equalsIgnoreCase(answersTestMap.get(question.getKey()))) {
        System.out.println(messageSource.getMessage("correct_answer",null,MessageService.locale));
        student.upValidCount();
      }else{
        System.out.println(String.format("- %s, %s: %s",messageSource.getMessage("incorrect_answer",null,MessageService.locale),
            messageSource.getMessage("correct_answer",null,MessageService.locale),
            answersTestMap.get(question.getKey())));
        student.upNonValidCount();
      }
    }

    System.out.println(String.format("%s %s %s: ",messageSource.getMessage("test_result",null,MessageService.locale),
        student.getName(),student.getFamily()));
    System.out.println(String.format("%s: %d",messageSource.getMessage("count_correct_answers",null,MessageService.locale),
        student.getValidCount()));
    System.out.println(String.format("%s: %d",messageSource.getMessage("count_incorrect_answers",null,MessageService.locale),
        student.getNonValidCount()));
    String testPass = student.isTestPass()?"test_pass":"test_not_passed";
    System.out.println(String.format("%s",messageSource.getMessage(testPass,null,MessageService.locale)));
  }

  public void getTest() {

  }
}
