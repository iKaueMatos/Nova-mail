package com.email.email.modules.Mail.Application.transaction;

import java.util.Optional;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Domain.model.Email;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionEmailFactory implements EmailFactory {
    
    @Override
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body) {
        return Optional.ofNullable(type).map(template -> {
            switch (template) {
                case TRANSACTION_PROCESSING:
                    return processingTransactioneEmail(to, subject, (TransactionEmailBody) body);
                case TRANSACTION_CONCLUDED:
                    return transactionConcludedEmail(to, subject, (TransactionEmailBody) body);
                case TRANSACTION_REFUSED:
                    return transactionRefusedEmail(to, subject, (TransactionEmailBody) body);
                default:
                    log.error(subject, new IllegalAccessError("Tipo de e-mail não suportado!"));
                    throw new IllegalArgumentException("Tipo de e-mail não suportado: " + type);
            }
        }).orElseThrow(() -> new IllegalArgumentException("Tipo de e-mail não pode ser nulo!"));
    }

    private Email processingTransactioneEmail(String to, String subject, TransactionEmailBody body) {
        return null;
    }

    private Email transactionConcludedEmail(String to, String subject, TransactionEmailBody body) {
        return null;
    }

    private Email transactionRefusedEmail(String to, String subject, TransactionEmailBody body) {
        return null;
    }
}
