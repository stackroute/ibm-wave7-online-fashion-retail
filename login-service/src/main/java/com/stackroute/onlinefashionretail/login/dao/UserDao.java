package com.stackroute.onlinefashionretail.login.dao;
import com.stackroute.onlinefashionretail.login.model.DAOUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {



    @Query("select u from DAOUser u where username=:username")
    DAOUser findByUsername(String username);

}
