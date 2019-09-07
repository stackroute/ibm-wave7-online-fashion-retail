package com.stackroute.seedData;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
/**Command Line Runner is used to execute the code after the Spring Boot application started*/
public class CommandLineStartUpRunner implements CommandLineRunner {
    private TrackService trackService;

    /**
     * Use constructor based DI to inject TrackService here
     */
    @Autowired
    private CommandLineStartUpRunner(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void run(String... args) throws Exception {
        /**Pre-fill the database whenever application starts*/
        try {
            Track track10 = new Track(1, "Gonna sing", "Bad music");
            trackService.saveTrack(track10);
        } catch (TrackAlreadyExistsException exception) {
            exception.printStackTrace();
        }
    }
}
