package com.youcode.mypet.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyRequest {
    @NotNull(message = "reply_body is required")
    @NotBlank(message = "reply_body is required")
    private String reply_body;

    private int reply_dislikes;

    private int reply_likes;
}