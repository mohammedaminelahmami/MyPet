package com.youcode.mypet.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post", catalog = "mypet")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private int id_post;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "type")
    private String type;

    @Column(name = "num_days")
    private int num_days;

    @Column(name = "images")
    private String images;

    @Column(name = "price")
    private float price;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments;
}