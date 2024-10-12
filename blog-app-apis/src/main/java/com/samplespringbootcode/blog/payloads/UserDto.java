package com.samplespringbootcode.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters")
    private String name;

    @NotEmpty(message = "Email address should not be empty !!")
    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "password must be with in 3-10 characters !!")
    private String password;

    @NotEmpty
    private String about;
}
