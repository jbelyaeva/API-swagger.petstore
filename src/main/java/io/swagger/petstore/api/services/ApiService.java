package io.swagger.petstore.api.services;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.api.ProjectConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.aeonbits.owner.ConfigFactory;

public class ApiService {

  protected RequestSpecification setUp() {

    return RestAssured
        .given().contentType(ContentType.JSON)
        .filters(getFilters());
  }

  private List<Filter> getFilters() {
    ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
    if (config.logging()) {
      return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
    return Collections.emptyList();
  }
}
