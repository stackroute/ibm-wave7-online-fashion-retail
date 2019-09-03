package com.stackroute.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Supplier {

    @Id
    private int id;
    private String name;
    private String email;
    private String city;
    private String rating;


  private long contactNumber;


    public Supplier(int id, String name,String email, String city, String rating, long contactNumber ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.rating=rating;
        this.contactNumber=contactNumber;
    }


    public Supplier() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

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

     public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating;}

  public long getContactNumber() { return contactNumber; }

  public void setContactNumber(long contactNumber) { this.contactNumber = contactNumber; }

}
