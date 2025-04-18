package dev.java10x.movieflix.streaming.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@Schema(type = "String", description = "Nome do servico de streaming")
                                @NotEmpty(message = "Nome do service de streaming obrigatorio")
                               String name) {
}
