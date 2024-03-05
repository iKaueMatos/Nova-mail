/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.auth;

import lombok.Data;

@Data
public class AuthEmailBody {
    private String name;
    private String email;
    private String username;
    private String passwordResetToken;

    public AuthEmailBody(String email, String username) {
        this.email = email;
        this.username = username;
        this.passwordResetToken = null;
    }
}