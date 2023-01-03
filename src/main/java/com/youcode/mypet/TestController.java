package com.youcode.mypet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<String> testMethod()
    {
        return ResponseEntity.ok("Test Response !");
    }

    @GetMapping("/save/{id}")
    public ResponseEntity<String> save(@PathVariable String id)
    {
        return ResponseEntity.ok("save !! : "+id);
    }
}
