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
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comment/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable String id, @RequestBody @Valid CommentRequest commentRequest) throws Exception {
        commentService.createComment(commentRequest, Long.parseLong(id));
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comments/{id}")
    public CommentDTO getOne(@PathVariable String id) throws Exception {
        return commentService.getOneComment(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comments")
    public List<CommentDTO> getAll(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "8") int limit) {
        return commentService.getAllComment(page, limit);
    }
}