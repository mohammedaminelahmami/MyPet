package com.youcode.mypet.Request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    // @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") // email
    @NotNull(message = "email cannot be null !")
    @NotBlank(message = "email cannot be empty !")
    @Email
    private String email;

    @NotNull(message = "email cannot be null !")
    @NotBlank(message = "email cannot be empty !")
    @Size(min = 6, max = 20, message = "password must be between 6 and 20 characters !")
    private String password;
}