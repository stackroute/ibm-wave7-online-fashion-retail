package com.stackroute.login1.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.login1.model.DAOUser;
@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

    @Query("select u from DAOUser u where username=:username")
    DAOUser findByusername(String username);

}
