package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {

    /**findBytrackName method to get track by its name*/
    public List<Track> findBytrackName(String trackName);
}
