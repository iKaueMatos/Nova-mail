package com.email.email.modules.Mail.Infra.order;

import com.email.email.modules.Mail.Application.order.OrderEmailBody;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

public class OrderProcessingEmailContentStrategy implements EmailContentStrategy<OrderEmailBody> {
    @Override
    public String createContent(OrderEmailBody filteredBody) {
        StringBuilder contentBuilder = new StringBuilder();

        contentBuilder.append("Detalhes do Pedido:").append("\n");
        contentBuilder.append("Número do Pedido: ").append(filteredBody.getOrderNumber()).append("\n");
        contentBuilder.append("Valor Total: ").append(filteredBody.getTotalValue()).append("\n");
        contentBuilder.append("\n");
        contentBuilder.append("Informações do Cliente:").append("\n");
        contentBuilder.append("Nome do Cliente: ").append(filteredBody.getCustomerName()).append("\n");
        contentBuilder.append("Endereço de Entrega: ").append(filteredBody.getDeliveryAddress()).append("\n");

        return contentBuilder.toString();
    }  
}
