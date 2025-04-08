package dev.java10x.movieflix.movie.service;

import dev.java10x.movieflix.movie.model.Movie;
import dev.java10x.movieflix.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie save(Movie movie){
        return repository.save(movie);
    }
    public List<Movie> findAll(){
        return repository.findAll();
    }
}
