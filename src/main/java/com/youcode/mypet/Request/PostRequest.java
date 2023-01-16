package com.youcode.mypet.Request;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import java.sql.Blob;

@Getter
@Setter
public class PostRequest {

//    private int user_id;

    @NotNull(message = "title cannot be empty !")
    @NotBlank(message = "title cannot be empty !")
    private String title;

    @NotNull(message = "description cannot be empty !")
    @NotBlank(message = "description cannot be empty !")
    private String description;

    @NotNull(message = "city cannot be empty !")
    @NotBlank(message = "city cannot be empty !")
    private String city;

    @NotNull(message = "type cannot be empty !")
    @NotBlank(message = "type cannot be empty !")
    private String type;

    @NotNull(message = "num_days cannot be empty !")
    private int num_days;

    @NotNull(message = "images cannot be empty !")
    @NotBlank(message = "images cannot be empty !")
    private String images;

    @NotNull(message = "price cannot be empty !")
    @Min(value = 0, message = "price cannot be less than 0")
    private float price;
}