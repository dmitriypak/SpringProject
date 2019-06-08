package ru.projects.edu.spring.task1.dao;

import ru.projects.edu.spring.task1.domain.Test;

import java.util.Map;

public interface TestStudentDao {
  Map<Integer,String> getQuestions();
  Map<Integer,String> getAnswers();
  Test getTest();
  void setQuestions(Map<Integer,String>map);
  void setAnswers(Map<Integer,String>map);

}
