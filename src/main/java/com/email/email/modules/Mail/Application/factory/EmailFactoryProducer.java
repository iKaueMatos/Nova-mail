package com.email.email.modules.Mail.Application.factory;

import com.email.email.common.Enum.mail.EmailType;
import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Application.auth.AuthEmailFactory;
import com.email.email.modules.Mail.Application.order.OrderEmailFactory;
import com.email.email.modules.Mail.Application.stock.StockEmailFactory;
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
            case STOCK:
                return new StockEmailFactory();
            default:
                throw new IllegalArgumentException("Tipo de email não suportado: " + type);
        }
    }
}
