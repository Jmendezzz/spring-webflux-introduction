package com.gerard.barbershop.userservice.infrastructure.persistence.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class UserEntity {
    @Id
    private Long id;
    private String email;
    private String password;
}
