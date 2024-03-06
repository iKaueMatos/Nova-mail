/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.common.Enum.order;

import java.util.Optional;

import com.email.email.common.Enum.transaction.MethodPayment;

public enum StatusOrder {
    PROCESSING(1),
    CONFIRMED(2),
    REFUSED(3),
    PENDING(4),
    DELIVERED(5),
    PATH(6),
    SHIPPED(7);

    private final int value;

    StatusOrder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StatusOrder statusOrderValueString(int value) {
        Optional<StatusOrder> matchingStatus = Optional.empty();
        for (StatusOrder status : StatusOrder.values()) {
            if (status.value == value) {
                matchingStatus = Optional.of(status);
                break;
            }
        }
        return matchingStatus.orElseThrow(() -> new IllegalArgumentException("Invalid SendStatus value: " + value));
    }
}
