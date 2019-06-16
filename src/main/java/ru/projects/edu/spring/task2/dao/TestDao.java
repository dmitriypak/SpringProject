package ru.projects.edu.spring.task2.dao;

import java.util.Map;

public interface TestDao {
  Map<Integer,String> getQuestions();
  Map<Integer,String> getAnswers();
  void setQuestions(Map<Integer,String>mapQuestions);
  void setAnswers(Map<Integer,String>mapAnswers);

}
