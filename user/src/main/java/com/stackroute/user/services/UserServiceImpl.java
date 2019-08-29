package com.stackroute.user.services;

import com.stackroute.user.domain.User;
import com.stackroute.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(int id ){
      // Optional<User> user1 = userRepository.findById(id);

        try {

            userRepository.deleteById(id);

            return true;

        }
        catch (Exception exception)
        {
            return false;
        }
    }
    @Override
    public User updateUser(User user, int id)
    {
        Optional<User> user1 = userRepository.findById(id);

        user.setName(user.getName());
        user.setEmail(user.getEmail());

        User savedUser = userRepository.save(user);
        return savedUser;
    }

}
