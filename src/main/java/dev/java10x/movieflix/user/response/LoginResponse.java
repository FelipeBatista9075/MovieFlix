package dev.java10x.movieflix.user.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(@Schema(type = "String", description = "token JWT")
                            String token) {
}
