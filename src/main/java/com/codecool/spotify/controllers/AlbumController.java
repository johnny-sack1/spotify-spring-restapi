package com.codecool.spotify.controllers;

import com.codecool.spotify.exceptions.AlbumNotFoundException;
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

    @PostMapping(value = "/albums")
    public Album newAlbum(@RequestBody Album newAlbum) {
        return repository.save(newAlbum);
    }

    @GetMapping("/albums/{id}")
    public Album one(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new AlbumNotFoundException(id));
    }
}
