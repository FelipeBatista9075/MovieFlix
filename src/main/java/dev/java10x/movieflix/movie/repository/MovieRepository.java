package dev.java10x.movieflix.movie.repository;

import dev.java10x.movieflix.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
