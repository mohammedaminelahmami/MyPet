package com.youcode.mypet.Request;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String username;

    @Email
    private String email;
    private String phone;
    private String num_animal_adopt;
}
