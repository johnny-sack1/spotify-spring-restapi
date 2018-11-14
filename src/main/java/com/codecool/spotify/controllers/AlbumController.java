package com.codecool.spotify.controllers;

import com.codecool.spotify.models.Album;
import com.codecool.spotify.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    private AlbumRepository repository;

    @GetMapping("/albums")
    public List<Album> all() {
        return repository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album one(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping(value = "/albums")
    public Album newAlbum(@RequestBody Album newAlbum) {
        return repository.save(newAlbum);
    }

    @PutMapping("/albums/{id}")
    public Album replaceAlbum(@RequestBody Album newAlbum, @PathVariable long id) {
        return repository.findById(id)
                .map(album -> {
                    album.setTitle(newAlbum.getTitle());
                    album.setPrice(newAlbum.getPrice());
                    return repository.save(newAlbum);
                })
                .orElseGet(() -> {
                    newAlbum.setId(id);
                    return repository.save(newAlbum);
                });
    }

    @DeleteMapping("albums/{id}")
    public void deleteAlbum(@PathVariable long id) {
        repository.deleteById(id);
    }
}