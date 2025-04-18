package dev.java10x.movieflix.streaming.controller;

import dev.java10x.movieflix.category.response.CategoryResponse;
import dev.java10x.movieflix.streaming.request.StreamingRequest;
import dev.java10x.movieflix.streaming.response.StreamingResponse;
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

@Tag(name = "Streaming", description = "Recurso responsavel pelo gerenciamento dos streamings")
public interface StreamingController {
    @Operation(summary = "Listar streamings", description = "metodo responsavel por listar as streamings",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna uma lista de streaming",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))))
    public ResponseEntity<List<StreamingResponse>> getAllStreaming();

    @Operation(summary = "Busca streaming por id", description = "Metodo responsavel por busca streaming por id",
        security =  @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming encontardo com sucesso",
        content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    @ApiResponse(responseCode = "404", description = "streaming nao encontardo", content = @Content())
    public ResponseEntity<StreamingResponse> getByStreaming(@PathVariable Long id);

    @Operation(summary = "Salvar Streaming", description = "Metodo responsavel por salvar um servico de streaming",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "201", description = "Streaming salvo com sucesso",
        content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    public ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request);

    @Operation(summary = "Deleta Streaming", description = "Metodo responsavel por deletar streaming por id",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "204", description = "Streaming deletado com sucesso",
        content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    @ApiResponse(responseCode = "404", description = "Streaming nao encontrado",
        content = @Content())
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}
