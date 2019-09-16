package com.stackroute.onlinefashionretail.user.controller;

import com.stackroute.onlinefashionretail.user.domain.User;
import com.stackroute.onlinefashionretail.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController  
@RequestMapping(value="api/v1")
public class UserController {

    UserService userService;
    User user= new User();
    User savedUser;

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    //Post mapping to save the user details
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        try {
            logger.info("inside saveUser try block in UserController ");
            savedUser=userService.saveUser(user);
            if(savedUser!=null)
                kafkaTemplate.send(TOPIC,savedUser);
            responseEntity = new ResponseEntity<>(savedUser, HttpStatus.CREATED);
            if(savedUser!=null) {
                logger.info("sending data on kafka: "+savedUser.toString());
                kafkaTemplate.send(TOPIC, savedUser);
            }
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.info("inside saveUser catch block in UserController, error: "+ ex.toString());
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user/exists")
    public ResponseEntity<?> checkUser(@RequestParam String email){
        if (userService.findUserByEmail(email) != null)
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser() {
        ResponseEntity responseEntity;

        try {
            logger.info("inside getAllUser try block in UserController ");
            responseEntity = new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("inside getAllUser catch block in UserController ");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            userService.deleteUser(id);
            logger.info("inside deleteUser try block in UserController ");
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("inside deleteUser catch block in UserController ");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            logger.info("inside updateuser try block in UserController");
            userService.updateUser(user,id);
            responseEntity = new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.CREATED);
        } catch (Exception exception1) {
            logger.info("inside updateuser catch block in UserController");
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("useremail")
    public ResponseEntity<?> getByName(@RequestParam String email){
        ResponseEntity responseEntity;
        try {
            logger.info("inside getByName try block in UserController");
            userService.findUserByEmail(email);
            responseEntity = new ResponseEntity<User>(userService.findUserByEmail(email), HttpStatus.CREATED);
        } catch (Exception e){
            logger.info("inside getByName catch block in UserController");
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @GetMapping("user/report")
    public ResponseEntity<?> getReport() {
        ResponseEntity responseEntity;
        try {
            logger.info("inside getReport try block in UserController");
            responseEntity = new ResponseEntity<List>(userService.report(), HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("inside getReport catch block in UserController");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
