package com.stackroute.login.service;


import com.stackroute.login.dao.UserDao;
import com.stackroute.login.model.DAOUser;

import com.stackroute.login.model.UserDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
