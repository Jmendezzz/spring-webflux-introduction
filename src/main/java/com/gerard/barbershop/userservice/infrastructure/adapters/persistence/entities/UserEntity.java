package com.gerard.barbershop.userservice.infrastructure.adapters.persistence.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class UserEntity {
    @Id
    @Column("id")
    private Long id;

    @Column("email")
    private String email;

    @Column("password")
    private String password;
}