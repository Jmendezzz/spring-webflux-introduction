package com.gerard.barbershop.userservice.infrastructure.adapters.http.controllers;

import com.gerard.barbershop.userservice.application.commands.CreateUserCommand;
import com.gerard.barbershop.userservice.application.usecases.CreateUserUseCase;
import com.gerard.barbershop.userservice.infrastructure.adapters.http.dtos.mapper.UserDtoMapper;
import com.gerard.barbershop.userservice.infrastructure.adapters.http.dtos.request.CreateUserRequestDto;
import com.gerard.barbershop.userservice.infrastructure.adapters.http.dtos.response.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserDtoMapper userDtoMapper;

    @PostMapping("/create")
    public Mono<ResponseEntity<UserResponseDto>> createUser(@RequestBody @Valid CreateUserRequestDto request) {
        log.info("Creating user with email: {}", request.email());
        CreateUserCommand command = userDtoMapper.toCommand(request);

        return createUserUseCase.execute(command)
                .map(userDtoMapper::toDto)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response));
    }
}