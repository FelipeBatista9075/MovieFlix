package dev.java10x.movieflix.user.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(@Schema(type = "Long", description = "Codigo do usuario")
                           Long id,
                           @Schema(type = "String", description = "nome do usuario")
                           String name,
                           @Schema(type = "String", description = "email do usuario")
                           String email) {
}
