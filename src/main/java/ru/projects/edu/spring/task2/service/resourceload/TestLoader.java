package ru.projects.edu.spring.task2.service.resourceload;

import ru.projects.edu.spring.task2.domain.Question;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TestLoader {
  boolean loadTest() throws IOException;
  List<Question> getQuestions();
}
