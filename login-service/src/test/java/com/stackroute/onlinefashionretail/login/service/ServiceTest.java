package com.stackroute.onlinefashionretail.login.service;


import com.stackroute.onlinefashionretail.login.dao.UserDao;
import com.stackroute.onlinefashionretail.login.model.DAOUser;

import com.stackroute.onlinefashionretail.login.model.UserDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Mock
    private PasswordEncoder bcryptEncoder;

    //Inject the mocks as dependencies into UserServiceImpl
    @Mock
    JwtUserDetailsService jwtUserDetailsService;

    List<UserDTO> list = null;

    @Mock
    UserDao userDao;

    DAOUser daoUser;

    UserDTO userDTO;

    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        userDTO = new UserDTO();
        userDTO.setUsername("John");
        userDTO.setPassword("uhds");

        daoUser = new DAOUser();
        daoUser.setUsername("John");
        daoUser.setPassword("uhds");

        list = new ArrayList<>();
        list.add(userDTO);
    }

    @Test
    public void saveUserTestSuccess() {
        when(jwtUserDetailsService.save(userDTO)).thenReturn(daoUser);
        Assert.assertEquals(daoUser, jwtUserDetailsService.save(userDTO));

    }



}
