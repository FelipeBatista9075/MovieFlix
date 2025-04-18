package dev.java10x.movieflix.user.controller;

import dev.java10x.movieflix.user.request.LoginRequest;
import dev.java10x.movieflix.user.request.UserRequest;
import dev.java10x.movieflix.user.response.LoginResponse;
import dev.java10x.movieflix.user.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Recurso responsavel por gerenciar usuarios")
public interface AuthController {

    @Operation(summary = "registro de usuario", description = "Metodo responsavel por registrar usuario",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "201", description = "Usuario registrado com sucesso",
        content = @Content(schema = @Schema(implementation = UserResponse.class)))
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request);

    @Operation(summary = "Login", description = "Metodo responsavel por efetuar o login",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200", description = "sucesso",
        content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    @ApiResponse(responseCode = "403", description = "Email ou senha invalido",
        content = @Content())
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);
}
