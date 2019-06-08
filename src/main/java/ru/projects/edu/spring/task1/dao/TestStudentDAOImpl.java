package ru.projects.edu.spring.task1.dao;

import ru.projects.edu.spring.task1.domain.Test;
import ru.projects.edu.spring.task1.service.ResourceLoadService;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestStudentDAOImpl implements TestStudentDao {

  //Вопросы теста
  Map<Integer,String> mapQuestions = new LinkedHashMap<>();
  //Ответы теста
  Map<Integer,String> mapAnswers = new LinkedHashMap<>();

  @Override
  public Map<Integer, String> getQuestions() {

    return mapQuestions;
  }

  @Override
  public Map<Integer, String> getAnswers() {
    return mapAnswers;
  }

  public Test getTest(){
    return new Test(mapQuestions,mapAnswers);
  }

  @Override
  public void setQuestions(Map<Integer, String> mapQuestions) {
    this.mapQuestions = mapQuestions;
  }

  @Override
  public void setAnswers(Map<Integer, String> mapAnswers) {
    this.mapAnswers = mapAnswers;
  }



}
