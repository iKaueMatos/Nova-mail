/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.factory;

import com.email.email.common.Enum.mail.EmailType;
import com.email.email.modules.Mail.Application.auth.AuthEmailFactory;
import com.email.email.modules.Mail.Application.order.OrderEmailFactory;
import com.email.email.modules.Mail.Application.transaction.TransactionEmailFactory;

public class EmailFactoryProducer {
     public static EmailFactory getEmailFactory(EmailType type) {
        switch (type) {
            case ORDER:
                return new OrderEmailFactory();
            case AUTH:
                return new AuthEmailFactory();
            case TRANSACTION:
                return new TransactionEmailFactory();
            default:
                throw new IllegalArgumentException("Tipo de email não suportado: " + type);
        }
    }
}
