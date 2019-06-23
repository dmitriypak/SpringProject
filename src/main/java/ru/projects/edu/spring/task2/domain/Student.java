package ru.projects.edu.spring.task2.domain;

public class Student {
  private final String name;
  private final String family;

  private int validCount = 0;
  private int nonValidCount = 0;

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
    return validCount>nonValidCount;
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
