package com.stackroute.Baseprice.repository;

import com.stackroute.Baseprice.domain.Baseprice;
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
        BasepriceRepository basepriceRepository;

        Baseprice baseprice;

        @Before
        public void setUp() {
            baseprice = new Baseprice( 1,"Bhargavi", 800);
            baseprice.setId(1);
            baseprice.setName("bhargavi");
            baseprice.setPrice(500);

        }

        @After
        public void tearDown() {
            basepriceRepository.deleteAll();
        }

        @Test
        public void testSaveTrack(){
            basepriceRepository.save(baseprice);
            Baseprice fetchTrack = basepriceRepository.findById(baseprice.getId()).get();
            Assert.assertEquals(1,fetchTrack.getId());
        }
        @Test
        public void getAllTracks()
        {
            List<Baseprice> users = new ArrayList<>();
            Baseprice user1 = new Baseprice(1,"sarah", 777);
            users.add(baseprice);
            users.add(user1);
            List<Baseprice> userslist = basepriceRepository.findAll();
            Assert.assertEquals("sarah",users.get(1).getName());
        }
    }


