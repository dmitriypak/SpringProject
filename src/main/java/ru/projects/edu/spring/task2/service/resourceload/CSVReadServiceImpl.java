package ru.projects.edu.spring.task2.service.resourceload;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CSVReadServiceImpl implements LoadService {
  private final Resource resource;
  private final Map<Integer,String> mapQuestions = new LinkedHashMap<>();
  private final Map<Integer,String> mapAnswers = new LinkedHashMap<>();

  public CSVReadServiceImpl(Resource resource) {
    this.resource = resource;
  }

  @Override
  public boolean loadTest() throws IOException {
    try (InputStream is = resource.getInputStream()) {
      try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
        String line;
        int id = 0;
        while ((line = br.readLine()) != null) {
          String[] str = line.split(",");
          if (str.length < 2) continue;
          id++;
          mapQuestions.put(Integer.valueOf(id), str[0]);
          mapAnswers.put(Integer.valueOf(id), str[1]);
        }
      }
    }
    return mapQuestions.size()>0 && mapAnswers.size()>0 ? true:false;
  }

  @Override
  public Map<Integer, String> getQuestions() {
    return mapQuestions;
  }

  @Override
  public Map<Integer, String> getAnswers() {
    return mapAnswers;
  }
}
