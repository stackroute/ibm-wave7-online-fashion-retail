//package com.stackroute.user.repository;
//
//import com.stackroute.user.domain.Supplier;
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
//public class SupplierRepositoryTest {
//
//        @Autowired
//        SupplierRepository supplierRepository;
//
//        Supplier supplier;
//
//        @Before
//        public void setUp() {
//            supplier = new Supplier( 1,"Suchita", "skanchh1@in.ibm.com", "Lucknow", "5star");
//            supplier.setId(1);
//            supplier.setName("Suchita");
//            supplier.setEmail("skanchh1@in.ibm.com");
//            supplier.setCity("Lucknow");
//            supplier.setRating("5star");
//        }
//
//        @After
//        public void tearDown() {
//            supplierRepository.deleteAll();
//        }
//
//    @Test
//    public void testSaveSupplier(){
//        supplierRepository.save(supplier);
//        Supplier fetchTrack = supplierRepository.findById(supplier.getId()).get();
//        Assert.assertEquals(1,fetchTrack.getId());
//    }
//    @Test
//    public void getAllSuppliers()
//    {
//        List<Supplier> users = new ArrayList<>();
//        Supplier supplier1 = new Supplier(2,"sarah","www.sarah.gmail.com","Delhi","3star");
//        users.add(supplier);
//        users.add(supplier1);
//        List<Supplier> userslist = supplierRepository.findAll();
//        Assert.assertEquals("sarah",users.get(1).getName());
//    }
//}
