//package com.stackroute.login1.repository;
//
//
//import com.stackroute.login1.dao.UserDao;
//import com.stackroute.login1.model.DAOUser;
//import com.stackroute.login1.model.UserDTO;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = NONE)
//public class RepositoryTest {
//
//    @Mock
//    UserDao userDao;
//
//    DAOUser daoUser;
//
//    UserDTO userDTO;
//
//    @Before
//    public void setUp() {
//        daoUser = new DAOUser();
//        daoUser.setPassword("dwyg");
//        daoUser.setUsername("John");
//        userDTO = new UserDTO();
//        userDTO.setPassword("dwyg");
//        userDTO.setUsername("John");
//    }
//
//    @After
//    public void tearDown() {
//        userDao.deleteAll();
//    }
//
//
////    @Test
////    public void findByUsername() {
//////        userDao.findByUsername(userDTO.getUsername());
////        UserDTO fetchUser = (UserDTO) userDao.findByUsername(userDTO.getUsername());
////        Assert.assertEquals("John",fetchUser);
////
////    }
//
//    @Test
//    public void findByUsername() {
//        when(userDao.findByUsername(daoUser.getUsername())).thenReturn(daoUser);
//        Assert.assertEquals(daoUser,userDao.findByUsername(userDTO.getUsername()));
//    }
//
//
//
//
//}