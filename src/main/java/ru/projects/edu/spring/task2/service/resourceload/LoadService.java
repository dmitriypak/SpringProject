package ru.projects.edu.spring.task2.service.resourceload;

import ru.projects.edu.spring.task1.domain.Test;
import ru.projects.edu.spring.task2.dao.TestDao;

import java.io.IOException;
import java.util.Map;

public interface LoadService {
  boolean loadTest() throws IOException;
  Map<Integer,String>getQuestions();
  Map<Integer,String>getAnswers();
}
