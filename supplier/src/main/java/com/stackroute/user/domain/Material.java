package com.stackroute.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;

@Document
public class Material {
  @Id
  private int id;
  private String category;
  private String name;
  private Image image;

  public Material(int id, String category, String name, Image image) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.image = image;
  }

  public Material() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }
}
