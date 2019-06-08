package ru.projects.edu.spring.task1.service;

import ru.projects.edu.spring.task1.domain.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CSVReadServiceImpl implements LoadService {
  private ResourceLoadService resourceLoadService;

  public CSVReadServiceImpl(ResourceLoadService resourceLoadService) {
    this.resourceLoadService = resourceLoadService;
  }

  @Override
  public Test getTest() {
    //Вопросы теста
    Map<Integer,String> mapQuestions = new LinkedHashMap<>();
    //Ответы теста
    Map<Integer,String> mapAnswers = new LinkedHashMap<>();
    InputStream is = null;
    BufferedReader br = null;
    try {
      is = resourceLoadService.getResource().getInputStream();
      br = new BufferedReader(new InputStreamReader(is));
      String line;
      while ((line = br.readLine()) != null) {
        String[]str = line.split(",");
        int id = 0;
        try {
          id = Integer.parseInt(str[0]);
        } catch (NumberFormatException ex) {
          System.out.println("NumberFormatException");
        }
        mapQuestions.put(Integer.valueOf(id),str[1]);
        mapAnswers.put(Integer.valueOf(id),str[2]);
      }
      br.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return new Test(mapQuestions,mapAnswers);
  }
}
