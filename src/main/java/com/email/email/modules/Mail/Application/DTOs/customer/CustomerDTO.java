package com.email.email.modules.Mail.Application.DTOs.customer;

import com.email.email.modules.Mail.Application.DTOs.customerAddress.CustomerAddressDTO;

import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    private String lastname;
    private CustomerAddressDTO customerAddress;
}
