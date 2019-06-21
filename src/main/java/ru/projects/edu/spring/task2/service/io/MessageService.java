package ru.projects.edu.spring.task2.service.io;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.config.Localize;
import java.util.Scanner;

@Service
public class MessageService implements IOService{
  private final MessageSource messageSource;
  private final Localize localize;
  private static Scanner scanner = new Scanner(System.in);

  public MessageService(Localize localize, MessageSource messageSource){
    this.localize = localize;
    this.messageSource = messageSource;
  }


  @Override
  public String getMessage(String message){
    return messageSource.getMessage(message,null,localize.getLocale());
  }

  @Override
  public String getInputText(String text){
    String line = null;
    do{
      System.out.println(text);
    }while ((line = scanner.nextLine()).isEmpty());
    return line.trim();
  }

  public void print(String text) {
    System.out.println(text);
  }
}
