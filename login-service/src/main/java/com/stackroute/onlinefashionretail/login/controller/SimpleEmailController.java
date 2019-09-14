package com.stackroute.onlinefashionretail.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="api/v1")
public class SimpleEmailController {
  //  private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping(value="/email")
    public String sendEmail() throws MessagingException {
      //  logger.info("Entered into sendEmail in SimpleEmailController");
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("srijak890@gmail.com");
        helper.setSubject("SpringBootApplication");
        helper.setText("Hello");
        javaMailSender.send(message);
        return "successfully sent email";
    }
}
