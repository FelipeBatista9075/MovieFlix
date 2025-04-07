package dev.java10x.movieflix.streaming.service;

import dev.java10x.movieflix.category.model.Category;
import dev.java10x.movieflix.streaming.model.Streaming;
import dev.java10x.movieflix.streaming.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository repository;

    public StreamingService(StreamingRepository repository) {
        this.repository = repository;
    }

    public List<Streaming> getAllStreaming(){
        return repository.findAll();
    }

    public Optional<Streaming> getByStreamingId(Long id){
        return repository.findById(id);
    }

    public Streaming saveStreaming(Streaming streaming){
        return repository.save(streaming);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
