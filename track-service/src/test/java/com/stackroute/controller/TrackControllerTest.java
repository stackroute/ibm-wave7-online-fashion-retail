package com.stackroute.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.Track;
import com.stackroute.exceptions.GlobalException;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit
 */
@RunWith(SpringRunner.class)
@WebMvcTest

public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Track track;
    /**
     * Create a mock for TrackService
     */
    @MockBean
    private TrackService trackService;
    /**
     * Inject the mocks as dependencies into TrackController
     */
    @InjectMocks
    private TrackController trackController;

    /**
     * Run this before each test case
     */
    private List<Track> list = null;

    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).setControllerAdvice(new GlobalException()).build();
        //act
        track = new Track();
        track.setId(100);
        track.setTrackName("Music track100");
        track.setComments("Music comment100");
        list = new ArrayList<>();
        list.add(track);
    }

    @After
    public void tearDown() {
        this.track = null;
        this.list = null;
    }

    @Test
    public void givenPostMappingUrlShouldReturnTheSavedTrack() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService saveTrack method is only called once
        verify(trackService, times(1)).saveTrack(track);

    }

    @Test
    public void givenPostMappingUrlAndTrackShouldThrowTrackAlreadyException() throws Exception {
        when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService saveTrack method is only called once
        verify(trackService, times(1)).saveTrack(track);
    }

    @Test
    public void givenGetMappingUrlShouldReturnListOfAllTracks() throws Exception {
        when(trackService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService getAllTracks method is only called once
        verify(trackService, times(1)).getAllTracks();

    }

    @Test
    public void givenGetMappingUrlWithIdShouldReturnTrackWIthThatThatId() throws Exception {
        when(trackService.getTrackById(anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService getTrackById method is only called once
        verify(trackService, times(1)).getTrackById(track.getId());
    }

    @Test
    public void givenGetMappingUrlAndIdShouldThrowTrackNotFoundException() throws Exception {
        when(trackService.getTrackById(anyInt())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/200")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService getTrackById method is not called even once
        verify(trackService, times(0)).getTrackById(track.getId());
    }


    @Test
    public void givenGetMappingUrlWithTrackNameShouldReturnTracksWithThatTrackName() throws Exception {
        when(trackService.getTrackByName(any())).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/Music track100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService getTrackByName method is only called once
        verify(trackService, times(1)).getTrackByName(track.getTrackName());
    }

    @Test
    public void givenGetMappingUrlWithTrackNameShouldReturnTrackNotFoundException() throws Exception {
        when(trackService.getTrackByName(any())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/Emo emo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
        //verify here verifies that trackService getTrackByName method is not called once
        verify(trackService, times(0)).getTrackByName(track.getTrackName());
    }

    @Test
    public void givenPutMappingUrlAndTrackShouldReturnUpdatedTrack() throws Exception {
        when(trackService.updateTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService updateTrack method is only called once
        verify(trackService, times(1)).updateTrack(track);
    }


    @Test
    public void givenPutMappingUrlAndTrackShouldReturnTrackNotFoundException() throws Exception {
        when(trackService.updateTrack(any())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());


        //verify here verifies that trackService updateTrack method is only called once
        verify(trackService, times(1)).updateTrack(track);
    }

    @Test
    public void givenDeleteMappingUrlAndTrackIdShouldReturnDeletedTrack() throws Exception {
        when(trackService.deleteTrackById(anyInt())).thenReturn(Optional.of(track));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track/100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


        //verify here verifies that trackService deleteTrackById method is only called once
        verify(trackService, times(1)).deleteTrackById(track.getId());
    }

    @Test
    public void givenDeleteMappingUrlAndTrackIdShouldThrowTrackNotFoundException() throws Exception {
        when(trackService.deleteTrackById(anyInt())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track/200")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService deleteTrackById method is only called once
        verify(trackService, times(0)).deleteTrackById(track.getId());
    }

    @Test
    public void givenDeleteMappingUrlShouldDeleteAllTracksAndReturnTrue() throws Exception {
        when(trackService.deleteAllTracks()).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/tracks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        //verify here verifies that trackService deleteAllTracks method is only called once
        verify(trackService, times(1)).deleteAllTracks();
    }

    @Test
    public void givenDeleteMappingUrlShouldReturnDeleteAllTracksAndReturnFalse() throws Exception {
        when(trackService.deleteAllTracks()).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/tracks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


        //verify here verifies that trackService deleteAllTracks method is only called once
        verify(trackService, times(1)).deleteAllTracks();
    }

    private static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
