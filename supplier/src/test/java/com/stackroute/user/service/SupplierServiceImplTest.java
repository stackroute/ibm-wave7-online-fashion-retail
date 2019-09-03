package com.stackroute.user.service;

import com.stackroute.user.domain.Supplier;
import com.stackroute.user.repository.SupplierRepository;
import com.stackroute.user.services.SupplierServiceImpl;
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
import java.util.Optional;

import static org.mockito.Mockito.*;

public class SupplierServiceImplTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    SupplierRepository supplierRepository;

    @InjectMocks
    SupplierServiceImpl supplierService;

    Supplier supplier;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(supplierService).build();
        supplier = new Supplier(1,"Suchita", "skanchh1@in.ibm.com", "Lucknow", "5tar");
    }

    @Test
    public void saveUserTest() throws Exception
    {
        when(supplierRepository.save(supplier)).thenReturn(supplier);
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        Assert.assertEquals(supplier,savedSupplier);
        verify(supplierRepository,times(1)).save(Mockito.any(Supplier.class));
    }

    @Test
    public void getAllUsersTest()
    {
        List<Supplier> supplierList = new ArrayList<>();
        Supplier user1 = new Supplier(2, "sarah","www.sarah.gmail.com","Delhi","3star");
        supplierList.add(user1);
        supplierList.add(supplier);
        when(supplierRepository.findAll()).thenReturn(supplierList);
        List<Supplier> retrievedTracks = supplierService.getAllSuppliers();
        Assert.assertEquals(supplierList,retrievedTracks);
    }

//    @Test
//    public void deleteTrackTest()
//    {
//        Optional<Supplier> optionalSupplier = Optional.of(supplier);
//        when(supplierRepository.findById(1)).thenReturn(optionalSupplier);
//        Boolean result = supplierService.deleteSupplier(1);
//        Assert.assertTrue(result);
//        verify(supplierRepository,times(1)).delete(Mockito.any(Supplier.class));
//    }


}
