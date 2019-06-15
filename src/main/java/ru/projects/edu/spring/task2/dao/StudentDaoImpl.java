package ru.projects.edu.spring.task2.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.projects.edu.spring.task2.domain.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

  private Student student;

  @Override
  public Student getStudent() {
    return student;
  }

  @Override
  public void setStudent(Student student) {
    this.student = student;
  }
}
