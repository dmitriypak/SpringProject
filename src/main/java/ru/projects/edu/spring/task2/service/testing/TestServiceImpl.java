package ru.projects.edu.spring.task2.service.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.dao.TestDao;
import ru.projects.edu.spring.task2.domain.Student;
import ru.projects.edu.spring.task2.service.io.MessageService;

import java.util.Map;
import java.util.function.Predicate;

@Service
@Qualifier("testService")
public class TestServiceImpl implements TestService{
  private Map<Integer,String> questionsTestMap;
  private Map<Integer,String> answersTestMap;
  private final TestDao testDao;
  private Student student;
  private final MessageService ms;
  private final ValidateService vs;

  public TestServiceImpl(TestDao testDao, MessageService messageService, ValidateService validateService){
    this.testDao = testDao;
    ms = messageService;
    vs = validateService;
  }

  @Override
  public void start(Student student) {
    if(student==null) ms.print("Студент не зарегистрирован");
    questionsTestMap = testDao.getQuestions();
    answersTestMap = testDao.getAnswers();
    String answer = null;
    for(Map.Entry<Integer,String>question:questionsTestMap.entrySet()){
      int key = question.getKey();
      answer = ms.getInputText(String.format("- %s %d: %s", ms.getMessage("question"),key,question.getValue()));
      if(vs.validate(key,answer)) {
        ms.print(ms.getMessage("correct_answer"));
        student.upValidCount();
      }else{
        ms.print(String.format("- %s, %s: %s",ms.getMessage("incorrect_answer"),
            ms.getMessage("correct_answer"), answersTestMap.get(key)));
        student.upNonValidCount();
      }
    }

    ms.print(String.format("%s %s %s: ",ms.getMessage("test_result"),
        student.getName(),student.getFamily()));
    ms.print(String.format("%s: %d",ms.getMessage("count_correct_answers"),
        student.getValidCount()));
    ms.print(String.format("%s: %d",ms.getMessage("count_incorrect_answers"),
        student.getNonValidCount()));
    String testPass = student.isTestPass()?"test_pass":"test_not_passed";
    ms.print(String.format("%s",ms.getMessage(testPass)));
  }

}
