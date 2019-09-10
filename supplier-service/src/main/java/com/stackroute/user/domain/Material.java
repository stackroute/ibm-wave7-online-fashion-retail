package com.stackroute.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;

@Document
public class Material
{
    @Id
    private String id;
    private String category;
    private String name;
    private String image;

  public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

  @Override
  public String toString() {
    return "Material{" +
      "id='" + id + '\'' +
      ", category='" + category + '\'' +
      ", name='" + name + '\'' +
      ", image='" + image + '\'' +
      '}';
  }
}
