package com.email.email.modules.Mail.Application.transaction;

import com.email.email.modules.Mail.Application.DTOs.customer.CustomerDTO;

import lombok.Data;

@Data
public class TransactionEmailBody {
    private String transactionId;
    private String status;
    private double amount;
    private String methodPayment;
    private CustomerDTO customer;
}
