package ru.projects.edu.spring.task2.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.projects.edu.spring.task2.service.resourceload.LoadService;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Qualifier("testDao")
public class TestDaoImpl implements TestDao {
  private final LoadService loadService;
  private Map<Integer,String> mapQuestions;
  private Map<Integer,String> mapAnswers;

  public TestDaoImpl(LoadService loadService) {
    this.loadService = loadService;
    this.mapQuestions = loadService.getQuestions();
    this.mapAnswers = loadService.getAnswers();
  }

  @Override
  public Map<Integer, String> getQuestions() {
    return mapQuestions;
  }

  @Override
  public Map<Integer, String> getAnswers() {
    return mapAnswers;
  }

  @Override
  public void setQuestions(Map<Integer, String> mapQuestions) {

  }

  @Override
  public void setAnswers(Map<Integer, String> mapAnswers) {

  }


}
