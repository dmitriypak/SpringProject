package ru.projects.edu.spring.task2.domain;

public class Question {
  String question;
  String answer;
  String inputText;

  public Question(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public void setInputText(String inputText) {
    this.inputText = inputText;
  }

  public String getInputText() {
    return inputText;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }
}
