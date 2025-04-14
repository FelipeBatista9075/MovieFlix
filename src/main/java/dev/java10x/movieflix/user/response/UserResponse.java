package dev.java10x.movieflix.user.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String name,
                           String email) {
}
