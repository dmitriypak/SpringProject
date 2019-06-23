package ru.projects.edu.spring.task2.service.resourceload;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import ru.projects.edu.spring.task2.config.Localize;

@Configuration
public class ResourceLoadService  implements ResourceLoaderAware {
  private ResourceLoader resourceLoader;
  private final Localize localize;

  public ResourceLoadService(Localize localize) {
    this.localize = localize;
  }

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  @Bean
  public TestLoader testLoader(){
    return new TestLoaderImpl(resourceLoader.getResource(localize.getPath()));
  }

}
