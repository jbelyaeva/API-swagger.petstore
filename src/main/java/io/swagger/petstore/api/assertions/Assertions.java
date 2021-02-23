package io.swagger.petstore.api.assertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.swagger.petstore.api.model.Pet;
import java.util.List;

public class Assertions {

  public ObjectMapper mapper = new ObjectMapper();

  @Step("Проверяем, что список объектов в ответе не пустой")
  public void listNotNull(String json) throws JsonProcessingException {
    List<Pet> list = mapper.readValue(json, new TypeReference<List<Pet>>() {});
    assertThat(list.size(), not(0));
  }

  @Step("Проверяем, что данные питомца действительно обновились: поиск по id выдал единственного "
      + "питомца с обновленными данными")
  public void equalPetUpdateAndPetSearch(Pet petUpdate, Pet petSearch) {
    assertThat(petUpdate, equalTo(petSearch));
  }

  @Step("Проверяем, что новый питомец присутствует в базе: поиск по id выдал единственного "
      + "питомца с изначально передаваемыми данными")
  public void equalPetNewAndPetSearch(Pet petNew, Pet petSearch) {
    assertThat(petNew, equalTo(petSearch));
  }
}
