package com.stackroute.user.domain;

import org.springframework.data.annotation.Id;


public class User {

    @Id
    private int id;
    private String name;
    private String password;
    private String email;
    private String designation;


    public User(int id, String name, String password, String email, String designation) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.designation = designation;
    }


    public User() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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

}
