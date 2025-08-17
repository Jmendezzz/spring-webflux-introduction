package com.gerard.barbershop.userservice.infrastructure.persistence.respositories;

import com.gerard.barbershop.userservice.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserReactiveRepository extends ReactiveCrudRepository<UserEntity,Long> {
    Mono<Boolean> existsByEmail(String email);
}
