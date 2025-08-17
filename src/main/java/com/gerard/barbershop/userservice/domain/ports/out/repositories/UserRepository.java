package com.gerard.barbershop.userservice.domain.ports.out.repositories;

import com.gerard.barbershop.userservice.domain.models.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> saveUser(User user);
    Mono<Boolean> existsByEmail(String email);
}
