package com.stackroute.Baseprice.service;

import com.stackroute.Baseprice.domain.Baseprice;
import com.stackroute.Baseprice.repository.BasepriceRepository;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BasepriceServiceImplTest
{
    @Autowired
    MockMvc mockMvc;

    @Mock
    BasepriceRepository basepriceRepository;

    @InjectMocks
    BasepriceServiceImpl basepriceService;

    Baseprice baseprice;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(basepriceService).build();
        baseprice = new Baseprice(1,"Bhargavi", 777);
    }

    @Test
    public void saveManufactureTest() throws Exception
    {
        when(basepriceRepository.save(baseprice)).thenReturn(baseprice);
        Baseprice savedBaseprice = basepriceService.saveBaseprice(baseprice);
        Assert.assertEquals(baseprice, savedBaseprice);
        verify(basepriceRepository, Mockito.times(1)).save(Mockito.any(Baseprice.class));
    }

    @Test
    public void getAllManufactureTest()
    {
        List<Baseprice> list = new ArrayList<>();
        Baseprice baseprice1 = new Baseprice(1,"Bhargavi", 777);
        list.add(baseprice1);
        list.add(baseprice);
        when(basepriceRepository.findAll()).thenReturn(list);
        List<Baseprice> retrievedDetails = basepriceService.getAllBaseprice();
        Assert.assertEquals(list,retrievedDetails);
    }

}
