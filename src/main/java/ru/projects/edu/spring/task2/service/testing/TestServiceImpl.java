package ru.projects.edu.spring.task2.service.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
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
  Map<Integer,String> questionsTestMap;
  Map<Integer,String> answersTestMap;
  private final TestDao testDao;
  private Student student;

  @Autowired
  public TestServiceImpl(TestDao testDao,  Student student){
    this.testDao = testDao;
    questionsTestMap = testDao.getQuestions();
    answersTestMap = testDao.getAnswers();
    this.student = student;
  }

  @Override
  public void start() {
    String line = null;
    for(Map.Entry<Integer,String>question:questionsTestMap.entrySet()){
      line = TestUtils.printInputText(String.format("%s%d: %s","- Вопрос ",question.getKey(),question.getValue()));
      if(line.equalsIgnoreCase(answersTestMap.get(question.getKey()))) {
        System.out.println("правильно");
        student.upValidCount();
      }else{
        System.out.println(String.format("%s, %s: %s","- не правильно","правильный ответ",answersTestMap.get(question.getKey())));
        student.upNonValidCount();
      }
    }

    System.out.println(String.format("%s %s %s: "," Результат теста студента",student.getName(),student.getFamily()));
    System.out.println(String.format("%s %d"," Количество правильных ответов:",student.getValidCount()));
    System.out.println(String.format("%s %d"," Количество не правильных ответов:",student.getNonValidCount()));
  }

  public void getTest() {

  }
}
