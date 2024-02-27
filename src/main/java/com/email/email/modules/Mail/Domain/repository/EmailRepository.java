package com.email.email.modules.Mail.Domain.repository;

import com.email.email.common.Enum.mail.TemplateEmailType;
import com.email.email.modules.Mail.Domain.model.Email;

public interface EmailRepository {
    public Email createEmail(TemplateEmailType type, String to, String subject, String body);
}
