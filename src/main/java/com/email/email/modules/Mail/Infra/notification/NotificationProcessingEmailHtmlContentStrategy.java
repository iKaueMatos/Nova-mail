package com.email.email.modules.Mail.Infra.notification;

import com.email.email.modules.Mail.Application.notification.NotificationEmailBody;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

public class NotificationProcessingEmailHtmlContentStrategy implements EmailContentStrategy<NotificationEmailBody> {

    @Override
    public String createContent(NotificationEmailBody filteredBody) {
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("Olá prezado cliente! \n");
        
        contentBuilder.append("Atenciosamente,\n");
        contentBuilder.append("Equipe de Suporte\n");
        contentBuilder.append("Nova software\n");
        return contentBuilder.toString();
    }
    
}
