package com.youcode.mypet.Controller.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    @PostMapping
    public ResponseEntity<String> userAuth()
    {
        return ResponseEntity.ok("Auth");
    }
}