/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Infra.messaging;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Application.repository.EmailService;
import com.email.email.modules.Mail.Domain.model.Email;

@Component
public class EmailConsumer {
    private EmailService emailService;
    private EmailFactory emailFactory;
    
    @Autowired
    public EmailConsumer(EmailService emailService, EmailFactory emailFactory) {
        this.emailService = emailService;
        this.emailFactory = emailFactory;
    }

    @RabbitListener(queues = "email-queue")
    public void processEmail(@Payload EmailMessage emailMessage) throws IOException {
        Email email = emailFactory.createEmail(
            emailMessage.getType(),
            emailMessage.getTo(),
            emailMessage.getSubject(),
            emailMessage.getBody()
        );

        emailService.sendEmail(email);
    }
}
