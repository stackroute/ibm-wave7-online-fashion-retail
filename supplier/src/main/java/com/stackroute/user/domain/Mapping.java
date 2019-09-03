package com.stackroute.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Mapping {

  @Id
  private int id;
  private String Quantity;
  private int price;
  private Material material;
  private Supplier supplier;

  public Mapping(int id, String quantity, int price, Material material, Supplier supplier) {
    this.id = id;
    this.Quantity = quantity;
    this.price = price;
    this.material = material;
    this.supplier = supplier;
  }

  public Mapping()
  {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getQuantity() {
    return this.Quantity;
  }

  public void setQuantity(String quantity) {
    this.Quantity = quantity;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  @Override
  public String toString() {
    return "Mapping{" +
      "id=" + id +
      ", Quantity='" + Quantity + '\'' +
      ", price=" + price +
      ", material=" + material +
      ", supplier=" + supplier +
      '}';
  }
}
