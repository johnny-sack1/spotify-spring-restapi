package com.codecool.spotify.repository;

import com.codecool.spotify.model.Artist;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist> findAll();
    Optional<Artist> findById(int id);
}
