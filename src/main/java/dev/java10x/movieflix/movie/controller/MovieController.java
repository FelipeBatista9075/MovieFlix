package dev.java10x.movieflix.movie.controller;

import dev.java10x.movieflix.movie.mapper.MovieMapper;
import dev.java10x.movieflix.movie.model.Movie;
import dev.java10x.movieflix.movie.request.MovieRequest;
import dev.java10x.movieflix.movie.response.MovieResponse;
import dev.java10x.movieflix.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
public class MovieController {

    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request){
        Movie savedMovie = service.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){
        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());
    }

}
