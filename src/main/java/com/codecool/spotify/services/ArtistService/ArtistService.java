package com.codecool.spotify.services.ArtistService;

import com.codecool.spotify.models.Artist;
import com.codecool.spotify.repositories.ArtistRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public Optional<Artist> findByName(String name) {
        return artistRepository.findByName(name);
    }

    public void deleteById(long id) {
        artistRepository.deleteById(id);
    }
}
