package io.swagger.petstore.tests;

import static io.swagger.petstore.api.conditions.Conditions.statusCode;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.swagger.petstore.api.app.ApplicationManager;
import java.io.IOException;
import org.testng.annotations.Test;

public class getPetByStatusTests extends ApplicationManager {

  @Description("Тест проверяет поиск питомца по статусу")
  @Test
  public void testGetPetByStatus() throws IOException {
    RestAssured.baseURI = config().baseUrl();
    String json = petApiService().getPetByStatus("available").shouldHave(statusCode(200)).asJson();
    check().listNotNull(json);
  }
}
