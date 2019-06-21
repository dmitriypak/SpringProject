package ru.projects.edu.spring.test.task2;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.projects.edu.spring.task2.Main;
import ru.projects.edu.spring.task2.config.AppLauncher;
import ru.projects.edu.spring.task2.config.MessageServiceConfig;
import ru.projects.edu.spring.task2.dao.StudentDao;
import ru.projects.edu.spring.task2.dao.TestDao;
import ru.projects.edu.spring.task2.domain.Student;
import ru.projects.edu.spring.task2.service.io.MessageService;
import ru.projects.edu.spring.task2.service.resourceload.LoadService;
import ru.projects.edu.spring.task2.service.resourceload.ResourceLoadService;
import ru.projects.edu.spring.task2.service.student.StudentService;
import ru.projects.edu.spring.task2.service.testing.TestService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {Main.class, MessageServiceConfig.class})

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
  private AppLauncher appLauncher;
  @Autowired
  private MessageSource messageSource;
  @Autowired
  private MessageService messageService;
  @Autowired
  private StudentService studentService;
  @Autowired
  private PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer;

  @BeforeEach
  public void init() throws IOException {
    loadService.loadTest();
  }

  @DisplayName("Load Answers")
  @Test
  public void testLoadAnswers(){
    Assertions.assertTrue(loadService.getAnswers().size()>0);
  }

  @DisplayName("Load Questions")
  @Test
  public void testLoadQuestions(){
    Assertions.assertTrue(loadService.getQuestions().size()>0);
  }
}
