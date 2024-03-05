/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.transaction;

import com.email.email.modules.Mail.Application.DTOs.customer.CustomerDTO;

import lombok.Data;

@Data
public class TransactionEmailBody {
    private String transactionId;
    private int status;
    private double amount;
    private String methodPayment;
    private CustomerDTO customer;
}
