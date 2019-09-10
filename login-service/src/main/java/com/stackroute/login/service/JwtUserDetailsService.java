package com.stackroute.login.service;

import java.util.ArrayList;

import com.stackroute.login.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stackroute.login.model.DAOUser;
import com.stackroute.login.model.UserDTO;

import javax.mail.internet.MimeMessage;
@Service
public class JwtUserDetailsService implements UserDetailsService {
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
        DAOUser user = userDao.findByusername(username);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO userDTO) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        newUser.setDesignation(userDTO.getDesignation());
        newUser.setUserId(userDTO.getUserId());
        return userDao.save(newUser);
    }

    public String forgotPassword(String username) throws org.springframework.messaging.MessagingException, javax.mail.MessagingException {
        String status = "Failed";
        System.out.println(username);
        System.out.println(userDao.findByusername(username));
        System.out.println("abcd");
        if (userDao.findByusername(username) != null) {
            System.out.println(username);
            System.out.println("efgh");
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
        DAOUser user = userDao.findByusername(userDTO.getUsername());
        if (user != null) {
            user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        }
        return userDao.save(user);
    }

}

