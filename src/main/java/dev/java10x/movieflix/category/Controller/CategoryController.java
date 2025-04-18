package dev.java10x.movieflix.category.Controller;

import dev.java10x.movieflix.category.request.CategoryRequest;
import dev.java10x.movieflix.category.response.CategoryResponse;
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

@Tag(name = "Category", description = "Recurso responsavel pelo gerenciamento de categorias")
public interface CategoryController {

    @Operation(summary = "Lista categorias", description = "Metodo responsavel por listar categorias",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna lista de categorias",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))))
    public ResponseEntity<List<CategoryResponse>> getAllCategories();

    @Operation(summary = "Busca categoria por id", description =  "Metodo responsavel por buscar categorias por id",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso",
        content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    @ApiResponse(responseCode = "404", description = "Categoria nao encontrada", content = @Content())
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id);

    @Operation(summary = "Salva categoria", description = "Metodo responsavel por salvar categoria",
        security = @SecurityRequirement(name = "BearerAuth"))
    @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso",
        content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request);

    @Operation(summary = "Deleta categoria por id", description = "Metodo responsavel por deletar categoria por id",
        security = @SecurityRequirement(name = "BaererAuth"))
    @ApiResponse(responseCode = "204", description = "categoria deletada com sucesso",
        content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    @ApiResponse(responseCode = "404", description = "categoria nao encontrada",
        content = @Content())
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}
