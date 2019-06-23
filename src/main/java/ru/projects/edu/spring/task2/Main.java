package ru.projects.edu.spring.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.projects.edu.spring.task2.config.AppLauncher;

@Configuration
@ComponentScan("ru.projects.edu.spring.task2")
public class Main {
  public static void main(String[] args) throws Exception {
    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
    context.getBean(AppLauncher.class).start();
}
}
