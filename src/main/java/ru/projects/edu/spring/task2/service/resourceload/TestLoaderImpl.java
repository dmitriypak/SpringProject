package ru.projects.edu.spring.task2.service.resourceload;

import org.springframework.core.io.Resource;
import ru.projects.edu.spring.task2.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestLoaderImpl implements TestLoader {
  private final Resource resource;
  private final List<Question> listQuestions = new ArrayList<>();

  public TestLoaderImpl(Resource resource) {
    this.resource = resource;
  }

  @Override
  public boolean loadTest() throws IOException {
    try (InputStream is = resource.getInputStream()) {
      try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
        String line;
        while ((line = br.readLine()) != null) {
          String[] str = line.split(",");
          if (str.length < 2) continue;
          listQuestions.add(new Question(str[0],str[1]));
        }
      }
    }
    return listQuestions.size()>0 ? true:false;
  }

  @Override
  public List<Question> getQuestions() {
    return listQuestions;
  }

}
