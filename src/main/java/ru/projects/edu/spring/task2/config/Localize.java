package ru.projects.edu.spring.task2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@Component
public class Localize {
  private Locale locale;
  private final String path;

  public Localize(@Value("${app.locale}") String locale,@Value("#{'${app.locale}' eq 'ru' ? '${resource.path}' : '${resource.path_en}'}") String path) {
    this.locale = new Locale(locale);
    this.path = path;
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public String getPath() {
    return path;
  }
}
