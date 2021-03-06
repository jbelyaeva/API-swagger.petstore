package io.swagger.petstore.api.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.swagger.petstore.api.conditions.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertableResponse {

  Logger logger = LoggerFactory.getLogger(AssertableResponse.class);

  private final Response response;

  public AssertableResponse(Response register) {
    this.response = register;
  }

  @Step("проверка, что {condition}")
  public AssertableResponse shouldHave(Condition condition) {
    logger.info("Проверка, что {}", condition);
    condition.check(response);
    return this;
  }

  public <T> T asPojo(Class<T> tClass) {
    return response.as(tClass);
  }

  public String asJson() {
    return response.asString();
  }
}
