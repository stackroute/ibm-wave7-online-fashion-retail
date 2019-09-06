package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("dummyImpl")
public class TrackDummyServiceImpl implements TrackService {
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        System.out.println("Save track");
        return null;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        System.out.println("Get track by Id");
        return null;
    }

    @Override
    public List<Track> getAllTracks() throws Exception {
        System.out.println("Get all tracks");
        return null;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        System.out.println("Delete track by id");
        return null;
    }

    @Override
    public boolean deleteAllTracks() throws Exception {
        System.out.println("Delete all tracks");
        return false;
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        System.out.println("Update track by Id");
        return null;
    }

    @Override
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
        System.out.println("Get track by name");
        return null;
    }
}
