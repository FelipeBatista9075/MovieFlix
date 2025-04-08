package dev.java10x.movieflix.movie.response;

import dev.java10x.movieflix.category.response.CategoryResponse;
import dev.java10x.movieflix.streaming.response.StreamingResponse;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String name,
                            String description,
                            LocalDate releaseDate,
                            Double rating,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings) {
}
