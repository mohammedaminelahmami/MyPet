package com.youcode.mypet.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotNull(message = "username is required")
    @NotBlank(message = "username is required")
    private String username;

    @NotNull(message = "email is required")
    @NotBlank(message = "email is required")
    @Email
    private String email;

    @NotNull(message = "password is required")
    @NotBlank(message = "password is required")
    @Size(min = 6, message = "password must be at least 6 characters")
    private String password;

    @NotNull(message = "phone is required")
    @NotBlank(message = "phone is required")
    private String phone;
}