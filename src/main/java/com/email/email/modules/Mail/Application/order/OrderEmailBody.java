package com.email.email.modules.Mail.Application.order;

import java.util.List;

import com.email.email.modules.Mail.Application.DTOs.order.OrderItem;

import lombok.Data;

@Data
public class OrderEmailBody {
    private String orderNumber;
    private String dateOrder;
    private List<OrderItem> items;
    private String totalValue;
    private String status;
    private String customerName;
    private String deliveryAddress;
    private String contactInfo;
    private String trackingLink;
    private String detailsPageLink;
    private String productReviewCTA;
    private String discountCode;
    private String relatedProductsOffer;
    private String estimatedDeliveryDate;
    private String deliveryDetails;
    private String returnPolicy;
    private String customerSupportInfo;
    private String thankYouMessage;
    private String birthdayMessage;
    private String productTips;
}
