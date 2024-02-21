package com.email.email.modules.Mail.Application.order.DTOs;


import com.email.email.modules.Mail.Application.order.DTOs.vo.OrderItem;

import lombok.Data;

@Data
public class OrderDetails {
    private OrderItem orderItem;
}
