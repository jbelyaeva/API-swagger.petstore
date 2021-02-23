package io.swagger.petstore.api.services;

import io.qameta.allure.Step;
import io.swagger.petstore.api.assertions.AssertableResponse;
import io.swagger.petstore.api.model.Pet;

public class PetApiService extends ApiService {

  @Step("Добавляем питомца")
  public AssertableResponse postPet(Pet pet) {
    return new AssertableResponse(setup()
        .body(pet)
        .when()
        .post("/pet"));
  }

  @Step("Обновляем питомца")
  public AssertableResponse putPet(Pet pet) {
    return new AssertableResponse(setup()
        .body(pet)
        .when()
        .put("/pet"));
  }

  @Step("Ищем питомца по статусу")
  public AssertableResponse getPetByStatus(String status) {
    return new AssertableResponse(setup()
        .when()
        .get("/pet/findByStatus?status=" + status));
  }

  @Step("Ищем питомца по id")
  public AssertableResponse getPetById(String id) {
    return new AssertableResponse(setup()
        .when()
        .get("/pet/" + id));
  }

  @Step("Удаляем питомца по id")
  public AssertableResponse deletePetById(String id) {
    return new AssertableResponse(setup()
        .when()
        .delete("/pet/" + id));
  }
}
