package dev.java10x.movieflix.user.controller;

import dev.java10x.movieflix.exception.UsernameOrPasswordInvalidException;
import dev.java10x.movieflix.user.mapper.UserMapper;
import dev.java10x.movieflix.user.model.User;
import dev.java10x.movieflix.user.request.LoginRequest;
import dev.java10x.movieflix.user.request.UserRequest;
import dev.java10x.movieflix.user.response.LoginResponse;
import dev.java10x.movieflix.user.response.UserResponse;
import dev.java10x.movieflix.config.TokenService;
import dev.java10x.movieflix.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
public class AuthController {

    private final UserService service;
    private  final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(UserService service, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        User savedUser = service.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authentication = authenticationManager.authenticate(userAndPass);

            User user = (User) authentication.getPrincipal();

            String token = tokenService.generateToken(user);

            return  ResponseEntity.ok(new LoginResponse(token));
        }catch (BadCredentialsException e){
            throw new UsernameOrPasswordInvalidException("usuario ou senha invalido");
        }

    }
}
