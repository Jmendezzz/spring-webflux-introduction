package com.gerard.barbershop.userservice.application.usecases.impl;

import com.gerard.barbershop.userservice.application.commands.CreateUserCommand;
import com.gerard.barbershop.userservice.application.mappers.UserMapper;
import com.gerard.barbershop.userservice.application.usecases.CreateUserUseCase;
import com.gerard.barbershop.userservice.domain.exceptions.UserEmailAlreadyExistsException;
import com.gerard.barbershop.userservice.domain.models.User;
import com.gerard.barbershop.userservice.domain.ports.out.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<User> execute(CreateUserCommand createUserCommand) {
        return validateEmailAvailable(createUserCommand.email())
                .then(Mono.fromCallable(() -> userMapper.toDomain(createUserCommand)))
                .flatMap(user -> {
                    log.info("Saving user to DB: {}", user.getEmail());
                    return userRepository.saveUser(user);
                })
                .doOnSuccess(user -> log.info("User saved: {}", user))
                .doOnError(error -> log.error("Error during create user", error));
    }

    private Mono<Void> validateEmailAvailable(String email) {
        return userRepository.existsByEmail(email)
                .flatMap(exists -> {
                    if (exists) return Mono.error(new UserEmailAlreadyExistsException());
                    return Mono.empty();
                });
    }
}
