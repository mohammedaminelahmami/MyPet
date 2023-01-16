package com.youcode.mypet.DTO;

import com.youcode.mypet.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private int id_post;
    private String title;
    private String description;
    private String city;
    private String type;
    private int num_days;
    private String images;
    private float price;
    private UserEntity user;
}