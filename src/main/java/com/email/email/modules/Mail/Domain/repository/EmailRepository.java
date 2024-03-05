/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Domain.repository;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Domain.model.Email;

public interface EmailRepository {
    public Email createEmail(TemplateEmailType type, String to, String subject, String body);
}
