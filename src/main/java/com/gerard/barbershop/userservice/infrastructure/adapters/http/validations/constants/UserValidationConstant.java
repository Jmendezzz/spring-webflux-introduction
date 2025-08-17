package com.gerard.barbershop.userservice.infrastructure.http.validations.constants;

public class UserValidationConstant {

    private  UserValidationConstant(){}

    public static final class Email {
        public static final String NOT_BLANK_MESSAGE = "Email is required";
        public static final String INVALID_FORMAT_MESSAGE = "Email must be valid";
        public static final String SIZE_MESSAGE = "Email must not exceed 255 characters";
        public static final int MAX_LENGTH = 255;
    }

    // Password validation
    public static final class Password {
        public static final String NOT_BLANK_MESSAGE = "Password is required";
        public static final String SIZE_MESSAGE = "Password must be between 8 and 100 characters";
        public static final String PATTERN_MESSAGE = "Password must contain at least one lowercase letter, one uppercase letter, and one digit";
        public static final String PATTERN_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$";
        public static final int MIN_LENGTH = 8;
        public static final int MAX_LENGTH = 100;
    }}
