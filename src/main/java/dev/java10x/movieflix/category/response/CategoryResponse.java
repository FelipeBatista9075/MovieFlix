package dev.java10x.movieflix.category.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
