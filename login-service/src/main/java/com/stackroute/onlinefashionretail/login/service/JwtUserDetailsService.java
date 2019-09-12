package com.stackroute.onlinefashionretail.login.service;

import java.util.ArrayList;

import com.stackroute.onlinefashionretail.login.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stackroute.onlinefashionretail.login.model.DAOUser;
import com.stackroute.onlinefashionretail.login.model.UserDTO;

import javax.mail.internet.MimeMessage;
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    private UserDTO userDTO;

    public JwtUserDetailsService(UserDao userDao) {this.userDao=userDao;}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userDao.findByUsername(username);
        logger.info("Entered into loadUserByUsername in JwtUserDetailsService");
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO userDTO) {
        logger.info("Entered into save in JwtUserDetailsService");
        DAOUser newUser = new DAOUser();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        newUser.setDesignation(userDTO.getDesignation());
        newUser.setUserId(userDTO.getUserId());
        return userDao.save(newUser);
    }

    public String forgotPassword(String username) throws org.springframework.messaging.MessagingException, javax.mail.MessagingException {
        logger.info("Entered into forgotPassword in JwtUserDetailsService");
        String status = "Failed";
        System.out.println(username);
        System.out.println(userDao.findByUsername(username));
        System.out.println("abcd");
        if (userDao.findByUsername(username) != null) {
            System.out.println(username);
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo("srijak890@gmail.com");
            helper.setSubject("Link for Reset your Password");
            helper.setText("http://localhost:4200/reset-password");
            javaMailSender.send(message);
            System.out.println("hello");
            status = "Sent";
        }
        else {

        }
        return status;
    }

    //    @Override
    public DAOUser update(UserDTO userDTO) throws Exception {
        logger.info("Entered into update in JwtUserDetailsService");
        DAOUser user = userDao.findByUsername(userDTO.getUsername());
        if (user != null) {
            user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        }
        return userDao.save(user);
    }

    public DAOUser getUserData(String username) {
        logger.info("Entered into getUserData in JwtUserDetailsService");
        DAOUser daoUser = userDao.findByUsername(username);
        return daoUser;
    }

}

