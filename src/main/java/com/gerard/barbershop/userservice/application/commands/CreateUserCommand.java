package com.gerard.barbershop.userservice.application.commands;

public record CreateUserCommand(
        String email,
        String password
) {
}
