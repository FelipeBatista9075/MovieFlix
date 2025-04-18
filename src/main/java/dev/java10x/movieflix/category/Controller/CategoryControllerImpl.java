package dev.java10x.movieflix.category.Controller;

import dev.java10x.movieflix.category.mapper.CategoryMapper;
import dev.java10x.movieflix.category.model.Category;
import dev.java10x.movieflix.category.request.CategoryRequest;
import dev.java10x.movieflix.category.response.CategoryResponse;
import dev.java10x.movieflix.category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryControllerImpl implements CategoryController{

    private final CategoryService service;

    public CategoryControllerImpl(CategoryService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<Category> categories = service.getAllCategories();
        return ResponseEntity.ok(categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id) {
        return service.getByCategoryId(id)
                .map(category -> ResponseEntity.ok().body(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category category = service.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
