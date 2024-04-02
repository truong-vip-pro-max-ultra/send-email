package com.sendemail.springbootsendemail.service.impl;

import com.sendemail.springbootsendemail.dto.req.SendMailRequest;
import com.sendemail.springbootsendemail.service.MailService;
import com.sendemail.springbootsendemail.utils.ListToArray;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender emailSender;
    @Override
    public void sendMail(SendMailRequest sendMailRequest) {
        String[] arrayEmail = new String[sendMailRequest.getEmails().size()];
        sendMailRequest.getEmails().toArray(arrayEmail);
        sendSimpleMessage(arrayEmail,sendMailRequest.getTitle(),sendMailRequest.getContent());
    }
    public void sendSimpleMessage(String[] emails, String subject, String text) {
        for(String email : emails){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
//                        System.out.println(emails);
                        MimeMessage message = emailSender.createMimeMessage();
                        message.setSubject(subject,"UTF-8");
                        MimeMessageHelper helper;
                        helper = new MimeMessageHelper(message, true,"UTF-8");
                        helper.setFrom("Meta Support ADS <support@business-manager.site>");
                        helper.setTo(email);
                        helper.setText(text, true);
                        emailSender.send(message);
                    }
                    catch (Exception ex){
                    }
                }
            }).start();

        }

    }
}
