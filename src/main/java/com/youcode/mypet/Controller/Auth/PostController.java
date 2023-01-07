package com.youcode.mypet.Controller.Auth;

import com.youcode.mypet.Request.PostRequest;
import com.youcode.mypet.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid PostRequest postRequest)
    {
        // postRequest --> // validation ---> {ExceptionClass}
        // map postRequest to postEntity
        // save postEntity
        // if return : map postEntity to postResponse
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
