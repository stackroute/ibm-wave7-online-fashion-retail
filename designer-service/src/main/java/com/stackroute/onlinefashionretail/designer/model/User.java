package com.stackroute.onlinefashionretail.designer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String name;
    private String password;
    private String email;
    private String designation;


    public User(String userId, String name, String password, String email, String designation) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.designation = designation;
    }


    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
