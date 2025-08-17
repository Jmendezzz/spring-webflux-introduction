package com.gerard.barbershop.userservice.infrastructure.adapters.http.exceptions;

import lombok.Builder;

@Builder
public record FieldErrorDetail(
        String field,
        String message,
        Object rejectedValue
){

}
