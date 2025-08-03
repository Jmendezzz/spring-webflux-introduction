package com.gerard.barbershop.userservice.domain.exceptions;

public class UserEmailAlreadyExistsException extends DomainException{
    public UserEmailAlreadyExistsException(){
        super("Email has already been taken.", "USER_EMAIL_ALREADY_EXISTS");
    }
}
