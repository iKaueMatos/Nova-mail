/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.auth;

import java.util.function.Function;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Domain.model.Email;
import com.email.email.shared.container.resetPassword.GenerateRandomCodeResetPasswordProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthEmailFactory implements EmailFactory {

    @Override
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body) {
        if (type == null) {
            throw new IllegalArgumentException("Tipo de e-mail não pode ser nulo!");
        }

        switch (type) {
            case AUTH_RESET_PASSWORD:
                return createEmail(to, subject, (AuthEmailBody) body, this::createEmailAuthResetPassword);
            case AUTH_USER_CREATED:
                return createEmail(to, subject, (AuthEmailBody) body, this::createEmailAuthCreatedUser);
            case AUTH_USER_UPDATE:
                return createEmail(to, subject, (AuthEmailBody) body, this::createEmailAuthUserUpdate);
            case AUTH_USER_TOKEN_RESET_PASSWORD:
                return createEmail(to, subject, (AuthEmailBody) body, this::createEmailAuthResetPasswordToken);
            default:
                log.error(subject, new IllegalAccessError("Tipo de e-mail não suportado!"));
                throw new IllegalArgumentException("Tipo de e-mail não suportado: " + type);
        }
    }

    private <T> Email createEmail(String to, String subject, T body, Function<T, Email> creator) {
        return creator.apply(body);
    }

    private Email createEmailAuthResetPassword(AuthEmailBody body) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Olá,\n\nVocê solicitou uma redefinição de senha. ");
        stringBuilder.append("Clique no link abaixo para redefinir sua senha:\n\n");
        stringBuilder.append("LINK_PARA_REDEFINICAO\n\n");
        stringBuilder.append("Se você não solicitou uma redefinição de senha, ignore este e-mail.\n\n");
        stringBuilder.append("Atenciosamente,\n Equipe de Suporte Nova software");

        String content = stringBuilder.toString();
        
        return new Email(body.getEmail(), "Redefinição de Senha", content);
    }

    private Email createEmailAuthResetPasswordToken(AuthEmailBody body) {
        String token = new GenerateRandomCodeResetPasswordProvider().generateRandomCode();
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Olá,\n\nVocê solicitou uma redefinição de senha. ");
        stringBuilder.append("Estamos encaminhando o token de verificação:\n\n");
        stringBuilder.append(token);
        stringBuilder.append("Se você não solicitou uma redefinição de senha, ignore este e-mail.\n\n");
        stringBuilder.append("Atenciosamente,\n Equipe de Suporte Nova Software");
        
        String content = stringBuilder.toString();

        return new Email(body.getEmail(), "Token de Redefinição de senha", content);
    }

    private Email createEmailAuthCreatedUser(AuthEmailBody body) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Olá, ").append(body.getName()).append(",\n\nSua conta foi criada com sucesso!");
        stringBuilder.append("Agora você pode acessar nosso serviço com suas credenciais.\n\n");
        stringBuilder.append("Atenciosamente,\n Equipe de Suporte Nova software");
        
        String content = stringBuilder.toString();

        return new Email(body.getEmail(), "Conta Criada", content);
    }

    private Email createEmailAuthUserUpdate(AuthEmailBody body) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Olá, ").append(body.getName()).append("\n\nSuas informações de usuário foram atualizadas com sucesso.\n\n");
        stringBuilder.append("Atenciosamente,\n Equipe de Suporte Nova software");

        String content = stringBuilder.toString();
        
        return new Email(body.getEmail(), "Atualização de informações pessoais", content);
    }
}
