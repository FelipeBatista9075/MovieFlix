package dev.java10x.movieflix.movie.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(String name,
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,
                           Double rating,
                           List<Long> categories,
                           List<Long> streamings) {
}
