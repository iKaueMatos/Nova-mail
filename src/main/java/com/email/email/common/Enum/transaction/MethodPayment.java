/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.common.Enum.transaction;

import java.util.Optional;

public enum MethodPayment {
    CARD_CREDIT(1),
    TICKET(2),
    PIX(3);

    private final int value;

    MethodPayment(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MethodPayment methodPaymentStatus(int value) {
        Optional<MethodPayment> matchingStatus = Optional.empty();
        for (MethodPayment status : MethodPayment.values()) {
            if (status.value == value) {
                matchingStatus = Optional.of(status);
                break;
            }
        }
        return matchingStatus.orElseThrow(() -> new IllegalArgumentException("Invalid SendStatus value: " + value));
    }
}
