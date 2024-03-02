package com.email.email.modules.Mail.Application.DTOs.customerAddress;

import lombok.Data;

@Data
public class CustomerAddressDTO {
    private String neighborhood;
    private String housenumber;
    private String state;
    private String cep;
}
