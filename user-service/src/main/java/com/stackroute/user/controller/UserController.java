package com.stackroute.user.controller;

import com.stackroute.user.domain.User;
import com.stackroute.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController  
//@RequestMapping(value="api/v1")
public class UserController {

    UserService userService;
    User user= new User();
    User savedUser;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";


    //Post mapping to save the user details
    @PostMapping("user")
    public ResponseEntity<?> saveTrack(@RequestBody User user) {
        ResponseEntity responseEntity;
        try {
            savedUser=userService.saveUser(user);
            if(savedUser!=null)
                kafkaTemplate.send(TOPIC,savedUser);
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            userService.deleteUser(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> updateTrack(@RequestBody User user, @PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            userService.updateUser(user,id);
            responseEntity = new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.CREATED);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("useremail")
    public ResponseEntity<?> getByName(@RequestParam String email){
        ResponseEntity responseEntity;
        try {
            userService.findUserByEmail(email);
            responseEntity = new ResponseEntity<User>(userService.findUserByEmail(email), HttpStatus.CREATED);
        } catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @GetMapping("user/report")
    public ResponseEntity<?> getReport() {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<List>(userService.report(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
