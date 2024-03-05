/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.common.Enum.transaction;

public enum StatusTransaction {
    PROCESSING_PAYMENT(1),
    PAYMENT_CONFIRMED(2),
    PAYMENT_REFUSED(3),
    PAYMENT_REVERSED(4),
    UNDEFINED(1);

    private final int value;

    StatusTransaction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StatusTransaction getValueStatusTransaction(int value) {
        for (StatusTransaction status : StatusTransaction.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return StatusTransaction.UNDEFINED;
    }
}
