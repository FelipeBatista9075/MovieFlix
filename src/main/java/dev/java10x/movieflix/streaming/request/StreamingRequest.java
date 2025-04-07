package dev.java10x.movieflix.streaming.request;

import lombok.Builder;

@Builder
public record StreamingRequest(String name) {
}
