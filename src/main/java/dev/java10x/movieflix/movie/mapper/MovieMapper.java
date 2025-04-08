package dev.java10x.movieflix.movie.mapper;

import dev.java10x.movieflix.category.mapper.CategoryMapper;
import dev.java10x.movieflix.category.model.Category;
import dev.java10x.movieflix.category.response.CategoryResponse;
import dev.java10x.movieflix.movie.model.Movie;
import dev.java10x.movieflix.movie.request.MovieRequest;
import dev.java10x.movieflix.movie.response.MovieResponse;
import dev.java10x.movieflix.streaming.mapper.StreamingMapper;
import dev.java10x.movieflix.streaming.model.Streaming;
import dev.java10x.movieflix.streaming.response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request){
        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie
                .builder()
                .name(request.name())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie){

        List<CategoryResponse> categories = movie.getCategories()
                .stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId())
                .name(movie.getName())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
