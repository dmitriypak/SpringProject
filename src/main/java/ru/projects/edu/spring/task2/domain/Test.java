package ru.projects.edu.spring.task2.domain;

import org.springframework.stereotype.Component;
import ru.projects.edu.spring.task2.service.student.StudentService;

import java.util.Map;
import java.util.Scanner;

public class Test {
  Map<Integer,String> questionsTestMap;
  Map<Integer,String> answersTestMap;

  private int validCount = 0;
  private int nonValidCount = 0;
  private final Student student;

  public Test(Map<Integer, String> questionsTestMap, Map<Integer, String> answersTestMap,Student student) {
    this.questionsTestMap = questionsTestMap;
    this.answersTestMap = answersTestMap;
    this.student = student;
  }
}
