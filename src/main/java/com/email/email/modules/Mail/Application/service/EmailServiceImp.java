/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Application.repository.EmailService;
import com.email.email.modules.Mail.Domain.model.Email;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
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
    public void sendEmail(Email email) throws IOException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody(), true);

            Multipart multipart = new MimeMultipart();

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(email.getBody(), "text/html");
            multipart.addBodyPart(messageBodyPart);

            if (email.getAttachFile() != null) {
                MimeBodyPart attachPart = new MimeBodyPart();
                DataSource source = new FileDataSource(email.getAttachFile());
                attachPart.setDataHandler(new DataHandler(source));
                attachPart.setFileName(email.getAttachFile().getName());
                multipart.addBodyPart(attachPart);
            }

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            log.error("Ocorreu um erro ao enviar o email: {}" + email.getTo(), e.getMessage());
        }
    }
}
