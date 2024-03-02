package com.email.email.modules.Mail.Application.transaction;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Domain.model.Email;
import com.email.email.util.reflection.FieldCopier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionEmailFactory implements EmailFactory {
    
    @Override
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body) {
        if (type == null) {
            throw new IllegalArgumentException("Tipo de e-mail não pode ser nulo");
        }

        TransactionEmailBody transactionBody = (TransactionEmailBody) body;
        switch (type) {
            case TRANSACTION_PROCESSING:
                return createTransactionEmail(to, subject, transactionBody, "em processamento");
            case TRANSACTION_CONCLUDED:
                return createTransactionEmail(to, subject, transactionBody, "concluída");
            case TRANSACTION_REFUSED:
                return createTransactionEmail(to, subject, transactionBody, "recusada");
            default:
                log.error(subject, new IllegalAccessError("Tipo de e-mail não suportado!"));
                throw new IllegalArgumentException("Tipo de e-mail não suportado: " + type);
        }
    }

    private Email createTransactionEmail(String to, String subject, TransactionEmailBody body, String status) {
        if (body.getStatus() != null && body.getStatus().equalsIgnoreCase(status)) {
            TransactionEmailBody filteredBody = new TransactionEmailBody();
            FieldCopier.copyNonNullFields(body, filteredBody);
            String emailContent = "Conteúdo do e-mail de transação " + status;
            return new Email(to, subject, emailContent);
        } else {
            throw new IllegalArgumentException("Status da transação não corresponde ao tipo de e-mail");
        }
    }
}
