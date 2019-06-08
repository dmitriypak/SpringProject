package ru.projects.edu.spring.test.task1;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.projects.edu.spring.task1.service.LoadService;
import ru.projects.edu.spring.task1.service.ResourceLoadService;
import static org.junit.jupiter.api.Assertions.*;


public class TestTask1 {
  private ApplicationContext context;


  @BeforeEach
  public void init() {
    context = new ClassPathXmlApplicationContext("/spring-context.xml");
  }

  @DisplayName("Object ResourceLoadService exist")
  @Test
  public void testObjectResourceLoadServiceExist() {
    assertTrue(context.getBean("resourceLoadService") instanceof ResourceLoadService);
  }

  @DisplayName("Object LoadService exist ")
  @Test
  public void testObjectReadServiceExist() {
    assertTrue(context.getBean("csvLoadService") instanceof LoadService);
  }

  @DisplayName("Object ResourceLoadService is singleton")
  @Test
  public void testObjectResourceLoadServiceSingleton() {
    Object resourceLoader = context.getBean("resourceLoadService");
    Object resourceLoader2 = context.getBean("resourceLoadService");
    assertTrue(resourceLoader.equals(resourceLoader2));
  }
}
