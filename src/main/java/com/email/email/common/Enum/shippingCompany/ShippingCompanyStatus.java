/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.common.Enum.shippingCompany;

public enum ShippingCompanyStatus {
    TRANSIT("EM TRANSITO"),
    DELIVERED("ENTREGUE"),
    PENDING("EM PREPARAÇÃO"),
    RETURNED("DEVOLVIDO"),
    LOST("PERDIDO"),
    CANCELED("ENTREGA CANCELADA"),
    OTHER("OUTROS");

    private final String value;

    ShippingCompanyStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ShippingCompanyStatus getValueShippingCompany(String value) {
        for (ShippingCompanyStatus shippingCompanyStatus : ShippingCompanyStatus.values()) {
            if (shippingCompanyStatus.getValue().equalsIgnoreCase(value)) {
                return shippingCompanyStatus;
            }
        }
        return null;
    }
}
