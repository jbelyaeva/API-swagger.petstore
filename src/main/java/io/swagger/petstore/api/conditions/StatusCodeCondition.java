package io.swagger.petstore.api.conditions;

import io.restassured.response.Response;

public class StatusCodeCondition implements Condition {

  private final int statusCode;

  public StatusCodeCondition(int statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public void check(Response response) {
    response.then().assertThat().statusCode(statusCode);
  }

  @Override
  public String toString() {
    return "статус кода " + statusCode;
  }
}
