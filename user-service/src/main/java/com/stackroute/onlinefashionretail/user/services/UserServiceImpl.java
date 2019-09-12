package com.stackroute.onlinefashionretail.user.services;

import com.stackroute.onlinefashionretail.user.domain.User;
import com.stackroute.onlinefashionretail.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        logger.info("inside saveUser in userServiceImpl");
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers()
    {
        logger.info("inside getAllUsers in userServiceImpl");
        List<User> users =userRepository.findAll();
        return users;

    }

    @Override
    public boolean deleteUser(String id ){
        try {
            logger.info("inside deleteUser try block in userServiceImpl");
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception exception)
        {
            logger.info("inside deleteUser catch block in userServiceImpl");
            return false;
        }
    }
    @Override
    public User updateUser(User user, String id)
    {
        logger.info("inside uodateUser in userServiceImpl");
        Optional<User> user1 = userRepository.findById(id);
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User findUserByEmail(String email) {
        if(email == null){
            return null;
        }
        else {
            logger.info("inside findUserByEmail in userServiceImpl");
            User user = userRepository.findUserByEmail(email);
            return user;
        }
    }


    @Override
    public List report() {
        logger.info("inside report in userServiceImpl");
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
        list.add(designerCount);
        list.add(supplierCount);
        list.add(manufacturerCount);
        return list;

    }

}
