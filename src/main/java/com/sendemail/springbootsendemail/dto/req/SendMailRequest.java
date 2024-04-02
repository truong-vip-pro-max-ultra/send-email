package com.sendemail.springbootsendemail.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class SendMailRequest {
    private List<String> emails;
    private String title;
    private String content;
}
