package com.youcode.mypet.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user", catalog = "mypet")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "hashed_password")
    private String hashed_password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "num_animal_adopt")
    private String num_animal_adopt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AnimalEntity> animals;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostEntity> posts;
}