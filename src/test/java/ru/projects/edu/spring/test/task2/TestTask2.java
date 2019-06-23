package ru.projects.edu.spring.test.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.projects.edu.spring.task2.Main;
import ru.projects.edu.spring.task2.config.MessageServiceConfig;
import ru.projects.edu.spring.task2.dao.TestDao;
import ru.projects.edu.spring.task2.service.resourceload.TestLoader;

import java.io.IOException;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {Main.class, MessageServiceConfig.class})

public class TestTask2 {
  @Autowired
  private TestDao testDao;
  @Autowired
  private TestLoader testLoader;

  @BeforeEach
  public void init() throws IOException {
    testLoader.loadTest();
  }

  @DisplayName("Load Questions")
  @Test
  public void testLoadQuestions(){
    Assertions.assertTrue(testLoader.getQuestions().size()>0);
  }
}
