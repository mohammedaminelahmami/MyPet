package com.youcode.mypet.Service;

import com.youcode.mypet.Entity.PostEntity;
import com.youcode.mypet.Entity.UserEntity;
import com.youcode.mypet.Repository.PostRepository;
import com.youcode.mypet.Repository.UserRepository;
import com.youcode.mypet.Request.PostRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public void createPost(PostRequest postRequest, Long id) throws Exception {
        try {
            // No Validation !!!
            // MapperDtoImpl<PostRequest, PostEntity> mapper = new MapperDtoImpl<>();
            PostEntity post = new PostEntity();
            BeanUtils.copyProperties(postRequest, post);

            // user foreign key (obj User)
            Optional<UserEntity> user = userRepository.findById(id);

            if(user.isPresent()) {
                post.setUser(user.get());
            }else{
                throw new Exception("No User Found by this id");
            }
            // PostEntity post = mapper.convertToEntity(postRequest, PostEntity.class);
            postRepository.save(post);
        }catch (Exception e) {
            throw new Exception("createPostCatch");
        }
    }
}