package dev.java10x.movieflix.streaming.controller;


import dev.java10x.movieflix.streaming.mapper.StreamingMapper;
import dev.java10x.movieflix.streaming.model.Streaming;
import dev.java10x.movieflix.streaming.request.StreamingRequest;
import dev.java10x.movieflix.streaming.response.StreamingResponse;
import dev.java10x.movieflix.streaming.service.StreamingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    private final StreamingService service;

    public StreamingController(StreamingService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllCategories(){
        List<Streaming> streamings = service.getAllStreaming();
        return ResponseEntity.ok(streamings.stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getByCategoryId(@PathVariable Long id) {
        return service.getByStreamingId(id)
                .map(streaming -> ResponseEntity.ok().body(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request){
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming streaming = service.saveStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(streaming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
