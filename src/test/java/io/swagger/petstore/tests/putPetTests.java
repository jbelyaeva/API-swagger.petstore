package io.swagger.petstore.tests;

import static io.swagger.petstore.api.conditions.Conditions.statusCode;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.swagger.petstore.api.app.TestBase;
import io.swagger.petstore.api.model.Category;
import io.swagger.petstore.api.model.Pet;
import io.swagger.petstore.api.model.TagsItem;
import java.util.Collections;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class putPetTests extends TestBase {

  private int id;

  @BeforeClass
  @Step("Добавляем нового питомца в бд, для последующего обновления")
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

  @Description("Тест проверяет обновление данных у созданного питомца")
  @Test
  public void testPutPet() {
    Pet petUpdate = new Pet()
        .withId(id)
        .withCategory(
            new Category()
                .withId(2)
                .withName("health"))
        .withName(app.faker().name().title())
        .withPhotoUrls(Collections.singletonList(app.faker().internet().url()))
        .withTags(Collections.singletonList(new TagsItem().withId(1).withName("health")))
        .withStatus("available");

    app.petApiService().putPet(petUpdate).shouldHave(statusCode(200));

    //проверка, что данные питомцы обновлены
    Pet searchPet = app.petApiService().getPetById(String.valueOf(id))
        .shouldHave(statusCode(200))
        .asPojo(Pet.class);
    app.check().equalPetUpdateAndPetSearch(petUpdate, searchPet);
  }
}
