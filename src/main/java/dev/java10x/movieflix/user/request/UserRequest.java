package dev.java10x.movieflix.user.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(@Schema(type = "String", description = "nome do usuario")
                          String name,
                          @Schema(type = "String", description = "email do usuario")
                          String email,
                          @Schema(type = "String", description = "senha do usuario")
                          String password) {
}
