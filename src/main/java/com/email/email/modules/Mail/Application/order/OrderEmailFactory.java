package com.email.email.modules.Mail.Application.order;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.factory.EmailFactory;
import com.email.email.modules.Mail.Application.repository.EmailService;
import com.email.email.modules.Mail.Domain.model.Email;
import com.email.email.modules.Mail.Infra.order.OrderProcessingEmailContentStrategy;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderEmailFactory implements EmailFactory {
    @Autowired
    private EmailService emailService;

    @Override
    public <T> Email createEmail(TemplateEmailType type, String to, String subject, T body) {
        return Optional.ofNullable(type).map(template -> {
            switch (template) {
                case ORDER_PROCESSING:
                    return createOrderProcessingEmail(to, subject, (OrderEmailBody) body);
                case ORDER_CONFIRMED:

                default:
                    throw new IllegalArgumentException("Tipo de e-mail não suportado: " + type);
            }
        }).orElseThrow(() -> new IllegalArgumentException("Tipo de e-mail não pode ser nulo"));
    }

    private Email createOrderProcessingEmail(String to, String subject, OrderEmailBody body) {
        OrderEmailBody filteredBody = new OrderEmailBody();

        Stream<String> attributesStream = Stream.of(body.getOrderNumber(), body.getTotalValue());
        attributesStream.filter(value -> value != null && !value.isEmpty())
                .forEach(value -> {
                    if (body.getOrderNumber() != null && body.getOrderNumber().equals(value)) {
                        filteredBody.setOrderNumber(value);
                    } else if (body.getTotalValue() != null && body.getTotalValue().equals(value)) {
                        filteredBody.setTotalValue(value);
                    }
                });

        EmailContentStrategy<OrderEmailBody> contentStrategy = new OrderProcessingEmailContentStrategy();
        String emailContent = contentStrategy.createContent(filteredBody);

        return new Email(to, subject, emailContent);
    }

    /**
     * TODO -> criar função para geração de confirmação de pedido
     */
    private Email createOrderConfirmedEmail(String to, String subject, OrderEmailBody body) {

    }
}
