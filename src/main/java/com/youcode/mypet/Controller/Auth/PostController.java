package com.youcode.mypet.Controller.Auth;

import com.youcode.mypet.DTO.PostDTO;
import com.youcode.mypet.Request.PostRequest;
import com.youcode.mypet.Response.PostResponse;
import com.youcode.mypet.Service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostResponse> save(@RequestBody PostRequest postRequest)
    {
        PostDTO postDTO = postService.createPost(postRequest);

        PostResponse postResponse = new PostResponse();

        BeanUtils.copyProperties(postDTO, postResponse);
        return ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("deletePost");
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<String> update() {
        return ResponseEntity.ok("updatePost");
    }

    @GetMapping("/posts")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("getAllPost");
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<String> getOne() {
        return ResponseEntity.ok("getOnePost");
    }
}
