package dev.java10x.movieflix.movie.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.java10x.movieflix.category.response.CategoryResponse;
import dev.java10x.movieflix.streaming.response.StreamingResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "Long", description = "Codigo do filme")
                            Long id,
                            @Schema(type = "String", description = "Titulo do filme")
                            String name,
                            @Schema(type = "String", description = "Descricao do filme")
                            String description,
                            @Schema(type = "Date", description = "Dia e ano de lancamento. ex: 17/01/2000")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate releaseDate,
                            @Schema(type = "Double", description = "Score do filme. ex: 7.9")
                            Double rating,
                            @Schema(type = "array", description = "Lista de codigos de categoria")
                            List<CategoryResponse> categories,
                            @Schema(type = "array", description = "Lista de codigos de servico streaming")
                            List<StreamingResponse> streamings) {
}
