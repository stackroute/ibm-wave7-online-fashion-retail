package com.stackroute.user.services;

import com.stackroute.user.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public boolean deleteUser(String id ) ;

    public User updateUser(User user, String id);

    public List report();

}
