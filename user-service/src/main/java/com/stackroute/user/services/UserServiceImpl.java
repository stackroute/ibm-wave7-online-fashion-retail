package com.stackroute.user.services;

import com.stackroute.user.domain.User;
import com.stackroute.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<User> getAllUsers()
    {
        List<User> users =userRepository.findAll();
        return users;

    }

    @Override
    public boolean deleteUser(String id ){
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
    public User updateUser(User user, String id)
    {
        Optional<User> user1 = userRepository.findById(id);

        user.setName(user.getName());
        user.setEmail(user.getEmail());

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List report() {

        int designerCount=0, supplierCount=0, manufacturerCount=0;
        List list = new ArrayList();

        List<User> users =userRepository.findAll();

        for( User user: users){
            if(user.getDesignation().equals("Designer"))
            {
                designerCount++;
            }
            else if(user.getDesignation().equals("Supplier")){
                supplierCount++;
            }
            else if (user.getDesignation().equals("Manufacturer")){
                manufacturerCount++;
            }
        }
        System.out.println("designerCount is "+designerCount);
        System.out.println("suppliercount is "+supplierCount);
        System.out.println("manufactureCount is "+manufacturerCount);

        list.add(designerCount);
        list.add(supplierCount);
        list.add(manufacturerCount);

        System.out.println(list);
        return list;

    }

}
