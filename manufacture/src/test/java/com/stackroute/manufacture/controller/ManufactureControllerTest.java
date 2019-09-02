package com.stackroute.manufacture.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.manufacture.domain.Manufacture;
import com.stackroute.manufacture.services.ManufactureService;
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

public class ManufactureControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    ManufactureService manufactureService;

    @InjectMocks
    ManufactureController manufactureController;

    Manufacture manufacture;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(manufactureController).build();
        manufacture = new Manufacture(1,"Bhargavi", "bhargavi@gmail.com", "hyderabad", "clothing",5,987777777);

    }

    @Test
    public void saveManufactureTest() throws Exception {
        when(manufactureService.saveManufacture(manufacture)).thenReturn(manufacture);
        mockMvc.perform(post("/manufacture")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(manufacture)))
                .andExpect(status().isCreated());
        verify(manufactureService, times(1)).saveManufacture(Mockito.any(Manufacture.class));
        verifyNoMoreInteractions(manufactureService);
    }

    @Test
    public void getAllUsers() throws Exception{
        List<Manufacture> userslist = new ArrayList<>();
        userslist.add(manufacture);
        when(manufactureService.getAllManufactures()).thenReturn(userslist);
        mockMvc.perform(post("/manufacture")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(manufacture)))
                .andExpect(status().isCreated());

    }

    @Test
    public void deleteUserTest() throws Exception
    {
        when(manufactureService.deleteManufacture(1)).thenReturn(true);
        mockMvc.perform(delete("/manufacture/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(manufactureService, times(1)).deleteManufacture(1);
        verifyNoMoreInteractions(manufactureService);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
