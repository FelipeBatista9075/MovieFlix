package dev.java10x.movieflix.user.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(@Schema(type = "String", description = "email do usuario")
                           String email,
                           @Schema(type = "String", description = "senha do usuario")
                           String password) {
}
