package com.youcode.mypet.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {
    private int user_id_user;
    private String title;
    private String description;
    private String city;
    private String type;
    private int num_days;
    private String images;
    private float price;
}

// need lombok Build