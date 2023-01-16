package com.youcode.mypet.DTO;

import com.youcode.mypet.Entity.CommentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDTO {
    private int id_reply;
    private String reply_body;
    private int reply_dislikes;
    private int reply_likes;
    private CommentEntity comment;
}