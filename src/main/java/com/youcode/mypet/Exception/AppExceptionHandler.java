package com.youcode.mypet.Exception;

import com.youcode.mypet.Response.Response;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import javax.xml.bind.ValidationException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException (Exception e) {
        return ResponseEntity.badRequest().body(new Response(e.getMessage(), 400));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Response> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(new Response(e.getMessage(), 400));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Response> handleValidationException(ValidationException e) {
        return ResponseEntity.badRequest().body(new Response(e.getMessage(),400));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public final ResponseEntity<Response> handleExpiredJwtException(ExpiredJwtException e) {
        return ResponseEntity.status(401).body(new Response("Token expired : "+e.getMessage(),401));
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Response> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(400).body(new Response(e.getMessage(),400));
    }
}