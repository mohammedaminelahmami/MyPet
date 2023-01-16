package com.youcode.mypet.Controller;

import com.youcode.mypet.DTO.CommentDTO;
import com.youcode.mypet.Request.CommentRequest;
import com.youcode.mypet.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comment/{id}/{idUser}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable String id, @PathVariable String idUser, @RequestBody @Valid CommentRequest commentRequest) throws Exception {
        commentService.createComment(commentRequest, Long.parseLong(id), Long.parseLong(idUser));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable String id) throws Exception {
        commentService.deleteComment(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/comments/{id}")
    public void update(@PathVariable String id, @RequestBody @Valid CommentRequest commentRequest) throws Exception {
        commentService.updateComment(Long.parseLong(id), commentRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/comments/verified/{id}")
    public void getAllById(@PathVariable String id) throws Exception {
        commentService.verifyComment(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comment/{id}")
    public CommentDTO getOne(@PathVariable String id) throws Exception {
        return commentService.getOneComment(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comments/{id}")
    public List<CommentDTO> getAllById(@PathVariable Integer id) {
        return commentService.getAllCommentById(id);
    }

}