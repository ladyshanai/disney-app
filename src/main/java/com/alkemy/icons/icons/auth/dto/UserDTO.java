package com.alkemy.icons.icons.auth.dto;

import lombok.Data;
import org.hibernate.annotations.BatchSize;

@Data
public class UserDTO {
    @Email(message = "Username must be an email")
    private String username;
    @Size(min = 8)
    private String password;
}
