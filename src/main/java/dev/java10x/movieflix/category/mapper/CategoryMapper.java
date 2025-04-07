package dev.java10x.movieflix.category.mapper;

import dev.java10x.movieflix.category.model.Category;
import dev.java10x.movieflix.category.request.CategoryRequest;
import dev.java10x.movieflix.category.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
