package ru.projects.edu.spring.task2.service.resourceload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;

@PropertySource("classpath:application.properties")
@Configuration
public class ResourceLoadService extends AbstractFactoryBean<LoadService>  implements ResourceLoaderAware {
  private ResourceLoader resourceLoader;
  private final String type;
  private final String path;

  public ResourceLoadService(@Value("${resource.type}") String type, @Value("#{'${app.locale}' eq 'ru' ? '${resource.path}' : '${resource.path_en}'}") String path) {
    this.type = type;
    this.path = path;
  }

  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  @Override
  public Class<?> getObjectType() {
    return LoadService.class;
  }

  @Override
  protected LoadService createInstance() throws Exception {
    switch (type.toLowerCase()){
      case "csv":{
        return new CSVReadServiceImpl(resourceLoader.getResource(path));
      }
      default:
        throw new UnsupportedOperationException();
    }
  }
}
