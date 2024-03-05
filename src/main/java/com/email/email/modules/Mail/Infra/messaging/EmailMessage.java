/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Infra.messaging;

import java.io.File;

import com.email.email.common.Enum.mail.EmailPriority;
import com.email.email.common.Enum.mail.TemplateEmailType;

import lombok.Data;

@Data
public class EmailMessage<T> {
    private T body;
    private String to;
    private TemplateEmailType type;
    private String subject;
    private EmailPriority emailPriority;
    private File attachment;
}
