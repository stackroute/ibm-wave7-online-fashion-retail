package com.stackroute.onlinefashionretail.user.repository;

import com.stackroute.onlinefashionretail.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User,String> {

    public User findUserByEmail(String email);
}