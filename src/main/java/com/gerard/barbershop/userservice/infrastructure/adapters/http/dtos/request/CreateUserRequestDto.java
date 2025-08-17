package com.gerard.barbershop.userservice.infrastructure.adapters.http.dtos.request;

import com.gerard.barbershop.userservice.infrastructure.adapters.http.validations.constants.UserValidationConstant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserRequestDto(
        @NotBlank(message = UserValidationConstant.Email.NOT_BLANK_MESSAGE)
        @Email(message = UserValidationConstant.Email.INVALID_FORMAT_MESSAGE)
        @Size(max = UserValidationConstant.Email.MAX_LENGTH,
                message = UserValidationConstant.Email.SIZE_MESSAGE)
        String email,

        @NotBlank(message = UserValidationConstant.Password.NOT_BLANK_MESSAGE)
        @Size(min = UserValidationConstant.Password.MIN_LENGTH,
                max = UserValidationConstant.Password.MAX_LENGTH,
                message = UserValidationConstant.Password.SIZE_MESSAGE)
        @Pattern(regexp = UserValidationConstant.Password.PATTERN_REGEX,
                message = UserValidationConstant.Password.PATTERN_MESSAGE)
        String password
) {}