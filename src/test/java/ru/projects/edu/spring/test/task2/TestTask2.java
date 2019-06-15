package ru.projects.edu.spring.test.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.projects.edu.spring.task2.Main;
import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.dao.TestDao;
import ru.projects.edu.spring.task2.service.resourceload.LoadService;
import ru.projects.edu.spring.task2.service.resourceload.ResourceLoadService;
import ru.projects.edu.spring.task2.service.testing.TestService;
import ru.projects.edu.spring.task2.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Main.class})

public class TestTask2 {
  @Autowired
  private TestDao testDao;
  @Autowired
  private LoadService loadService;
  @Autowired
  private ResourceLoadService resourceLoadService;
  @Autowired
  private StudentDao studentDao;
  @Autowired
  private TestService testService;
  @Autowired
  private TestUtils testUtils;

  @DisplayName("Object ResourceLoadService init")
  @Test
  public void testObjectResourceLoadServiceInit() {
    assertNotNull(resourceLoadService);
  }

  @DisplayName("Object TestDao init")
  @Test
  public void testObjectTestDaoInit() {
    assertNotNull(testDao);
  }

  @DisplayName("Object LoadService init")
  @Test
  public void testObjectLoadServiceInit() {
    assertNotNull(loadService);
  }

  @DisplayName("Object StudentDao init")
  @Test
  public void testObjectStudentDaoInit() {
    assertNotNull(studentDao);
  }

  @DisplayName("Object TestService init")
  @Test
  public void testObjectTestServiceInit() {
    assertNotNull(testService);
  }

  @DisplayName("Object TestUtils init")
  @Test
  public void testObjectTestUtilsInit() {
    assertNotNull(testUtils);
  }
}
