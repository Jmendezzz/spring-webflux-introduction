package com.gerard.barbershop.userservice.infrastructure.http.dtos.mapper;

import com.gerard.barbershop.userservice.application.commands.CreateUserCommand;
import com.gerard.barbershop.userservice.domain.models.User;
import com.gerard.barbershop.userservice.infrastructure.http.dtos.request.CreateUserRequestDto;
import com.gerard.barbershop.userservice.infrastructure.http.dtos.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    CreateUserCommand toCommand(CreateUserRequestDto requestDto);
    UserResponseDto toDto(User user);
}
