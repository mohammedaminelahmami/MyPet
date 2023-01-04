package com.youcode.mypet.Controller.Auth;

import com.youcode.mypet.Request.AuthRequest;
import com.youcode.mypet.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/authentication")
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> userAuth(@RequestBody AuthRequest authRequest)
    {
        return authService.login(authRequest.getEmail(), authRequest.getPassword());
    }
}