package com.codecool.spotify.service.ArtistService;

import com.codecool.spotify.model.Artist;
import com.codecool.spotify.repository.ArtistRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }
}
