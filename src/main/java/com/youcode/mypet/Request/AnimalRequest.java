package com.youcode.mypet.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalRequest {
    //    private int id_animal;
    @NotNull(message = "age is required")
    private int age;

    @NotNull(message = "description is required")
    @NotBlank(message = "description is required")
    private String description;

    @NotNull(message = "images is required")
    private String images;

    @NotNull(message = "num_days_adopted is required")
    private int num_days_adopted;

    @NotNull(message = "type is required")
    @NotBlank(message = "type is required")
    private String type;

    private int user_id;
}