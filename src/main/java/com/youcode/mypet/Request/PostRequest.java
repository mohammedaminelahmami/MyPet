package com.youcode.mypet.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private int user_id_user;
    private String title;
    private String description;
    private String city;
    private String type;
    private int num_days;
    private String images;
    private float price;
}