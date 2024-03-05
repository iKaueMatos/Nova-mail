/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.notification;

import java.util.Optional;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Domain.model.Email;
import com.email.email.modules.Mail.Infra.notification.NotificationProcessingEmailHtmlContentStrategy;
import com.email.email.modules.Mail.Infra.notification.NotificationProcessingEmailSimpleContentStrategy;
import com.email.email.modules.Mail.Infra.notification.NotificationProcessingEmailWithAttachmentContentStrategy;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

public class NotificationEmailFactory implements EmailFactory {
    @Override
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body) {
        return Optional.ofNullable(type).map(template -> {
            switch (template) {
                case WITH_ATTACHMENT:
                    return createSimpleEmail(to, subject, (NotificationEmailBody) body);
                case SIMPLE:
                    return createWith_Attachment(to, subject, (NotificationEmailBody) body);
                case HTML:
                    return createHTMLEmail(to, subject, (NotificationEmailBody) body);
                default:
                    throw new IllegalArgumentException("Tipo de e-mail não suportado: " + type);
            }
        }).orElseThrow(() -> new IllegalArgumentException("Tipo de e-mail não pode ser nulo"));
    }

    private Email createSimpleEmail(String to, String subject, NotificationEmailBody body) {
        EmailContentStrategy<NotificationEmailBody> contentStrategy = new NotificationProcessingEmailSimpleContentStrategy();
        String emailContent = contentStrategy.createContent(body);
        return new Email(to, subject, emailContent);
    }

    private Email createWith_Attachment(String to, String subject, NotificationEmailBody body) {
        EmailContentStrategy<NotificationEmailBody> contentStrategy = new NotificationProcessingEmailWithAttachmentContentStrategy();
        String emailContent = contentStrategy.createContent(body);

        return new Email(to, subject, emailContent);
    }

    private Email createHTMLEmail(String to, String subject, NotificationEmailBody body) {
        EmailContentStrategy<NotificationEmailBody> contentStrategy = new NotificationProcessingEmailHtmlContentStrategy();
        String emailContent = contentStrategy.createContent(body);
        
        return new Email(to, subject, emailContent);
    }
}