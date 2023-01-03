package com.youcode.mypet.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "comment", catalog = "mypet")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int id_comment;

    @Column(name = "comment_body")
    private String comment_body;

    @Column(name = "comment_likes")
    private int comment_likes;

    @Column(name = "comment_dislikes")
    private int comment_dislikes;

    @ManyToOne
    private PostEntity post;

    @OneToMany(mappedBy = "comment")
    private List<ReplyEntity> replies;
}