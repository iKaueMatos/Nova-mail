package com.email.email.modules.Mail.Application.repository;

import com.email.email.modules.Mail.Domain.model.Email;

public interface EmailService {
    public void sendEmail(Email email);
}
