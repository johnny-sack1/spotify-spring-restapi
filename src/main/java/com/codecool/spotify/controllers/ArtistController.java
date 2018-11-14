package com.codecool.spotify.controllers;

import com.codecool.spotify.models.Artist;
import com.codecool.spotify.services.ArtistService.ArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist getArtistById(@PathVariable int id) {
        return artistService.getArtistById((long) id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping
    public void saveArtist(@RequestBody Artist artist) {
        artistService.save(artist);
    }
}
