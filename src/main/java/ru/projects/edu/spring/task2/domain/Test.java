package ru.projects.edu.spring.task2.domain;

import java.util.List;

public class Test {
  private Student student;
  private List<Question> questionsList;

  public Test(Student student, List<Question> questionsList) {
    this.student = student;
    this.questionsList = questionsList;
  }

  public Student getStudent() {
    return student;
  }

  public List<Question> getQuestionsList() {
    return questionsList;
  }
}
