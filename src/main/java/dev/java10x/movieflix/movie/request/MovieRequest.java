package dev.java10x.movieflix.movie.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "String", description = "Nome do filme")
                            @NotEmpty(message = "Titulo do filme obrigatorio")
                           String name,
                           @Schema(type = "String", description = "Descricao do filme")
                           String description,
                           @Schema(type = "Date", description = "Dia e ano de lancamento. ex: 17/01/2000")
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,
                           @Schema(type = "Double", description = "Score do filme. ex: 7.9")
                           Double rating,
                           @Schema(type = "array", description = "Lista de codigos de categoria")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de codigos de servico streaming")
                           List<Long> streamings) {
}
