package com.youcode.mypet.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "animal", catalog = "mypet")
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private int id_animal;

    @Column(name = "type")
    private String type;

    @Column(name = "age")
    private int age;

    @Column(name = "num_days_adopted")
    private int num_days_adopted;

    @Column(name = "description")
    private String description;

    @Column(name = "images")
    private String images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}