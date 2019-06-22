package ru.projects.edu.spring.task2.service.testing;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.dao.TestDao;

import java.util.Map;


@Service
public class ValidateService {
  private final TestDao testDao;
  private Map<Integer,String> mapCorrectAnswers;

  public ValidateService(TestDao testDao) {
    this.testDao = testDao;
    mapCorrectAnswers = testDao.getAnswers();
  }

  public boolean validate(int key, String answer){
    return answer!= null && !answer.isEmpty() && answer.equalsIgnoreCase(mapCorrectAnswers.get(key));
  }
}
