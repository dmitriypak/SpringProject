package ru.projects.edu.spring.task2.service.resourceload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.dao.TestDao;
import ru.projects.edu.spring.task2.dao.TestDaoImpl;

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
  public void loadTest() {
    InputStream is = null;
    BufferedReader br = null;
    try {
      is = resource.getInputStream();
      br = new BufferedReader(new InputStreamReader(is));
      String line;
      while ((line = br.readLine()) != null) {
        String[]str = line.split(",");

        if(str.length<3)continue;

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
