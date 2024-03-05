/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Application.DTOs.customerAddress;

import lombok.Data;

@Data
public class CustomerAddressDTO {
    private String neighborhood;
    private String housenumber;
    private String state;
    private String cep;
}
