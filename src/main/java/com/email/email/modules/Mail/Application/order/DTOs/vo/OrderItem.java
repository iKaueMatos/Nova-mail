package com.email.email.modules.Mail.Application.order.DTOs.vo;

import lombok.Data;

@Data
public class OrderItem {
    private String productName;
    private int quantity;
    private double price;
}
