package com.email.email.modules.Mail.Infra.auth;

import com.email.email.modules.Mail.Application.auth.AuthEmailBody;
import com.email.email.modules.Mail.Infra.useCase.EmailContentStrategy;

public class AuthProcessingEmailContentStrategy implements EmailContentStrategy<AuthEmailBody> {

    @Override
    public String createContent(AuthEmailBody filteredBody) {
        StringBuilder contentBuilder = new StringBuilder();
        
        return contentBuilder.toString();
    }
}
