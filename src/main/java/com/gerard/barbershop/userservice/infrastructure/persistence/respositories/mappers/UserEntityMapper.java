package com.gerard.barbershop.userservice.infrastructure.persistence.respositories.mappers;

import com.gerard.barbershop.userservice.domain.models.User;
import com.gerard.barbershop.userservice.infrastructure.persistence.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserEntityMapper {
    User toDomain(UserEntity user);
    UserEntity toEntity(User user);
}
