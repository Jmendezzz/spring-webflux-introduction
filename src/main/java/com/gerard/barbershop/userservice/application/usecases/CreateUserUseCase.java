package com.gerard.barbershop.userservice.application.usecases;

import com.gerard.barbershop.userservice.application.commands.CreateUserCommand;
import com.gerard.barbershop.userservice.domain.models.User;
import reactor.core.publisher.Mono;

public interface CreateUserUseCase {
    Mono<User> execute(CreateUserCommand createUserCommand);
}
