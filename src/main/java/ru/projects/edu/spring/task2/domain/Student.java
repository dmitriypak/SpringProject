package ru.projects.edu.spring.task2.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Student {
  private final String name;
  private final String family;

  private int validCount = 0;
  private int nonValidCount = 0;

  private boolean testPass;

  public Student(String name, String family) {
    this.name = name;
    this.family = family;
  }

  public void upValidCount() {
    validCount++;
  }

  public void upNonValidCount() {
    nonValidCount++;
  }

  public boolean isTestPass() {
    testPass = validCount>nonValidCount;
    return testPass;
  }

  public int getValidCount() {
    return validCount;
  }

  public int getNonValidCount() {
    return nonValidCount;
  }

  public String getName() {
    return name;
  }

  public String getFamily() {
    return family;
  }
}
