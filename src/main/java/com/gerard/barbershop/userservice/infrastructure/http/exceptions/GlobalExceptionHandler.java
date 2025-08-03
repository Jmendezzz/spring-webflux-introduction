package com.gerard.barbershop.userservice.infrastructure.http.exceptions;

import com.gerard.barbershop.userservice.domain.exceptions.DomainException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleDomainExceptions(DomainException ex){
        log.warn(ex.getErrorMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getErrorMessage(),
                ex.getErrorIdentifier(),
                Instant.now()
        );

        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST));
    }


    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<ValidationErrorResponse>> handleValidationErrors(
            WebExchangeBindException ex) {
        log.error("WebExchangeBindException caught: {}", ex.getMessage());

        List<FieldErrorDetail> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> FieldErrorDetail.builder()
                        .field(error.getField())
                        .message(error.getDefaultMessage())
                        .rejectedValue(error.getRejectedValue() != null ? error.getRejectedValue().toString() : "null")
                        .build())
                .toList();

        ValidationErrorResponse errorResponse = ValidationErrorResponse.builder()
                .code("VALIDATION_ERROR")
                .message("Invalid request data")
                .fieldErrors(fieldErrors)
                .timestamp(Instant.now())
                .build();

        return Mono.just(ResponseEntity.badRequest().body(errorResponse));
    }



    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleGenericException(Exception ex) {
        log.error("Unexpected error occurred", ex);

        ErrorResponse error = new ErrorResponse(
                "An unexpected error occurred",
                "INTERNAL_SERVER_ERROR",
                Instant.now()
        );

        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error));
    }}
