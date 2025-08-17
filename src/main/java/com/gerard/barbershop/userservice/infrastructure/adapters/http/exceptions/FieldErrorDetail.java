package com.gerard.barbershop.userservice.infrastructure.http.exceptions;

import lombok.Builder;

@Builder
public record FieldErrorDetail(
        String field,
        String message,
        Object rejectedValue
){

}
