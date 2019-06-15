package ru.projects.edu.spring.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.projects.edu.spring.task2.dao.TestDao;
import ru.projects.edu.spring.task2.service.resourceload.LoadService;
import ru.projects.edu.spring.task2.service.resourceload.ResourceLoadService;
import ru.projects.edu.spring.task2.service.student.StudentService;
import ru.projects.edu.spring.task2.service.testing.TestService;

@Configuration
@ComponentScan("ru.projects.edu.spring.task2")
public class Main {
  public static void main(String[] args) throws Exception {
    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
    LoadService loadService = context.getBean(LoadService.class);
    loadService.loadTest();
    TestService testService = context.getBean(TestService.class);
    testService.start();

  }
}
