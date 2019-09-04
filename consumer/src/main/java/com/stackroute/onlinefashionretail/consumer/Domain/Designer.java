package com.stackroute.onlinefashionretail.consumer.Domain;

public class Designer {
    private int id;
    private long contact;
    private String name;
    private String location;
    private String email;
    private int rating;

    //no args constructor
    public Designer() {
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    //toString method
    @Override
    public String toString() {
        return "Designer{" +
                "id=" + id +
                ", contact=" + contact +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                '}';
    }
}
