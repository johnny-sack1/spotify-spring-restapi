package com.codecool.spotify.repository;

import com.codecool.spotify.model.Artist;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist> findAll();
}
