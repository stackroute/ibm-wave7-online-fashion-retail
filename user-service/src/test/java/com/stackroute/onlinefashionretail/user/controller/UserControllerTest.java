package com.stackroute.onlinefashionretail.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.onlinefashionretail.user.domain.User;
import com.stackroute.onlinefashionretail.user.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    User user;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user = new User("1","Sindhu", "sindhura", "sindhura@gmail.com", "designer");

    }

    @Test
    public void saveUserTest() throws Exception {
        when(userService.saveUser(user)).thenReturn(user);
        mockMvc.perform(post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(status().isCreated());
        verify(userService, times(1)).saveUser(Mockito.any(User.class));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void getAllUsers() throws Exception{
        List<User> userslist = new ArrayList<>();
        userslist.add(user);
        when(userService.getAllUsers()).thenReturn(userslist);
        mockMvc.perform(post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(status().isCreated());

    }

    @Test
    public void deleteUserTest() throws Exception
    {
        when(userService.deleteUser("1")).thenReturn(true);
        mockMvc.perform(delete("/api/v1/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(userService, times(1)).deleteUser("1");
        verifyNoMoreInteractions(userService);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
