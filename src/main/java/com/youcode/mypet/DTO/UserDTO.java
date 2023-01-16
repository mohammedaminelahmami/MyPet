package com.youcode.mypet.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id_user;
    private String username;
    private String email;
    private String phone;
    private String num_animal_adopt;
}
