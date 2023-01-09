package com.youcode.mypet.Service;

import com.youcode.mypet.DTO.ReplyDTO;
import com.youcode.mypet.DTO.mapper.IMapperDto;
import com.youcode.mypet.Entity.CommentEntity;
import com.youcode.mypet.Entity.ReplyEntity;
import com.youcode.mypet.Repository.CommentRepository;
import com.youcode.mypet.Repository.ReplyRepository;
import com.youcode.mypet.Request.ReplyRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {
    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    IMapperDto<ReplyDTO, ReplyEntity> mapper;

    public void createReply(ReplyRequest replyRequest, Long id) throws Exception {
        try {
            ReplyDTO replyDTO = new ReplyDTO();
            BeanUtils.copyProperties(replyRequest, replyDTO);
            ReplyEntity reply = mapper.convertToEntity(replyDTO, ReplyEntity.class);

            Optional<CommentEntity> comment = commentRepository.findById(id);

            if(comment.isPresent()) {
                reply.setComment(comment.get());
            }else{
                throw new Exception("No comment Found by this id");
            }

            replyRepository.save(reply);
        }catch (Exception e) {
            throw new Exception("createReplyCatch");
        }
    }

    public void deleteReply(Long id) throws Exception {
        Optional<ReplyEntity> reply = replyRepository.findById(id);
        if(reply.isPresent()) {
            replyRepository.delete(reply.get());
        }else{
            throw new Exception("id not valid");
        }
    }

    public void updateReply(Long id, ReplyRequest replyRequest) throws Exception {
        Optional<ReplyEntity> reply = replyRepository.findById(id);

        if(reply.isPresent()) {
            reply.get().setReply_body(replyRequest.getReply_body());
            replyRepository.save(reply.get());
        }else {
            throw new Exception("id not valid");
        }
    }

    public ReplyDTO getOneReply(Long id) throws Exception {
        Optional<ReplyEntity> reply = replyRepository.findById(id);
        if(reply.isPresent()) {
            ReplyDTO replyDTO = mapper.convertToDTO(reply.get(), ReplyDTO.class);
            return replyDTO;
        }else{
            throw new Exception("id not valid");
        }
    }

    public List<ReplyDTO> getAllReplies(int page, int limit) {
        if(page > 0) page--;
        List<ReplyEntity> replies = replyRepository.findAll(PageRequest.of(page, limit)).getContent();
        List<ReplyDTO> replyDTOS = mapper.convertListToListDto(replies, ReplyDTO.class);
        return replyDTOS;
    }
}
