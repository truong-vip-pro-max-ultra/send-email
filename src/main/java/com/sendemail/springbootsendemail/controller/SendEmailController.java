package com.sendemail.springbootsendemail.controller;

import com.sendemail.springbootsendemail.dto.req.SendMailRequest;
import com.sendemail.springbootsendemail.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@AllArgsConstructor
public class SendEmailController {
    private final MailService mailService;

    @PostMapping("/send")
    public void send(@RequestBody SendMailRequest sendMailRequest){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mailService.sendMail(sendMailRequest);
            }
        }).start();
    }
}
