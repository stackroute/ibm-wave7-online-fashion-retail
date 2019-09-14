package com.stackroute.onlinefashionretail.login.controller;
import com.stackroute.onlinefashionretail.login.model.DAOUser;
import com.stackroute.onlinefashionretail.login.service.JwtUserDetailsService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.stackroute.onlinefashionretail.login.config.JwtTokenUtil;
import com.stackroute.onlinefashionretail.login.model.UserDTO;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1")
public class JwtAuthenticationController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

//    @Autowired
//    private KafkaTemplate<String, UserDetails> kafkaTemplate;
//
//    private static final String TOPIC = "Login-data";

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println("hello");
        logger.info("Entered into createAuthenticationToken in JwtAuthenticationController");
        authenticate(userDTO.getUsername(), userDTO.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
        DAOUser daoUser = userDetailsService.getUserData(userDTO.getUsername());
        System.out.println("user details"+userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);
        Map<Object,Object> model=new HashMap<>();
        logger.info("data getting from daoUser pojo in Loginuser");
        model.put("designation",daoUser.getDesignation());
        model.put("token",token);
        model.put("userId",daoUser.getUserId());
        model.put("email",daoUser.getUsername());
        model.put("name",daoUser.getName());
        System.out.println("model"+model);
     //   kafkaTemplate.send(TOPIC,userDetails);
        return ok(model);
        //new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        logger.info("Entered into saveuser method in JwtAuthenticationToken");
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    public void authenticate(String username, String password) throws Exception {
        try {
            logger.info("Entered into authentication method in jwtAuthenticationToken");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public ResponseEntity<?> getEmail(@RequestBody String username) throws Exception {
        logger.info("Entered into getEmail method in JwtAuthenticationToken");
        System.out.println(username);
        JSONObject jsonObject = new JSONObject(username);
        username = jsonObject.getString("username");
        System.out.println(username);
        final String userDetails = userDetailsService.forgotPassword(username);
        return ResponseEntity.ok(userDetails);
    }


    @RequestMapping(value = "/reset-password", method = RequestMethod.PUT)
    public ResponseEntity<?> getNewPassword(@RequestBody UserDTO userDTO) throws Exception {
        logger.info("Entered into getNewPassword in JwtAuthenticationToken");
        System.out.println(userDTO);
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<>(userDetailsService.update(userDTO), HttpStatus.OK);
        return responseEntity;
    }
}
