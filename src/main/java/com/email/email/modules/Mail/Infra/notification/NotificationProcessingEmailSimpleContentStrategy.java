/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Infra.notification;

import com.email.email.modules.Mail.Application.notification.NotificationEmailBody;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

public class NotificationProcessingEmailSimpleContentStrategy implements EmailContentStrategy<NotificationEmailBody> {

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
