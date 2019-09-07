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
            manufacture = new Manufacture( 1,"Bhargavi", "bhargavi@gmail.com", "hyderabad", "clothing",5,987777777);
            manufacture.setId(1);
            manufacture.setName("bhargavi");
            manufacture.setEmail("bhargavi@gmail.com");
            manufacture.setCity("hyderabad");
            manufacture.setSpecifications("saree");
            manufacture.setRating(5);
            manufacture.setContact_number(987777777);
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
        Manufacture user1 = new Manufacture(1,"sarah", "bhargavi@gmail.com", "hyderabad", "clothing",5,987777777);

        users.add(manufacture);
        users.add(user1);
        List<Manufacture> userslist = manufactureRepository.findAll();
        Assert.assertEquals("sarah",users.get(1).getName());
    }
}
