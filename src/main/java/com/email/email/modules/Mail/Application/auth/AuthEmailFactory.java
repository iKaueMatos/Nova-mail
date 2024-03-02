package com.email.email.modules.Mail.Application.auth;

import java.util.Optional;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Domain.model.Email;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthEmailFactory implements EmailFactory {

    @Override
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body) {
        return Optional.ofNullable(type).map(template -> {
            switch (template) {
                case AUTH_RESET_PASSWORD:
                    return createEmailAuthResetPassword(to, subject, (AuthEmailBody) body);
                case AUTH_USER_CREATED:
                    return createEmailAuthCreatedUser(to, subject, (AuthEmailBody) body);
                case AUTH_USER_UPDATE:
                    return createEmailAuthUserUpdate(to, subject, (AuthEmailBody) body);
                default:
                    log.error(subject, new IllegalAccessError("Tipo de e-mail não suportado!"));
                    throw new IllegalArgumentException("Tipo de e-mail não suportado: " + type);
            }
        }).orElseThrow(() -> new IllegalArgumentException("Tipo de e-mail não pode ser nulo!"));
    }

    private Email createEmailAuthResetPassword(String to, String subject, AuthEmailBody body) {
        return null;
    }

    private Email createEmailAuthCreatedUser(String to, String subject, AuthEmailBody body) {
        return null;
    }

    private Email createEmailAuthUserUpdate(String to, String subject, AuthEmailBody body) {
        return null;
    }
}
