package com.email.email.modules.Mail.Domain.model;

import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String to;
    private String subject;
    private String body;
}
