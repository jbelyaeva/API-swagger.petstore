package io.swagger.petstore.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Category {

  @JsonProperty("name")
  private String name;

  @JsonProperty("id")
  private long id;

  public Category withName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public Category withId(int id) {
    this.id = id;
    return this;
  }

  public long getId() {
    return id;
  }

  @Override
  public String toString() {
    return
        "Category{" +
            "name = '" + name + '\'' +
            ",id = '" + id + '\'' +
            "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return id == category.id && Objects.equals(name, category.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }
}