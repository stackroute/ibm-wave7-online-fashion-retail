package com.stackroute.seedData;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component

/**@PropertySource to read a properties file*/
@PropertySource("classpath:application.properties")


/**Context Refreshed Listener is used to execute the code after the Spring Boot application started*/
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private TrackRepository trackRepository;

    /**
     * Use constructor based DI to inject TrackRepository here
     */
    @Autowired
    private ContextRefreshedListener(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    /**
     * Using Environment to get the property values
     */
    @Autowired
    private Environment environment;


    /**
     * To get the property values
     */
    @Value("${id}")
    int id;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        /**Pre-fill the database whenever application starts*/
        try {
            trackRepository.save(new Track(id, environment.getProperty("trackName"), environment.getProperty("comments")));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
