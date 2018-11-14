package com.codecool.spotify.controllers;

import com.codecool.spotify.models.Artist;
import com.codecool.spotify.services.ArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/artist/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public void update(@RequestBody Artist newArtist, @PathVariable long id) {
        artistService.findById(id)
            .map(album -> {
                album.setName(newArtist.getName());
                return artistService.save(newArtist);
            })
            .orElseGet(() -> {
                newArtist.setId(id);
                return artistService.save(newArtist);
            });
    }

    @GetMapping(value = "/artist", produces = "application/json")
    public List<Artist> getAll() {
        return artistService.findAll();
    }

    @GetMapping(value = "/artist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist getArtistById(@PathVariable int id) {
        return artistService.findById((long) id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping(value = "/artist")
    public void saveArtist(@RequestBody Artist artist) {
        artistService.save(artist);
    }

    @DeleteMapping("/artist/{id}")
    public void deleteArtist(@PathVariable long id) {
        artistService.deleteById(id);
    }
}
