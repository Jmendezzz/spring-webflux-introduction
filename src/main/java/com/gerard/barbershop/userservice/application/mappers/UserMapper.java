package com.gerard.barbershop.userservice.application.mappers;

import com.gerard.barbershop.userservice.application.commands.CreateUserCommand;
import com.gerard.barbershop.userservice.domain.events.UserCreatedEvent;
import com.gerard.barbershop.userservice.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(CreateUserCommand createUserCommand);

    @Mapping(source = "id", target = "userId")
    UserCreatedEvent toEvent(User user);
}
