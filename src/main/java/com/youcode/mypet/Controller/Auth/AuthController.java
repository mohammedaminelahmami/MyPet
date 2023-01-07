package com.youcode.mypet.Controller.Auth;

import com.youcode.mypet.Request.AuthRequest;
import com.youcode.mypet.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/api/v1/authentication")
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<HashMap<String, String>> userAuth(@RequestBody @Valid AuthRequest authRequest)
    {
        return authService.login(authRequest.getEmail(), authRequest.getPassword());
    }
}