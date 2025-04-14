package dev.java10x.movieflix.movie.service;

import dev.java10x.movieflix.category.model.Category;
import dev.java10x.movieflix.category.service.CategoryService;
import dev.java10x.movieflix.movie.model.Movie;
import dev.java10x.movieflix.movie.repository.MovieRepository;
import dev.java10x.movieflix.streaming.model.Streaming;
import dev.java10x.movieflix.streaming.service.StreamingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public MovieService(MovieRepository repository, CategoryService categoryService, StreamingService streamingService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.streamingService = streamingService;
    }

    public Movie save(Movie movie){
        movie.setCategories(this.findCategory(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public List<Movie> findByCategory(Long categoryById){
        return repository.findMovieByCategories(List.of(Category.builder().id(categoryById).build()));
    }

    public Optional<Movie> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Movie> update(Long movieId, Movie updateMovie){
        Optional<Movie> optMovie = repository.findById(movieId);
        if (optMovie.isPresent()){

            List<Category> categories = this.findCategory(updateMovie.getCategories());
            List<Streaming> streamings = this.findStreamings(updateMovie.getStreamings());

            Movie movie = optMovie.get();
            movie.setName(updateMovie.getName());
            movie.setDescription(updateMovie.getDescription());
            movie.setReleaseDate(updateMovie.getReleaseDate());
            movie.setRating(updateMovie.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            repository.save(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


    private List<Category> findCategory(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.getByCategoryId(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings){
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.getByStreamingId(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }
}
