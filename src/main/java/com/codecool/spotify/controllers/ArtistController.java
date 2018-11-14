package com.codecool.spotify.controllers;

import com.codecool.spotify.models.Artist;
import com.codecool.spotify.services.ArtistService.ArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping(produces = "application/json")
    public List<Artist> getAll() {
        return artistService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Artist getArtistById(@PathVariable int id) {
        return artistService.getArtistById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
