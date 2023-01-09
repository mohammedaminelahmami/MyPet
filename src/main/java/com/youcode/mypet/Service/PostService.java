package com.youcode.mypet.Service;

import com.youcode.mypet.DTO.PostDTO;
import com.youcode.mypet.DTO.mapper.IMapperDto;
import com.youcode.mypet.Entity.PostEntity;
import com.youcode.mypet.Entity.UserEntity;
import com.youcode.mypet.Repository.PostRepository;
import com.youcode.mypet.Repository.UserRepository;
import com.youcode.mypet.Request.PostRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IMapperDto<PostDTO, PostEntity> mapper;

    public void createPost(PostRequest postRequest, Long id) throws Exception {
        try {
            // No Validation !!!!
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(postRequest, postDTO);
            PostEntity post = mapper.convertToEntity(postDTO, PostEntity.class);

            // user foreign key (obj User)
            Optional<UserEntity> user = userRepository.findById(id);

            if(user.isPresent()) {
                post.setUser(user.get());
            }else{
                throw new Exception("No User Found by this id");
            }

            postRepository.save(post);
        }catch (Exception e) {
            throw new Exception("createPostCatch");
        }
    }

    public void deletePost(Long id) throws Exception {
        Optional<PostEntity> post = postRepository.findById(id);
        if(post.isPresent()) {
            postRepository.delete(post.get());
        }else{
            throw new Exception("id not valid");
        }
    }

    public void updatePost(Long id, PostRequest postRequest) throws Exception {
        Optional<PostEntity> post = postRepository.findById(id);

        if(post.isPresent()) {
            post.get().setTitle(postRequest.getTitle());
            post.get().setDescription(postRequest.getDescription());
            post.get().setCity(postRequest.getCity());
            post.get().setImages(postRequest.getImages());
            post.get().setNum_days(postRequest.getNum_days());
            post.get().setPrice(postRequest.getPrice());
            postRepository.save(post.get());
        }else {
            throw new Exception("id not valid");
        }
    }

    public PostDTO getOnePost(Long id) throws Exception {
        Optional<PostEntity> post = postRepository.findById(id);
        if(post.isPresent()) {
            PostDTO postDTO = mapper.convertToDTO(post.get(), PostDTO.class);
            return postDTO;
        }else{
            throw new Exception("id not valid");
        }
    }

    public List<PostDTO> getAllPosts(int page, int limit) {
        if(page > 0) page--;
        List<PostEntity> posts = postRepository.findAll(PageRequest.of(page, limit)).getContent();
        List<PostDTO> postDTOS = mapper.convertListToListDto(posts, PostDTO.class);
        return postDTOS;
    }

    public List<PostDTO> getAllPostsByType(String type, int page, int limit) {
        if(page > 0) page--;
        List<PostEntity> posts = postRepository.findAllByType(type, PageRequest.of(page, limit)).getContent();
        List<PostDTO> postDTOS = mapper.convertListToListDto(posts, PostDTO.class);
        return postDTOS;
    }

    public List<PostDTO> getAllPostsByCity(String city, int page, int limit) {
        if(page > 0) page--;
        List<PostEntity> posts = postRepository.findAllByCity(city, PageRequest.of(page, limit)).getContent();
        List<PostDTO> postDTOS = mapper.convertListToListDto(posts, PostDTO.class);
        return postDTOS;
    }


}