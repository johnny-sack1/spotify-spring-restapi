package com.codecool.spotify.controllers;

import com.codecool.spotify.models.Album;
import com.codecool.spotify.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    private AlbumRepository repository;

    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return repository.findAll();
    }
}
