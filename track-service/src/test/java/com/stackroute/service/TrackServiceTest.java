package com.stackroute.service;


import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {

    private Track track;
    private List<Track> expectedTrackList;

    /**
     * Create a mock for TrackRepository
     */
    @Mock
    private TrackRepository trackRepository;

    /**
     * Inject the mocks as dependencies into TrackServiceImplements
     */
    @InjectMocks
    TrackServiceImpl trackServiceImplements;

    /**
     * Run this before each test case
     */
    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(1);
        track.setTrackName("Music track1");
        track.setComments("Music comment1");
        expectedTrackList = new ArrayList<>();
    }

    @After
    public void tearDown() {
        this.track = null;
        this.expectedTrackList = null;
    }

    @Test
    public void givenTrackToSaveShouldReturnSavedTrack() throws TrackAlreadyExistsException {
        //act
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackServiceImplements.saveTrack(track);
        //assert
        Assert.assertEquals(track, savedTrack);

        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository, times(1)).save(track);
    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void givenDuplicateTrackShouldReturnTrackAlreadyExistsException() throws TrackAlreadyExistsException {
        //act
        when(trackRepository.existsById((track.getId()))).thenReturn(true);
        trackServiceImplements.saveTrack(track);
        trackServiceImplements.saveTrack(track);

        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository, times(1)).save(track);

    }

    @Test
    public void givenTrackIdShouldReturnTrackWithThatId() throws TrackNotFoundException {
        //act
        when(trackRepository.existsById(track.getId())).thenReturn(true);
        when(trackRepository.findById(track.getId())).thenReturn(Optional.of(track));
        Track retrieveTrack = trackServiceImplements.getTrackById(track.getId());
        //assert
        Assert.assertEquals(track, retrieveTrack);

        //verify here verifies that trackRepository findById method is only called once
        verify(trackRepository, times(1)).findById(track.getId());

        //verify here verifies that trackRepository existsById method is only called once
        verify(trackRepository, times(1)).existsById(track.getId());


    }

    @Test(expected = TrackNotFoundException.class)
    public void givenNotExistingTrackIdShouldReturnTrackNotFoundException() throws TrackNotFoundException {
        //act
        when(trackRepository.existsById((track.getId()))).thenReturn(true);
        trackServiceImplements.getTrackById(100);

        //verify here verifies that trackRepository existsById method is only called once
        verify(trackRepository, times(1)).existsById(track.getId());
    }

    @Test
    public void givenMethodCallToGetAllTracksShouldReturnAllTracks() throws Exception {
        //act
        expectedTrackList.add(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(expectedTrackList);
        List<Track> actualTrackList = trackServiceImplements.getAllTracks();
        //assert
        Assert.assertEquals(expectedTrackList, actualTrackList);

        //verify here verifies that trackRepository findAll method is called twice
        verify(trackRepository, times(2)).findAll();
    }

    @Test
    public void givenMethodCallToDeleteAllTracksShouldReturnTrue() throws Exception {
        //act
        expectedTrackList.add(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(expectedTrackList);
        boolean boo = trackServiceImplements.deleteAllTracks();
        //assert
        Assert.assertEquals(true, boo);

        //verify here verifies that trackRepository findAll method is only called once
        verify(trackRepository, times(1)).findAll();

        //verify here verifies that trackRepository deleteAll method is only called once
        verify(trackRepository, times(1)).deleteAll();
    }


    @Test
    public void givenTrackIdShouldDeleteThatTrackANdReturnDeletedTrack() throws TrackNotFoundException {
        //act
        when(trackRepository.existsById(track.getId())).thenReturn(true);
        when(trackRepository.findById(track.getId())).thenReturn(Optional.of(track));
        trackServiceImplements.deleteTrackById(track.getId());
        //assert
        Assert.assertEquals(track, trackServiceImplements.getTrackById(track.getId()));

        //verify here verifies that trackRepository findById method is called twice
        verify(trackRepository, times(2)).findById(track.getId());

        //verify here verifies that trackRepository existsById method is called twice
        verify(trackRepository, times(2)).existsById(track.getId());

        //verify here verifies that trackRepository deleteById method is only called once
        verify(trackRepository, times(1)).deleteById(track.getId());

    }

    @Test
    public void givenTrackToUpdateShouldReturnUpdatedTrack() throws Exception {
        //act
        when(trackRepository.existsById(track.getId())).thenReturn(true);
        when(trackRepository.findById(track.getId())).thenReturn(Optional.of(track));
        Track track1 = new Track(1, "Music track1", "updated comment");
        Track updatedTrack = trackServiceImplements.updateTrack(track1);
        //assert
        Assert.assertEquals(updatedTrack, updatedTrack);

        //verify here verifies that trackRepository existsById method is only called once
        verify(trackRepository, times(1)).existsById(track.getId());

        //verify here verifies that trackRepository findById method is only called once
        verify(trackRepository, times(1)).findById(track.getId());
    }

    @Test
    public void givenTrackNameShouldReturnListOfTracksWithThatTrackName() throws TrackNotFoundException {
        //act
        expectedTrackList.add(track);
        when(trackRepository.findBytrackName(track.getTrackName())).thenReturn(expectedTrackList);
        List<Track> actualTrackList = trackServiceImplements.getTrackByName(track.getTrackName());
        //assert
        Assert.assertEquals(expectedTrackList, actualTrackList);

        //verify here verifies that trackRepository findBytrackName method is called twice
        verify(trackRepository, times(2)).findBytrackName(track.getTrackName());
    }

    @Test(expected = TrackNotFoundException.class)
    public void givenTrackNameShouldReturnTrackNotFoundException() throws TrackNotFoundException {
        when(trackRepository.findBytrackName(track.getTrackName())).thenReturn(expectedTrackList);
        trackServiceImplements.getTrackByName("aaaaaaaaaaaaaaa");

        //verify here verifies that trackRepository findBytrackName method is called once
        verify(trackRepository, times(1)).findBytrackName(track.getTrackName());
    }

}
