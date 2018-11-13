package com.codecool.spotify.repositories;

import com.codecool.spotify.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
