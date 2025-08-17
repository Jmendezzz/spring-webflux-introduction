package com.gerard.barbershop.userservice.infrastructure.adapters.http.exceptions;

import java.time.Instant;

public record ErrorResponse(
        String message,
        String code,
        Instant timestamp
) {
}
