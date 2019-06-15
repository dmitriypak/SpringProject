package ru.projects.edu.spring.task2.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.domain.Test;

import java.util.Scanner;

@Service
public class TestUtils {
  private static Scanner scanner = new Scanner(System.in);

  public static String printInputText(String text){
    String line = null;
    do{
      System.out.println(text);
    }while ((line = scanner.nextLine()).isEmpty());
    return line;
  }
}
