package com.youcode.mypet.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDTO {
//    private int id_animal;
    private int age;
    private String description;
    private String images;
    private int num_days_adopted;
    private String type;
    private int user_id;
}