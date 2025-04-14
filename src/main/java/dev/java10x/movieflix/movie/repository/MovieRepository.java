package dev.java10x.movieflix.movie.repository;

import dev.java10x.movieflix.category.model.Category;
import dev.java10x.movieflix.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> categories);

    List<Movie> findTop5ByOrderByRatingDesc();
}
