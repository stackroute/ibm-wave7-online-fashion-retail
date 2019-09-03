package com.stackroute.Baseprice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.Baseprice.domain.Baseprice;
import com.stackroute.Baseprice.service.BasepriceService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BasepriceControllerTest
{

    @Autowired
    MockMvc mockMvc;

        @Mock
        BasepriceService basepriceService;

        @InjectMocks
        BasepriceController basepriceController;

        Baseprice baseprice;

        @Before
        public void setup() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(basepriceController).build();
            baseprice = new Baseprice(1,"Bhargavi", 400);

        }

    @Test
    public void saveManufactureTest() throws Exception {
        when(basepriceService.saveBaseprice(baseprice)).thenReturn(baseprice);
        mockMvc.perform(MockMvcRequestBuilders.post("/baseprice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(baseprice)))
                .andExpect(status().isCreated());
        verify(basepriceService, times(1)).saveBaseprice(Mockito.any(Baseprice.class));
        verifyNoMoreInteractions(basepriceService);
    }


    @Test
    public void getAllUsers() throws Exception{
        List<Baseprice> userslist = new ArrayList<>();
        userslist.add(baseprice);
        when(basepriceService.getAllBaseprice()).thenReturn(userslist);
        mockMvc.perform(MockMvcRequestBuilders.post("/baseprice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(baseprice)))
                .andExpect(status().isCreated());

    }

        @Test
        public void deleteUserTest() throws Exception
        {
            when(basepriceService.deleteBaseprice(1)).thenReturn(true);
            mockMvc.perform(delete("/baseprice/1")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            verify(basepriceService, times(1)).deleteBaseprice(1);
            verifyNoMoreInteractions(basepriceService);
        }

        private static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


