/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.factory;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Domain.model.Email;

public interface EmailFactory {
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body);
}
