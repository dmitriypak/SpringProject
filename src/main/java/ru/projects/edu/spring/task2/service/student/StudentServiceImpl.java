package ru.projects.edu.spring.task2.service.student;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.domain.Student;
import ru.projects.edu.spring.task2.service.io.MessageService;

@Service
public class StudentServiceImpl implements StudentService{
  private final StudentDao studentDao;
  private Student student;
  private final MessageService messageService;


  public StudentServiceImpl(StudentDao studentDao, MessageService messageService) {
    this.studentDao = studentDao;
    this.messageService = messageService;
  }

  @Override
  public boolean registerStudent() {
    String name = messageService.getInputText(String.format("%s:",messageService.getMessage("name")));
    String family = messageService.getInputText(String.format("%s:",messageService.getMessage("family")));
    student = new Student(name,family);
    studentDao.setStudent(student);
    return student!=null ? true:false;
  }
}
