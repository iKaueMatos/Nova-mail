/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.DTOs.order;

import lombok.Data;

@Data
public class OrderItem {
    private String productName;
    private int quantity;
    private double price;
}
