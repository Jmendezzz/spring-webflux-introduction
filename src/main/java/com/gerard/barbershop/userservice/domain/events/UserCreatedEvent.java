package com.gerard.barbershop.userservice.domain.events;

public record UserCreatedEvent(
        Long userId,
        String email
) {}