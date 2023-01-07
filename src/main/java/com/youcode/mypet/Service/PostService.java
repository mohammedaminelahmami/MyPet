package com.youcode.mypet.Service;

import com.youcode.mypet.DTO.PostDTO;
import com.youcode.mypet.Entity.PostEntity;
import com.youcode.mypet.Entity.UserEntity;
import com.youcode.mypet.Repository.PostRepository;
import com.youcode.mypet.Request.PostRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public PostDTO createPost(PostRequest postRequest) {
        PostEntity post = new PostEntity();

        UserEntity user  = UserEntity.builder().id_user(1).email("medamine0029@gmail.com").hashed_password("123456").num_animal_adopt("34").phone("0654565544").username("amine0029").build();

        BeanUtils.copyProperties(postRequest, post);
        post.setUser(user);

        postRepository.save(post);
        PostDTO postDTO = new PostDTO();

        BeanUtils.copyProperties(post, postDTO);

        return postDTO;
    }
}