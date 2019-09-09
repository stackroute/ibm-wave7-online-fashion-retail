//package com.stackroute.manufacture.service;
//
//import com.stackroute.manufacture.domain.Manufacturer;
//import com.stackroute.manufacture.repository.ManufactureRepository;
//import com.stackroute.manufacture.services.ManufactureServiceImpl;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//public class ManufacturerServiceImplTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    ManufactureRepository manufactureRepository;
//
//    @InjectMocks
//    ManufactureServiceImpl manufactureService;
//
//    Manufacturer manufacturer;
//
//    @Before
//    public void setup()
//    {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(manufactureService).build();
//      //  manufacturer = new Manufacturer(1,"Bhargavi", "bhargavi@gmail.com", "hyderabad", "clothing",5,987777777);
//
//    }
//
//    @Test
//    public void saveManufactureTest() throws Exception
//    {
//        when(manufactureRepository.save(manufacturer)).thenReturn(manufacturer);
//        Manufacturer savedManufacturer = manufactureService.saveManufacture(manufacturer);
//        Assert.assertEquals(manufacturer, savedManufacturer);
//        verify(manufactureRepository,times(1)).save(Mockito.any(Manufacturer.class));
//    }
//
//    @Test
//    public void getAllManufactureTest()
//    {
//        List<Manufacturer> list = new ArrayList<>();
//        //Manufacturer manufacturer1 = new Manufacturer(1,"Bhargavi", "bhargavi@gmail.com", "hyderabad", "clothing",5,987777777);
//
////        list.add(manufacturer1);
////        list.add(manufacturer);
////        when(manufactureRepository.findAll()).thenReturn(list);
////        List<Manufacturer> retrievedDetails = manufactureService.getAllManufactures();
////        Assert.assertEquals(list,retrievedDetails);
//    }
//}
