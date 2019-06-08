package ru.projects.edu.spring.task1.service;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Класс загрузки ресурса
 */
public class ResourceLoadService implements ResourceLoaderAware {

  private ResourceLoader resourceLoader;
  //тип файла
  private String type;
  //путь
  private String path;

  public ResourceLoadService(String type, String path) {
    this.type = type;
    this.path = path;
  }

  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  public Resource getResource() {
    return resourceLoader.getResource(path);
  }
}
