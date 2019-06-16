package ru.projects.edu.spring.task2.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.config.MessageService;
import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.domain.Student;
import ru.projects.edu.spring.task2.utils.TestUtils;

@Service
public class StudentServiceImpl implements StudentService{
  private final StudentDao studentDao;
  private Student student;
  @Autowired
  private MessageSource messageSource;
  @Autowired
  private MessageService messageService;

  @Autowired
  public StudentServiceImpl(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  @Override
  public boolean registerStudent() {
    String name = TestUtils.getInputText(messageSource.getMessage("name",null, MessageService.locale));
    String family = TestUtils.getInputText(messageSource.getMessage("family",null, MessageService.locale));
    student = new Student(name,family);
    studentDao.setStudent(student);
    return student!=null ? true:false;
  }
}
