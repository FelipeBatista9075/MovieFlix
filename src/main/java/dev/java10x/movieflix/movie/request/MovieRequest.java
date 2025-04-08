package dev.java10x.movieflix.movie.request;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(String name,
                           String description,
                           LocalDate releaseDate,
                           Double rating,
                           List<Long> categories,
                           List<Long> streamings) {
}
