//package com.stackroute.manufacture.repository;//package com.stackroute.user.repository;
//
//import com.stackroute.manufacture.domain.Manufacturer;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class UserRepositoryTest {
//
//        @Autowired
//        ManufactureRepository manufactureRepository;
//
//        Manufacturer manufacturer;
//
//        @Before
//        public void setUp() {
//            manufacturer = new Manufacturer( 1,"Bhargavi", "bhargavi@gmail.com", "hyderabad", "clothing",5,987777777);
//            manufacturer.setId(1);
//            manufacturer.setName("bhargavi");
//            manufacturer.setEmail("bhargavi@gmail.com");
//            manufacturer.setCity("hyderabad");
//            manufacturer.setSpecifications("saree");
//            manufacturer.setRating(5);
//            manufacturer.setContact_number(987777777);
//        }
//
//        @After
//        public void tearDown() {
//            manufactureRepository.deleteAll();
//        }
//
//    @Test
//    public void testSaveTrack(){
//        manufactureRepository.save(manufacturer);
//        Manufacturer fetchTrack = manufactureRepository.findById(manufacturer.getId()).get();
//        Assert.assertEquals(1,fetchTrack.getId());
//    }
//    @Test
//    public void getAllTracks()
//    {
//        List<Manufacturer> users = new ArrayList<>();
//        Manufacturer user1 = new Manufacturer(1,"sarah", "bhargavi@gmail.com", "hyderabad", "clothing",5,987777777);
//
//        users.add(manufacturer);
//        users.add(user1);
//        List<Manufacturer> userslist = manufactureRepository.findAll();
//        Assert.assertEquals("sarah",users.get(1).getName());
//    }
//}
