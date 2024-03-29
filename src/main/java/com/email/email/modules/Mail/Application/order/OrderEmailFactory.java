
package com.email.email.modules.Mail.Application.order;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Domain.model.Email;
import com.email.email.modules.Mail.Infra.order.OrderProcessingEmailContentStrategy;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;
import com.email.email.util.reflection.FieldCopier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderEmailFactory implements EmailFactory {

    @Override
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body) {
        if (type == null) {
            throw new IllegalArgumentException("Tipo de e-mail não pode ser nulo");
        }

        OrderEmailBody orderBody = (OrderEmailBody) body;

        EmailContentStrategy<OrderEmailBody> contentStrategy = new OrderProcessingEmailContentStrategy();
        String emailContent = contentStrategy.createContent(orderBody);

        switch (type) {
            case ORDER_PENDING:
                return createOrderEmail(to, subject, orderBody, 1, emailContent);
            case ORDER_PROCESSING:
                return createOrderEmail(to, subject, orderBody, 1, emailContent);
            case ORDER_CONFIRMED:
                return createOrderEmail(to, subject, orderBody, 2, emailContent);
            case ORDER_REFUSED:
                return createOrderEmail(to, subject, orderBody, 3, emailContent);
            case ORDER_SHIPPED:
                return createOrderEmail(to, subject, orderBody, 4, emailContent);
            case ORDER_DELIVERED:
                return createOrderEmail(to, subject, orderBody, 5, emailContent);
            case ORDER_CANCELED:
                return createOrderEmail(to, subject, orderBody, 6, emailContent);
            default:
                log.error(subject, new IllegalAccessError("Tipo de e-mail não suportado!"));
                throw new IllegalArgumentException("Tipo de e-mail não suportado: " + type);
        }
    }

    private Email createOrderEmail(String to, String subject, OrderEmailBody body, int status, String emailContent) {
        if (body.getStatus() != null) {
            OrderEmailBody filteredBody = new OrderEmailBody();
            FieldCopier.copyNonNullFields(body, filteredBody);
            return new Email(to, subject, emailContent);
        } else {
            throw new IllegalArgumentException("Status do pedido não corresponde ao tipo de e-mail");
        }
    }
}
