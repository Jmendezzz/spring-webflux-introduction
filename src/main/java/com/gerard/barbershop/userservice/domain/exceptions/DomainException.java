package com.gerard.barbershop.userservice.domain.exceptions;

public class DomainException extends RuntimeException {
    private final String errorMessage;
    private final String errorIdentifier;

    public DomainException(String message, String errorIdentifier) {
        super(message);
        this.errorMessage = message;
        this.errorIdentifier = errorIdentifier;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorIdentifier() {
        return errorIdentifier;
    }
}


