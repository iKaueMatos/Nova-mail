package com.email.email.modules.Mail.Domain.model;

import java.io.File;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String to;
    private String subject;
    private String body;
    private File attachFile;
    private Date date;

    public Email(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachFile = null;
    }
}
