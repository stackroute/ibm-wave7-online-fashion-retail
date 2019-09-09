package com.stackroute.manufacture.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.util.List;


public class Manufacturer {

    @Id
    @Column
    @JsonProperty("id")
    private String id;
    @Column
    @JsonProperty("name")
    private String name;
    @Column
    @JsonProperty("email")
    private String email;
    private String city;
    private String specifications;
    private float rating;
    private int contact_number;
    private List<ManufacturerOrder> manufacturerOrders;
    private List<BasePrice> basePrices;

  public Manufacturer() {
  }

  public Manufacturer(String id, String name, String email, String city, String specifications, float rating, int contact_number, List<ManufacturerOrder> manufacturerOrders) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.city = city;
    this.specifications = specifications;
    this.rating = rating;
    this.contact_number = contact_number;
    this.manufacturerOrders = manufacturerOrders;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getSpecifications() {
    return specifications;
  }

  public void setSpecifications(String specifications) {
    this.specifications = specifications;
  }

  public float getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public int getContact_number() {
    return contact_number;
  }

  public void setContact_number(int contact_number) {
    this.contact_number = contact_number;
  }

  public List<ManufacturerOrder> getManufacturerOrders() {
    return manufacturerOrders;
  }

  public void setManufacturerOrders(List<ManufacturerOrder> manufacturerOrders) {
    this.manufacturerOrders = manufacturerOrders;
  }

  @Override
  public String toString() {
    return "Manufacture{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", city='" + city + '\'' +
      ", specifications='" + specifications + '\'' +
      ", rating=" + rating +
      ", contact_number=" + contact_number +
      ", manufacturerOrders=" + manufacturerOrders +
      '}';
  }
}
