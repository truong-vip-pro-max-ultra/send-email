package com.sendemail.springbootsendemail.service;

import com.sendemail.springbootsendemail.dto.req.SendMailRequest;

import java.util.List;

public interface MailService {
    void sendMail(SendMailRequest sendMailRequest);
}
