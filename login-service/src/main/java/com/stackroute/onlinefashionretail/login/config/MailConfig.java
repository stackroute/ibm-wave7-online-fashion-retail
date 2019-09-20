
package com.stackroute.onlinefashionretail.login.config;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.mail.javamail.JavaMailSender;
        import org.springframework.mail.javamail.JavaMailSenderImpl;
        import java.util.Properties;
//config for mail
@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("ontrendmode@gmail.com");
        javaMailSender.setPassword("root@123");
        javaMailSender.setJavaMailProperties(getMailProperties());
        return javaMailSender;
    }
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.starttls.required", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.connectiontimeout", "5000");
        properties.setProperty("mail.smtp.timeout", "5000");
        properties.setProperty("mail.smtp.writetimeout", "5000");
//        properties.setProperty("mail.transport.protocol", "smtp");
//        properties.setProperty("mail.debug", "false");
        return properties;
    }
}