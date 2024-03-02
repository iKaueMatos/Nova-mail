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

    public static SendStatus fromValue(int value) {
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
