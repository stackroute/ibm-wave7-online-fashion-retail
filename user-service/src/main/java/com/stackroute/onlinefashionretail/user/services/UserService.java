package com.stackroute.onlinefashionretail.user.services;

import com.stackroute.onlinefashionretail.user.domain.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public boolean deleteUser(String id ) ;

    public User updateUser(User user, String id);

    public User findUserByEmail(String email);

    public List report();

}
