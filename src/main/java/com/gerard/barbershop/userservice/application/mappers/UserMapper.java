package com.gerard.barbershop.userservice.application.mappers;

import com.gerard.barbershop.userservice.application.commands.CreateUserCommand;
import com.gerard.barbershop.userservice.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(CreateUserCommand createUserCommand);
}
