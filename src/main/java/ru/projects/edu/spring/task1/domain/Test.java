package ru.projects.edu.spring.task1.domain;

import java.util.Map;
import java.util.Scanner;

public class Test {
  private String studentName;
  private String studentFamily;

  //Вопросы теста
  Map<Integer,String> questionsTestMap;
  //Ответы теста
  Map<Integer,String> answersTestMap;

  //Кол-во правильных ответов
  private int validCount = 0;

  //Кол-во не правильных ответов
  private int nonValidCount = 0;
  private String name;
  private String family;

  public Test(Map<Integer, String> questionsTestMap, Map<Integer, String> answersTestMap) {
    this.questionsTestMap = questionsTestMap;
    this.answersTestMap = answersTestMap;
  }

  public void start(){
    Scanner scanner = new Scanner(System.in);
    String line = null;
    do{
      System.out.println("Введите Имя");
    }while ((line = scanner.nextLine()).isEmpty());
    name = line;

    do{
      System.out.println("Введите Фамилию");
    }while ((line = scanner.nextLine()).isEmpty());
    family = line;

    for(Map.Entry<Integer,String>question:questionsTestMap.entrySet()){
      do{
        System.out.println(String.format("%s%d: %s","- Вопрос ",question.getKey(),question.getValue()));
      }while ((line = scanner.nextLine()).isEmpty());

      if(line.equalsIgnoreCase(answersTestMap.get(question.getKey()))) {
        System.out.println("правильно");
        validCount++;
      }else{
        System.out.println(String.format("%s, %s: %s","- не правильно","правильный ответ",answersTestMap.get(question.getKey())));
        nonValidCount++;
      }
    }

    System.out.println(String.format("%s %s %s: "," Результат теста студента",name,family));
    System.out.println(String.format("%s %d"," Количество правильных ответов:",validCount));
    System.out.println(String.format("%s %d"," Количество не правильных ответов:",nonValidCount));

  }

}
