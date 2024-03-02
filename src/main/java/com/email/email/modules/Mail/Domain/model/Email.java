package com.email.email.modules.Mail.Domain.model;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String to;
    private String subject;
    private String body;
    private File attachFile;
}
