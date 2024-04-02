package com.sendemail.springbootsendemail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${email.username}")
    private String emailUsername;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("cp02hn.emailserver.net.vn");
//        mailSender.setPort(587);
//        mailSender.setUsername("support@sunandskisports.us");
//        mailSender.setPassword("truongjae27");

//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("davidtrank99@gmail.com");
//        mailSender.setPassword("pqwlkoicwuuegtki");
        mailSender.setHost("cp03hn.emailserver.net.vn");
        mailSender.setPort(587);
        mailSender.setUsername("support@business-manager.site");
        mailSender.setPassword("Newpass2023@");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }
}











//    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//                mailSender.setPort(587);
//                mailSender.setUsername(emailUsername);
//                mailSender.setPassword("");
//                Properties props = mailSender.getJavaMailProperties();
//                props.put("mail.transport.protocol", "smtp");
//                props.put("mail.smtp.auth", "true");
//                props.put("mail.smtp.starttls.enable", "true");
//                props.put("mail.debug", "true");
//                return mailSender;