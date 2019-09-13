package com.stackroute.onlinefashionretail.user.repository;

import com.stackroute.onlinefashionretail.user.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryTest {

        @Autowired
        UserRepository userRepository;

        User user;

        @Before
        public void setUp() {
            user = new User( "1","Sindhu", "sindhura", "sindhura@gmail.com", "designer");
            user.setUserId("1");
            user.setName("Sindhu");
            user.setName("Sindhu");
            user.setPassword("sindhura");
            user.setEmail("sindhura.gmail.com");
            user.setDesignation("designer");
        }

        @After
        public void tearDown() {
            userRepository.deleteAll();
        }

    @Test
    public void testSaveTrack(){
        userRepository.save(user);
        User fetchTrack = userRepository.findById(user.getUserId()).get();
        Assert.assertEquals("1",fetchTrack.getUserId());
    }
    @Test
    public void getAllTracks()
    {
        List<User> users = new ArrayList<>();
        User user1 = new User("2","sarah","sahasra","www.sarah.gmail.com","designer");
        users.add(user);
        users.add(user1);
        List<User> userslist = userRepository.findAll();
        Assert.assertEquals("sarah",users.get(1).getName());
    }
}
