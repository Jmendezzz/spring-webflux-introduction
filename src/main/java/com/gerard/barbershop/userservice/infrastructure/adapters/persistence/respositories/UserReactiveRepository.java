package com.gerard.barbershop.userservice.infrastructure.adapters.persistence.respositories;

import com.gerard.barbershop.userservice.infrastructure.adapters.persistence.entities.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserReactiveRepository extends ReactiveCrudRepository<UserEntity,Long> {
    Mono<Boolean> existsByEmail(String email);
}
