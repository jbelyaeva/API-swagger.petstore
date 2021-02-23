package io.swagger.petstore.tests;

import static io.swagger.petstore.api.conditions.Conditions.bodyField;
import static io.swagger.petstore.api.conditions.Conditions.statusCode;
import static org.hamcrest.CoreMatchers.equalTo;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.swagger.petstore.api.app.TestBase;
import io.swagger.petstore.api.model.Category;
import io.swagger.petstore.api.model.Pet;
import io.swagger.petstore.api.model.TagsItem;
import java.util.Collections;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class deletePetByIdTests extends TestBase {

  public int id;

  @BeforeMethod
  @Step("Добавляем нового питомца в бд, для последующего удаления")
  public void ensurePrecondition() {
    RestAssured.baseURI = app.config().baseUrl();
    id = app.faker().random().nextInt(1000);
    Pet pet = new Pet()
        .withId(id)
        .withCategory(
            new Category()
                .withId(2)
                .withName("health"))
        .withName(app.faker().name().title())
        .withPhotoUrls(Collections.singletonList(app.faker().internet().url()))
        .withTags(Collections.singletonList(new TagsItem().withId(1).withName("health")))
        .withStatus("available");

    app.petApiService().postPet(pet).shouldHave(statusCode(200));
  }

  @Description("Тест проверяет удаление питомца из бд")
  @Test
  public void testDeletePetById() {
    app.petApiService().deletePetById(String.valueOf(id))
        .shouldHave(bodyField("message", equalTo(String.valueOf(id))));

    //проверка, что такого питомца нет в бд после удаления
    app.petApiService().getPetById(String.valueOf(id))
        .shouldHave(bodyField("message", equalTo("Pet not found")));
  }
}
