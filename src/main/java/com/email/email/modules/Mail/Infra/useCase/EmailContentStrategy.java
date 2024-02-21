package com.email.email.modules.Mail.Infra.useCase;

public interface EmailContentStrategy<T> {
    String createContent(T filteredBody);
}
