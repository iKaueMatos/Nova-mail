/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.DTOs.transaction;

import java.util.Date;

import com.email.email.modules.Mail.Application.DTOs.customer.CustomerDTO;

public class TransactionDTO {
    private String transactionId;
    private String status;
    private double amount;
    private String methodPayment;
    private CustomerDTO customer;
    private String dateCreated;
    private Date dateUpdate;
}
