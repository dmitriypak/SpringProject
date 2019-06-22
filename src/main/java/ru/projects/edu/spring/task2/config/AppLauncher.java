package ru.projects.edu.spring.task2.config;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.service.resourceload.LoadService;
import ru.projects.edu.spring.task2.service.student.StudentService;
import ru.projects.edu.spring.task2.service.testing.TestService;

import java.io.IOException;

@Service
public class AppLauncher {
  private final LoadService loadService;
  private final StudentService studentService;
  private final TestService testService;
  private final StudentDao studentDao;

  public AppLauncher(LoadService loadService, TestService testService, StudentService studentService, StudentDao studentDao) {
    this.loadService = loadService;
    this.testService = testService;
    this.studentService = studentService;
    this.studentDao = studentDao;
  }

  public void start() throws IOException {
    loadService.loadTest();
    if(studentService.registerStudent()){
      testService.start(studentDao.getStudent());
    }
  }
}
