package dev.java10x.movieflix.category.service;

import dev.java10x.movieflix.category.model.Category;
import dev.java10x.movieflix.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    public Optional<Category> getByCategoryId(Long id){
        return repository.findById(id);
    }

    public Category saveCategory(Category category){
        return repository.save(category);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
