/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Infra.auth;

import com.email.email.modules.Mail.Application.auth.AuthEmailBody;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

public class AuthProcessingEmailContentStrategy implements EmailContentStrategy<AuthEmailBody> {

    @Override
    public String createContent(AuthEmailBody filteredBody) {
        StringBuilder contentBuilder = new StringBuilder();
        
        return contentBuilder.toString();
    }
}
