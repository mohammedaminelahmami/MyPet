package com.youcode.mypet.DTO;

import com.youcode.mypet.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private int id_comment;
    private String comment_body;
    private int comment_likes;
    private int comment_dislikes;
    private PostDTO post;
    private UserEntity user;
    private boolean comment_isVerified;
}