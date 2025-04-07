package dev.java10x.movieflix.streaming.mapper;

import dev.java10x.movieflix.streaming.model.Streaming;
import dev.java10x.movieflix.streaming.request.StreamingRequest;
import dev.java10x.movieflix.streaming.response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
