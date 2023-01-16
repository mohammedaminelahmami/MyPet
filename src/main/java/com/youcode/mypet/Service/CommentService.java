package com.youcode.mypet.Service;

import com.youcode.mypet.DTO.CommentDTO;
import com.youcode.mypet.DTO.mapper.IMapperDto;
import com.youcode.mypet.Entity.CommentEntity;
import com.youcode.mypet.Entity.PostEntity;
import com.youcode.mypet.Entity.UserEntity;
import com.youcode.mypet.Repository.CommentRepository;
import com.youcode.mypet.Repository.PostRepository;
import com.youcode.mypet.Repository.UserRepository;
import com.youcode.mypet.Request.CommentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IMapperDto<CommentDTO, CommentEntity> mapper;

    public void createComment(CommentRequest commentRequest, Long id, Long idUser) throws Exception {
        try {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(commentRequest, commentDTO);

            CommentEntity comment = mapper.convertToEntity(commentDTO, CommentEntity.class);

            Optional<PostEntity> post = postRepository.findById(id);
            Optional<UserEntity> user = userRepository.findById(idUser);

            if(user.isPresent())
            {
                comment.setUser(user.get());
            }
            else
            {
                throw new Exception("User not found");
            }
            if(post.isPresent()) {
                comment.setPost(post.get());
            }else{
                throw new Exception("No Post Found by this id");
            }

            commentRepository.save(comment);
        }catch (Exception e) {
            throw new Exception("createCommentCatch");
        }
    }

    public void deleteComment(Long id) throws Exception {
        Optional<CommentEntity> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            commentRepository.delete(comment.get());
        }else{
            throw new Exception("id not valid");
        }
    }

    public void updateComment(Long id, CommentRequest commentRequest) throws Exception {
        Optional<CommentEntity> comment = commentRepository.findById(id);

        if(comment.isPresent()) {
            comment.get().setComment_body(commentRequest.getComment_body());
            commentRepository.save(comment.get());
        }else {
            throw new Exception("id not valid");
        }
    }

    public CommentDTO getOneComment(Long id) throws Exception {
        Optional<CommentEntity> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            CommentDTO commentDTO = mapper.convertToDTO(comment.get(), CommentDTO.class);
            return commentDTO;
        }else{
            throw new Exception("id not valid");
        }
    }

    public List<CommentDTO> getAllCommentById(Integer id) {
        List<CommentEntity> comments = (List<CommentEntity>) commentRepository.findByPostId(id);
        List<CommentDTO> postDTOS = mapper.convertListToListDto(comments, CommentDTO.class);
        return postDTOS;
    }

    public void verifyComment(Long id) throws Exception {
        Optional<CommentEntity> comment = commentRepository.findById(id);

        if(comment.isPresent()) {
            comment.get().setComment_isVerified(true);
            commentRepository.save(comment.get());
        }else{
            throw new Exception("id not valid");
        }
    }
}
