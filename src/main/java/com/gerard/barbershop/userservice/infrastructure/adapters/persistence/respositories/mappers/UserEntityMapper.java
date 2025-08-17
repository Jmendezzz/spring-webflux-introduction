package com.gerard.barbershop.userservice.infrastructure.adapters.persistence.respositories.mappers;

import com.gerard.barbershop.userservice.domain.models.User;
import com.gerard.barbershop.userservice.infrastructure.adapters.persistence.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    User toDomain(UserEntity user);
    UserEntity toEntity(User user);
}
