package com.codecool.spotify.repositories;

import com.codecool.spotify.models.Artist;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findAll();
    Optional<Artist> findById(Long id);
    Optional<Artist> findByName(String name);
}
