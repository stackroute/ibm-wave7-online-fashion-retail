package com.stackroute.user.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Mapping {

    @Id
    private String id;
    @JsonProperty("quantity")
    private double quantity;
  @JsonProperty("price")
    private double price;
  @JsonProperty("material")
    private Material material;
  @JsonProperty("supplier")
    private Supplier supplier;
  @JsonProperty("unit")
    private String unit;

  public Mapping(String id, double price, double quantity, Material material, Supplier supplier, String unit) {
    this.id = id;
    this.price = price;
    this.quantity = quantity;
    this.material = material;
    this.supplier = supplier;
    this.unit = unit;
  }

  public Mapping() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
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

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return "Mapping{" +
      "id='" + id + '\'' +
      ", quantity=" + quantity +
      ", price=" + price +
      ", material=" + material +
      ", supplier=" + supplier +
      ", unit='" + unit + '\'' +
      '}';
  }
}
