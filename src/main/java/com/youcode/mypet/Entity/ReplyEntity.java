package com.youcode.mypet.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reply", catalog = "mypet")
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reply")
    private int id_reply;

    @Column(name = "reply_body")
    private String reply_body;

    @Column(name = "reply_likes")
    private int reply_likes;

    @Column(name = "reply_dislikes")
    private int reply_dislikes;

    @ManyToOne
    private CommentEntity comment;
}