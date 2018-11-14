package com.codecool.spotify.services.ArtistService;

import com.codecool.spotify.models.Artist;
import com.codecool.spotify.repositories.ArtistRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(int id) {
        return artistRepository.findById(id);
    }
}
