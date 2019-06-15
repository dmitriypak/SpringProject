package ru.projects.edu.spring.task2.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.domain.Student;
import ru.projects.edu.spring.task2.utils.TestUtils;

@Service
public class StudentServiceImpl implements StudentService{
  private final StudentDao studentDao;
  private Student student;

  @Autowired
  public StudentServiceImpl(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  @Override
  @Bean
  public Student registerStudent() {
    String name = TestUtils.printInputText("Введите Имя");
    String family = TestUtils.printInputText("Введите Фамилию");
    student = new Student (name,family);
    studentDao.setStudent(student);
    return student;
  }
}
