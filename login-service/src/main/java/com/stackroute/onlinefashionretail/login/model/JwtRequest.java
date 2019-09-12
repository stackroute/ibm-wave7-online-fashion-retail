package com.stackroute.onlinefashionretail.login.model;

public class JwtRequest {
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
    private int userId;


    //need default constructor for JSON Parsing
    public JwtRequest()
    {

    }

    public JwtRequest(String username, String password,String designation,int userId) {
        this.username=username;
        this.password=password;
        this.userId=userId;
//        this.setUsername(username);
//        this.setPassword(password);

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
