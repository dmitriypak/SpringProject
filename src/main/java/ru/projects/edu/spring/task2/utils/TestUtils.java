package ru.projects.edu.spring.task2.utils;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TestUtils {
  private static Scanner scanner = new Scanner(System.in);

  public static String getInputText(String text){
    String line = null;
    do{
      System.out.println(text);
    }while ((line = scanner.nextLine()).isEmpty());
    return line;
  }
}
