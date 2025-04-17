package dev.java10x.movieflix.streaming.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Nome do service de streming obrigatorio") String name) {
}
