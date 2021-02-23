package io.swagger.petstore.tests;

import static io.swagger.petstore.api.conditions.Conditions.statusCode;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.swagger.petstore.api.app.ApplicationManager;
import io.swagger.petstore.api.model.Category;
import io.swagger.petstore.api.model.Pet;
import io.swagger.petstore.api.model.TagsItem;
import java.util.Collections;
import org.testng.annotations.Test;

public class postPetTests extends ApplicationManager {

  @Description("Тест проверяет добавление нового питомца в бд")
  @Test
  public void testPostPet() {
    RestAssured.baseURI = config().baseUrl();
    int id = faker().random().nextInt(1000);
    Pet pet = new Pet()
        .withId(id)
        .withCategory(
            new Category()
                .withId(2)
                .withName("health"))
        .withName(faker().name().title())
        .withPhotoUrls(Collections.singletonList(faker().internet().url()))
        .withTags(Collections.singletonList(new TagsItem().withId(1).withName("health")))
        .withStatus("available");

    petApiService().postPet(pet).shouldHave(statusCode(200));

    //проверка, что питомец записался в бд
    Pet searchPet = petApiService().getPetById(String.valueOf(id))
        .shouldHave(statusCode(200))
        .asPojo(Pet.class);
    check().equalPetNewAndPetSearch(pet, searchPet);
  }
}
