/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.common.Enum.mail;

public enum TemplateEmailType {
    ORDER_DELIVERED,
    ORDER_PROCESSING,
    ORDER_CONCLUDED,
    ORDER_CONFIRMED,
    ORDER_REFUSED,
    ORDER_SHIPPED,
    ORDER_CANCELED,
    AUTH_RESET_PASSWORD,
    AUTH_USER_CREATED,
    AUTH_USER_UPDATE,
    AUTH_USER_TOKEN_RESET_PASSWORD,
    TRANSACTION_PROCESSING,
    TRANSACTION_CONCLUDED,
    TRANSACTION_REFUSED,
    TRANSACTION_CANCELED,
    WITH_ATTACHMENT,
    SIMPLE,
    HTML
}
