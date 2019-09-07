package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
/**
 * @Profile is to handle application configuration
 */
@Profile("service")
/**
 * use @Primary to give higher preference to a bean when there are multiple beans of the same type.
 */
@Primary
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    /**
     * Constructor based Dependency injection to inject TrackRepository here
     */
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    /**
     * Implementation of saveTrack method
     */
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        /**Throw TrackAlreadyExistsException if track already exists*/
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException();
        }
        Track savedTrack = trackRepository.save(track);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException();
        }
        return savedTrack;
    }

    /**
     * Implementation of getTrackById method
     */
    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        /**Throw TrackNotFoundException if track we want to get is not found*/
        if (trackRepository.existsById(id)) {
            Track retrieveTrackById = trackRepository.findById(id).get();
            return retrieveTrackById;
        } else {
            throw new TrackNotFoundException("Track you want to get is not found");
        }
    }

    /**
     * Implementation of getAllTracks method
     */
    @Override
    public List<Track> getAllTracks() throws Exception {
        /**Throws Exception if Database connection issue happens*/
        trackRepository.findAll();
        return trackRepository.findAll();
    }

    /**
     * Implementation of deleteTrackById method
     *
     * @return
     */
    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        /**Throw TrackNotFoundException if track we want to delete is not found*/
        if (trackRepository.existsById(id)) {
            Optional<Track> deletedTrack = trackRepository.findById(id);
            ;
            trackRepository.deleteById(id);
            return deletedTrack;
        } else {
            throw new TrackNotFoundException("Track you want to delete is not found");
        }
    }

    /**
     * Implementation of deleteAllTracks method
     */
    @Override
    public boolean deleteAllTracks() throws Exception {
        /**Throws Exception if Database connection issue happens*/
        if (trackRepository.findAll().isEmpty()) {
            return false;
        }
        trackRepository.deleteAll();
        return true;
    }


    /**
     * Implementation of updateTrack method
     */
    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        /**Throw TrackNotFoundException if track we want to update is not found*/
        if (trackRepository.existsById(track.getId())) {
            Track getTrack = trackRepository.findById(track.getId()).get();
            getTrack.setComments(track.getComments());
            return trackRepository.save(getTrack);
        } else {
            throw new TrackNotFoundException("Track you want to update is not found");
        }
    }

    /**
     * Implementation of getTrackByName method
     */
    @Override
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
        /**Throw TrackNotFoundException if track we want to get is not found*/
        if (trackRepository.findBytrackName(trackName).isEmpty()) {
            throw new TrackNotFoundException("Track you want to get is not found");
        }
        return trackRepository.findBytrackName(trackName);
    }


}
