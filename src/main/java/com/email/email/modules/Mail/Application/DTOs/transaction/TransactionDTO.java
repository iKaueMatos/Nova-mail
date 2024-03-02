package com.email.email.modules.Mail.Application.DTOs.transaction;

import com.email.email.modules.Mail.Application.DTOs.customer.CustomerDTO;

public class TransactionDTO {
    private String transactionId;
    private String status;
    private double amount;
    private String methodPayment;
    private CustomerDTO customer;
    private String dateCreated;
    private String dateUpdate;
}
