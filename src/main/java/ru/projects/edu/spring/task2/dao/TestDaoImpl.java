package ru.projects.edu.spring.task2.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.projects.edu.spring.task2.domain.Question;
import ru.projects.edu.spring.task2.domain.Test;
import ru.projects.edu.spring.task2.service.resourceload.TestLoader;

import java.util.List;

@Repository
@Qualifier("testDao")
public class TestDaoImpl implements TestDao {
  private final TestLoader testLoader;
  private List<Question> listQuestions;
  private final StudentDao studentDao;

  public TestDaoImpl(TestLoader testLoader,StudentDao studentDao) {
    this.testLoader = testLoader;
    this.listQuestions = testLoader.getQuestions();
    this.studentDao = studentDao;
  }


  @Override
  public Test getTest() {
    return new Test(studentDao.getStudent(),listQuestions);
  }


}
