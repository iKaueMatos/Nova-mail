package com.email.email.modules.Mail.Application.DTOs.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessageDTO {
    private String message;
    private String className;
    private String errorMessage;
}
