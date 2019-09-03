//package com.stackroute.user.service;
//
//import com.stackroute.user.domain.Supplier;
//import com.stackroute.user.repository.SupplierRepository;
//import com.stackroute.user.services.SupplierServiceImpl;
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
//public class SupplierServiceImplTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    SupplierRepository userRepository;
//
//    @InjectMocks
//    SupplierServiceImpl userService;
//
//    Supplier user;
//
//    @Before
//    public void setup()
//    {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
//        user = new Supplier(1,"Sindhu", "sindhura", "sindhura@gmail.com", "designer");
//    }
//
//    @Test
//    public void saveUserTest() throws Exception
//    {
//        when(userRepository.save(user)).thenReturn(user);
//        Supplier savedUser = userService.saveUser(user);
//        Assert.assertEquals(user,savedUser);
//        verify(userRepository,times(1)).save(Mockito.any(Supplier.class));
//    }
//
//    @Test
//    public void getAllUsersTest()
//    {
//        List<Supplier> trackList = new ArrayList<>();
//        Supplier user1 = new Supplier(2, "sarah","sahasra","www.sarah.gmail.com","designer");
//        trackList.add(user1);
//        trackList.add(user);
//        when(userRepository.findAll()).thenReturn(trackList);
//        List<Supplier> retrievedTracks = userService.getAllUsers();
//        Assert.assertEquals(trackList,retrievedTracks);
//    }

//    @Test
//    public void deleteTrackTest()
//    {
//        Optional<User> optionalTrack = Optional.of(user);
//        when(userRepository.findById(1)).thenReturn(optionalTrack);
//        Boolean result = userService.deleteUser(1);
//        Assert.assertTrue(result);
//        verify(userRepository,times(1)).delete(Mockito.any(User.class));
//    }


//}
