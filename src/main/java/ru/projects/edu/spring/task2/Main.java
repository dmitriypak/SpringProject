package ru.projects.edu.spring.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.projects.edu.spring.task2.config.AppLauncher;
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
    context.getBean(AppLauncher.class).start();
  }
}
