package com.youcode.mypet.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.w3c.dom.Text;

import java.awt.*;
import java.sql.Blob;
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

    @Lob
    @Column(name = "images", columnDefinition="TEXT", length = 2048)
    private String images;

    @Column(name = "price")
    private float price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
}