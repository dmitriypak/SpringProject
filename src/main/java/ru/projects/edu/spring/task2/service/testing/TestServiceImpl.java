package ru.projects.edu.spring.task2.service.testing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task2.domain.Question;
import ru.projects.edu.spring.task2.domain.Student;
import ru.projects.edu.spring.task2.domain.Test;
import ru.projects.edu.spring.task2.service.io.MessageService;
import java.util.List;

@Service
@Qualifier("testService")
public class TestServiceImpl implements TestService{
  private List<Question> listQuestions;
  private Student student;
  private final MessageService ms;
  private final ValidateService vs;

  public TestServiceImpl(MessageService messageService, ValidateService validateService){
    ms = messageService;
    vs = validateService;
  }

  @Override
  public void start(Test test) {
    student = test.getStudent();
    if(student==null){
      ms.print("Студент не зарегистрирован");
      return;
    }

    listQuestions = test.getQuestionsList();
    if(listQuestions.size()==0){
      ms.print("Тест не загружен");
      return;
    }

    for(int i = 0;i<listQuestions.size();i++){
      Question question = listQuestions.get(i);
      question.setInputText(ms.getInputText(String.format("- %s %d: %s", ms.getMessage("question"),i+1,question.getQuestion())));
      if(vs.test(question)) {
        ms.print(ms.getMessage("correct_answer"));
        student.upValidCount();
      }else{
        ms.print(String.format("- %s, %s: %s",ms.getMessage("incorrect_answer"),
            ms.getMessage("correct_answer"), question.getAnswer()));
        student.upNonValidCount();
      }
    }

    ms.print(String.format("%s %s %s: ",ms.getMessage("test_result"),
        student.getName(),student.getFamily()));
    ms.print(String.format("%s: %d",ms.getMessage("count_correct_answers"),
        student.getValidCount()));
    ms.print(String.format("%s: %d",ms.getMessage("count_incorrect_answers"),
        student.getNonValidCount()));
    String testPass = student.isTestPass()?"test_pass":"test_not_passed";
    ms.print(String.format("%s",ms.getMessage(testPass)));
  }

}
