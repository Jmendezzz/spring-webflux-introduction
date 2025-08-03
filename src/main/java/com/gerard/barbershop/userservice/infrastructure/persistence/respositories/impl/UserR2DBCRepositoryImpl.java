package com.gerard.barbershop.userservice.infrastructure.persistence.respositories.impl;

import com.gerard.barbershop.userservice.domain.models.User;
import com.gerard.barbershop.userservice.domain.ports.out.UserRepository;
import com.gerard.barbershop.userservice.infrastructure.persistence.entities.UserEntity;
import com.gerard.barbershop.userservice.infrastructure.persistence.respositories.UserReactiveRepository;
import com.gerard.barbershop.userservice.infrastructure.persistence.respositories.mappers.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserReactiveRepositoryImpl implements UserRepository {

    private final UserEntityMapper userEntityMapper;
    private final UserReactiveRepository userReactiveRepository;

    @Override
    public Mono<User> saveUser(User user) {
        UserEntity userEntityToSave = userEntityMapper.toEntity(user);

        return userReactiveRepository
                .save(userEntityToSave)
                .map(userEntityMapper::toDomain);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return userReactiveRepository.existsByEmail(email);
    }
}
