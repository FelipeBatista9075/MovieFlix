package dev.java10x.movieflix.category.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@Schema(type = "String", description = "Nome da categoria")
                              @NotEmpty(message = "Nome da categoria obrigadorio")
                              String name) {
}
