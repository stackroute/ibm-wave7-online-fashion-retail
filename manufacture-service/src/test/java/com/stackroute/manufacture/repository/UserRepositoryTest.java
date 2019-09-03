package com.stackroute.manufacture.repository;//package com.stackroute.user.repository;

import com.stackroute.manufacture.domain.Manufacture;

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
        ManufactureRepository manufactureRepository;

        Manufacture manufacture;

        @Before
        public void setUp() {
            manufacture = new Manufacture( 1,"bhargavi", "bhargavi@gmail.com", 89000, "saree");
            manufacture.setId(1);
            manufacture.setName("bhargavi");
            manufacture.setEmail("bhargavi@gmail.com");
            manufacture.setPrice(89000);
            manufacture.setSpecifications("saree");
        }

        @After
        public void tearDown() {
            manufactureRepository.deleteAll();
        }

    @Test
    public void testSaveTrack(){
        manufactureRepository.save(manufacture);
        Manufacture fetchTrack = manufactureRepository.findById(manufacture.getId()).get();
        Assert.assertEquals(1,fetchTrack.getId());
    }
    @Test
    public void getAllTracks()
    {
        List<Manufacture> users = new ArrayList<>();
        Manufacture user1 = new Manufacture(2,"sarah","sahasra",8765,"saree");
        users.add(manufacture);
        users.add(user1);
        List<Manufacture> userslist = manufactureRepository.findAll();
        Assert.assertEquals("sarah",users.get(1).getName());
    }
}
