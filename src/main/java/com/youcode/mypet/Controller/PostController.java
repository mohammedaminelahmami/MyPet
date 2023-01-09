package com.youcode.mypet.Controller;

import com.youcode.mypet.DTO.PostDTO;
import com.youcode.mypet.Request.PostRequest;
import com.youcode.mypet.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable String id, @RequestBody @Valid PostRequest postRequest) throws Exception {
        postService.createPost(postRequest, Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable String id) throws Exception {
        postService.deletePost(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/posts/{id}")
    public void update(@PathVariable String id, @RequestBody @Valid PostRequest postRequest) throws Exception {
        postService.updatePost(Long.parseLong(id), postRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts/{id}")
    public PostDTO getOne(@PathVariable String id) throws Exception {
        return postService.getOnePost(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts")
    public List<PostDTO> getAll(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "8") int limit) {
        return postService.getAllPosts(page, limit);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts/byType")
    public List<PostDTO> getAllByCity(@RequestParam(value = "type") String type, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "8") int limit) {
        return postService.getAllPostsByType(type, page, limit);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts/byCity")
    public List<PostDTO> getAllByType(@RequestParam(value = "city") String city, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "8") int limit) {
        return postService.getAllPostsByCity(city, page, limit);
    }
}