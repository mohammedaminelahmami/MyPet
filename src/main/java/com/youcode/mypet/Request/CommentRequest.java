package com.youcode.mypet.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    @NotNull(message = "comment_body is required")
    @NotBlank(message = "comment_body is required")
    private String comment_body;

    private int comment_likes;

    private int comment_dislikes;
}