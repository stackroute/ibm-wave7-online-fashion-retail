package com.stackroute.manufacture.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class BasePrice {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;
  private String name;
  private float price;

  @Override
  public String toString() {
    return "BasePrice{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", price=" + price +
      '}';
  }

  public BasePrice(String id, String name, float price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public BasePrice() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
