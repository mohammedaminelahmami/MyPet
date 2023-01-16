package com.youcode.mypet.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "comment_isVerified", columnDefinition = "boolean default false")
    private boolean comment_isVerified;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @JsonManagedReference
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<ReplyEntity> replies;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}