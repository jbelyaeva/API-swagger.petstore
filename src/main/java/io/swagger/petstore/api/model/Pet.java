package io.swagger.petstore.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

public class Pet {

  @JsonProperty("id")
  private long id;

  @JsonProperty("photoUrls")
  private List<String> photoUrls;

  @JsonProperty("name")
  private String name;

  @JsonProperty("category")
  private Category category;

  @JsonProperty("tags")
  private List<TagsItem> tags;

  @JsonProperty("status")
  private String status;

  public Pet withPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
    return this;
  }

  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public Pet withName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public Pet withId(int id) {
    this.id = id;
    return this;
  }

  public long getId() {
    return id;
  }

  public Pet withCategory(Category category) {
    this.category = category;
    return this;
  }

  public Category getCategory() {
    return category;
  }

  public Pet withTags(List<TagsItem> tags) {
    this.tags = tags;
    return this;
  }

  public List<TagsItem> getTags() {
    return tags;
  }

  public Pet withStatus(String status) {
    this.status = status;
    return this;
  }

  public String getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "Pet{" +
        " id=" + id +
        ",photoUrls=" + photoUrls +
        ", name='" + name + '\'' +
        ", category=" + category +
        ", tags=" + tags +
        ", status='" + status + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet pet = (Pet) o;
    return id == pet.id && Objects.equals(photoUrls, pet.photoUrls)
        && Objects.equals(name, pet.name) && Objects.equals(category,
        pet.category) && Objects.equals(tags, pet.tags) && Objects.equals(status,
        pet.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, photoUrls, name, category, tags, status);
  }
}