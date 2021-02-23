package io.swagger.petstore.api.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.swagger.petstore.api.ProjectConfig;
import io.swagger.petstore.api.assertions.Assertions;
import io.swagger.petstore.api.services.PetApiService;
import java.util.Locale;
import org.aeonbits.owner.ConfigFactory;

public class ApplicationManager {

  private final ProjectConfig config = ConfigFactory.create(ProjectConfig.class,
      System.getProperties());
  private final Faker faker = new Faker(new Locale(config.locale()));
  private final PetApiService petApiService = new PetApiService();
  private final ObjectMapper mapper = new ObjectMapper();
  private final Assertions assertions = new Assertions();

  public ApplicationManager() {
  }

  public Faker faker() {
    return faker;
  }

  public ProjectConfig config() {
    return config;
  }

  public PetApiService petApiService() {
    return petApiService;
  }

  public ObjectMapper mapper() {
    return mapper;
  }

  public Assertions check() {
    return assertions;
  }
}
