package dev.java10x.movieflix.streaming.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
