package io.swagger.petstore.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class TagsItem {

  @JsonProperty("name")
  private String name;

  @JsonProperty("id")
  private long id;

  public TagsItem withName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public TagsItem withId(int id) {
    this.id = id;
    return this;
  }

  public long getId() {
    return id;
  }

  @Override
  public String toString() {
    return
        "TagsItem{" +
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
    TagsItem tagsItem = (TagsItem) o;
    return id == tagsItem.id && Objects.equals(name, tagsItem.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }
}