package dev.java10x.movieflix.category.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "Nome da categoria obrigadorio") String name) {
}
