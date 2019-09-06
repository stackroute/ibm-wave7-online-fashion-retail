package com.stackroute.login1.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.stackroute.login1.dao.UserDao;
import com.stackroute.login1.model.DAOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.stackroute.login1.config.JwtTokenUtil;
import com.stackroute.login1.model.JwtRequest;
import com.stackroute.login1.model.JwtResponse;
import com.stackroute.login1.model.UserDTO;
import com.stackroute.login1.service.JwtUserDetailsService;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

 @Autowired
    private JwtTokenUtil jwtTokenUtil;
//    @Autowired
  //UserDTO userDTO;
  //@Autowired
  //UserDao userDao;

    @Autowired
    private JwtUserDetailsService userDetailsService;

//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//        authenticate(userDTO.getUsername(),userDTO.getPassword());
//       // authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO)
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {
        authenticate(userDTO.getUsername(), userDTO.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
        DAOUser daoUser = userDetailsService.getUserData(userDTO.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        Map<Object,Object> model=new HashMap<>();
        model.put("designation",daoUser.getDesignation());
        model.put("id", daoUser.getId());
        model.put("token",token);
        return ok(model);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ok(userDetailsService.save(user));
    }

    @CrossOrigin
    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public ResponseEntity<?> getEmail(@RequestBody String username) throws Exception {
        System.out.println("in here");
        JsonFactory jsonFactory = new JsonFactory();
        ObjectMapper objectMapper = new ObjectMapper(jsonFactory);

        JsonNode rootNode = objectMapper.readTree(username);

        final String userDetails = userDetailsService.forgotPassword(rootNode.get("username").asText());
        return ok(userDetails);
    }
//    String username="kotagirisrija123@gmail.com";
//    @RequestMapping(value = "/reset-password/{username}", method = RequestMethod.PUT)
//    public ResponseEntity<?> getNewPassword(@PathVariable String username, @RequestBody String password) throws Exception {
//        ResponseEntity responseEntity;
//        responseEntity = new ResponseEntity<>(userDetailsService.update(username,userDTO), HttpStatus.OK);
//        return responseEntity;
//    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public ResponseEntity<?> getNewPassword(@RequestBody String username) throws Exception {
        System.out.println("in here");
        System.out.println(username);
        final String userDetails = userDetailsService.forgotPassword(username);
        return ResponseEntity.ok(userDetails);
    }

    public void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}


