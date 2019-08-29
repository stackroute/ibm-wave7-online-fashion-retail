package com.stackroute.manufacture.service;

import com.stackroute.manufacture.domain.Manufacture;
import com.stackroute.manufacture.repository.ManufactureRepository;
import com.stackroute.manufacture.services.ManufactureServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ManufactureServiceImplTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    ManufactureRepository manufactureRepository;

    @InjectMocks
    ManufactureServiceImpl manufactureService;

    Manufacture manufacture;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(manufactureService).build();
        manufacture = new Manufacture(1,"Sindhu", "sindhura", 8000, "lehenga");
    }

    @Test
    public void saveManufactureTest() throws Exception
    {
        when(manufactureRepository.save(manufacture)).thenReturn(manufacture);
        Manufacture savedManufacture = manufactureService.saveManufacture(manufacture);
        Assert.assertEquals(manufacture, savedManufacture);
        verify(manufactureRepository,times(1)).save(Mockito.any(Manufacture.class));
    }

    @Test
    public void getAllManufactureTest()
    {
        List<Manufacture> list = new ArrayList<>();
        Manufacture manufacture1 = new Manufacture(2, "sarah","sahasra",3000,"lehenga");
        list.add(manufacture1);
        list.add(manufacture);
        when(manufactureRepository.findAll()).thenReturn(list);
        List<Manufacture> retrievedDetails = manufactureService.getAllManufactures();
        Assert.assertEquals(list,retrievedDetails);
    }

//    @Test
//    public void deleteTrackTest()
//    {
//        Optional<User> optionalTrack = Optional.of(user);
//        when(userRepository.findById(1)).thenReturn(optionalTrack);
//        Boolean result = userService.deleteUser(1);
//        Assert.assertTrue(result);
//        verify(userRepository,times(1)).delete(Mockito.any(User.class));
//    }


}
