package ru.projects.edu.spring.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.projects.edu.spring.task1.dao.TestStudentDao;
import ru.projects.edu.spring.task1.domain.Test;
import ru.projects.edu.spring.task1.service.LoadService;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    LoadService loadService = (LoadService) context.getBean("csvLoadService");
    TestStudentDao testStudentDao = (TestStudentDao) context.getBean("testStudentDao");
    loadService.loadTest();
    Test test = testStudentDao.getTest();
    test.start();
  }
}
