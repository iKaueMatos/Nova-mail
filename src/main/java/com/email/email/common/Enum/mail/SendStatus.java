/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.common.Enum.mail;

import java.util.Optional;

public enum SendStatus {
    SENT(1),
    NOT_SENT(2),
    PENDING(3),
    FAILED(4);

    private final int value;

    SendStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SendStatus getStatusSendString(int value) {
        Optional<SendStatus> matchingStatus = Optional.empty();
        for (SendStatus status : SendStatus.values()) {
            if (status.value == value) {
                matchingStatus = Optional.of(status);
                break;
            }
        }
        return matchingStatus.orElseThrow(() -> new IllegalArgumentException("Invalid SendStatus value: " + value));
    }
}
