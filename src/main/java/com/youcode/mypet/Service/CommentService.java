package com.youcode.mypet.Service;

import com.youcode.mypet.DTO.CommentDTO;
import com.youcode.mypet.DTO.mapper.IMapperDto;
import com.youcode.mypet.Entity.CommentEntity;
import com.youcode.mypet.Entity.PostEntity;
import com.youcode.mypet.Repository.CommentRepository;
import com.youcode.mypet.Repository.PostRepository;
import com.youcode.mypet.Request.CommentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    IMapperDto<CommentDTO, CommentEntity> mapper;

    public void createComment(CommentRequest commentRequest, Long id) throws Exception {
        try {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(commentRequest, commentDTO);
            CommentEntity comment = mapper.convertToEntity(commentDTO, CommentEntity.class);

            Optional<PostEntity> post = postRepository.findById(id);

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

    public List<CommentDTO> getAllComment(int page, int limit) {
        if(page > 0) page--;
        List<CommentEntity> comments = commentRepository.findAll(PageRequest.of(page, limit)).getContent();
        List<CommentDTO> postDTOS = mapper.convertListToListDto(comments, CommentDTO.class);
        return postDTOS;
    }
}
