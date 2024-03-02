package com.email.email.modules.Mail.Application.DTOs.order;

import lombok.Data;

@Data
public class OrderItem {
    private String productName;
    private int quantity;
    private double price;
}
