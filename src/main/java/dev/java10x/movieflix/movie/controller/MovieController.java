package dev.java10x.movieflix.movie.controller;

import dev.java10x.movieflix.movie.request.MovieRequest;
import dev.java10x.movieflix.movie.response.MovieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes")
public interface MovieController {

    @Operation(summary = "salvar filme", description = "metodo responsavel por salvar um novo filme",
            security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request);

    @Operation(summary = "Lista de filmes", description = "Busca uma lista de filmes",
            security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200",description = "retorna uma lista de todos  filmes",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findAll();

    @Operation(summary = "Buscar filme por id", description = "metodo responsavel por buscar filme por id",
            security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado", content = @Content())
    ResponseEntity<MovieResponse> findById(@PathVariable Long id);

    @Operation(summary = "Alterar filme", description = "metodo responsavel por Alterar filmes por id",
            security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme alterado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado", content = @Content())
    ResponseEntity<MovieResponse> update(@PathVariable Long id,@Valid @RequestBody MovieRequest request);

    @Operation(summary = "Lista de filmes por categoria", description = "Busca uma lista de filmes pela categoria",
            security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200",description = "retorna uma lista de todos  filmes",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findMoviesByCategoryId(@RequestParam Long category);

    @Operation(summary = "Deletar filme", description = "metodo responsavel por Deletar filme por id",
            security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "204", description = "Filme deletado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado", content = @Content())
    ResponseEntity<Void> delete(@PathVariable Long id);
}
