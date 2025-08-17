package com.gerard.barbershop.userservice.infrastructure.adapters.http.exceptions;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record ValidationErrorResponse(
        String code,
        String message,
        List<FieldErrorDetail> fieldErrors,
        Instant timestamp
) {
}
