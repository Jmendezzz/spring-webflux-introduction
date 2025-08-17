package com.gerard.barbershop.userservice.infrastructure.persistence.respositories.impl;

import com.gerard.barbershop.userservice.domain.models.User;
import com.gerard.barbershop.userservice.domain.ports.out.repositories.UserRepository;
import com.gerard.barbershop.userservice.infrastructure.persistence.entities.UserEntity;
import com.gerard.barbershop.userservice.infrastructure.persistence.respositories.UserReactiveRepository;
import com.gerard.barbershop.userservice.infrastructure.persistence.respositories.mappers.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserR2DBCRepositoryImpl implements UserRepository {

    private final UserEntityMapper userEntityMapper;
    private final UserReactiveRepository userReactiveRepository;

    @Override
    public Mono<User> saveUser(User user) {
        UserEntity userEntityToSave = userEntityMapper.toEntity(user);
        log.info("Saving User: {}", user);
        log.info("Mapped to Entity: {}", userEntityToSave);

        return userReactiveRepository
                .save(userEntityToSave)
                .doOnNext(saved -> log.info("Entity saved by repository: {}", saved))
                .map(userEntityMapper::toDomain);

    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return userReactiveRepository.existsByEmail(email);
    }
}
