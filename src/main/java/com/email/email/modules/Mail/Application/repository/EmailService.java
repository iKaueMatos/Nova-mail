/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.repository;

import java.io.IOException;

import com.email.email.modules.Mail.Domain.model.Email;

public interface EmailService {
    public void sendEmail(Email email) throws IOException;
}
