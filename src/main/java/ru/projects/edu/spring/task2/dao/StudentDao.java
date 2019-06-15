package ru.projects.edu.spring.task2.dao;

import ru.projects.edu.spring.task2.domain.Student;

public interface StudentDao {
  Student getStudent();
  void setStudent(Student student);
}
