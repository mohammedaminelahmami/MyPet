package com.youcode.mypet.Controller;

import com.youcode.mypet.Request.AuthRequest;
import com.youcode.mypet.Request.RegisterRequest;
import com.youcode.mypet.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/api/v1/authentication")
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<HashMap<String, String>> userAuth(@RequestBody @Valid AuthRequest authRequest)
    {
        return authService.login(authRequest.getEmail(), authRequest.getPassword());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest registerRequest) throws Exception {
        authService.register(registerRequest);
    }
}