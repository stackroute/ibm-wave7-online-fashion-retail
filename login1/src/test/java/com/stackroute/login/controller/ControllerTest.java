//package com.stackroute.login1.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.login1.Login1Application;
//import com.stackroute.login1.model.DAOUser;
//import com.stackroute.login1.service.JwtUserDetailsService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////import org.aspectj.lang.annotation.Before;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//@ContextConfiguration(classes = Login1Application.class)
//public class ControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
////    @Autowired
//    private DAOUser daouser;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @MockBean
//    private JwtUserDetailsService jwtUserDetailsService;
//
//    @InjectMocks
//    private JwtAuthenticationController jwtAuthenticationController;
//
//    private List<DAOUser> list = null;
//
//    @Before
//    public void setUp() {
//
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(jwtAuthenticationController).build();
//        daouser = new DAOUser();
//        daouser.setUsername("ascv");
//        daouser.setPassword("Jonny");
//
//        list = new ArrayList();
//
//      list.add(daouser);
//    }
//
//    @Test
//    public void saveUser() throws Exception {
//        when(jwtUserDetailsService.save(any())).thenReturn(daouser);
//        mockMvc.perform(MockMvcRequestBuilders.post("/register")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(daouser)))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
////    @Test
////    public void createAuthenticationToken() throws Exception {
////        when(jwtAuthenticationController.authenticate(any(), any())).thenReturn(daouser);
////        mockMvc.perform(MockMvcRequestBuilders.post("/")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(daouser)))
////                .andExpect(status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}