package ru.projects.edu.spring.task2.config;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.service.resourceload.LoadService;
import ru.projects.edu.spring.task2.service.student.StudentService;
import ru.projects.edu.spring.task2.service.testing.TestService;

@Service
public class AppLauncher {
  private final LoadService loadService;
  private final StudentService studentService;
  private final TestService testService;

  public AppLauncher(LoadService loadService, TestService testService, StudentService studentService) {
    this.loadService = loadService;
    this.testService = testService;
    this.studentService = studentService;
  }

  public void start(){
    loadService.loadTest();
    if(studentService.registerStudent()){
      testService.start();
    }
  }
}
