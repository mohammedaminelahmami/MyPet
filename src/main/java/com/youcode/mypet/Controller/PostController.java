package com.youcode.mypet.Controller;

import com.youcode.mypet.Request.PostRequest;
import com.youcode.mypet.Service.PostService;
import com.youcode.mypet.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable String id, @RequestBody PostRequest postRequest) throws Exception {
        postService.createPost(postRequest, Long.parseLong(id));
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
