package com.email.email.modules.Mail.Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Application.repository.EmailService;
import com.email.email.modules.Mail.Domain.model.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailServiceImp implements EmailService {
    private EmailFactory emailFactory;
    private JavaMailSender mailSender;

    @Autowired
    public EmailServiceImp(EmailFactory emailFactory, JavaMailSender mailSender) {
        this.emailFactory = emailFactory;
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(Email email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody(), true);
            // helper.setFileTypeMap(email.getBody());
            log.info("Email enviado com sucesso! : {}" + email.getTo());
        } catch(MessagingException e) {
            log.error("Ocorreu um erro ao enviar o email: {}" + email.getTo(), e.getMessage());
        }
    }
}
