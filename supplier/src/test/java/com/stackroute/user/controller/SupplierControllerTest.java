//package com.stackroute.user.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.user.domain.Supplier;
//import com.stackroute.user.services.SupplierService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class SupplierControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    SupplierService supplierService;
//
//    @InjectMocks
//    SupplierController supplierController;
//
//    Supplier supplier;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(supplierController).build();
//        supplier = new Supplier(1,"Suchita", "skanchh1@in.ibm.com", "Lucknow", "5star");
//
//    }
//
//    @Test
//    public void saveSupplierTest() throws Exception {
//        when(supplierService.saveSupplier(supplier)).thenReturn(supplier);
//        mockMvc.perform(post("/supplier")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(supplier)))
//                .andExpect(status().isCreated());
//        verify(supplierService, times(1)).saveSupplier(Mockito.any(Supplier.class));
//        verifyNoMoreInteractions(supplierService);
//    }
//
//    @Test
//    public void getAllSuppliers() throws Exception{
//        List<Supplier> supplierList = new ArrayList<>();
//        supplierList.add(supplier);
//        when(supplierService.getAllSuppliers()).thenReturn(supplierList);
//        mockMvc.perform(post("/supplier")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(supplier)))
//                .andExpect(status().isCreated());
//
//    }
//
//    @Test
//    public void deleteSupplierTest() throws Exception
//    {
//        when(supplierService.deleteSupplier(1)).thenReturn(true);
//        mockMvc.perform(delete("/supplier/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//        verify(supplierService, times(1)).deleteSupplier(1);
//        verifyNoMoreInteractions(supplierService);
//    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
