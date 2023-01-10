package com.youcode.mypet.Service;

import com.youcode.mypet.Request.RegisterRequest;
import com.youcode.mypet.Security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<HashMap<String, String>> login(String email, String password) {
        HashMap<String, String> responseToken = new HashMap<>();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        User user = userService.findUser(email);
        if (user != null) {
            responseToken.put("accessToken", jwtUtil.generateToken(user));
            return ResponseEntity.ok(responseToken);
        } else {
            responseToken.put("error token", "token has not generated");
            return ResponseEntity.status(400).body(responseToken);
        }
    }

    public void register(RegisterRequest registerRequest) throws Exception {
        userService.saveUser(registerRequest);
    }
}