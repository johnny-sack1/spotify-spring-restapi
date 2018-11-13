package com.codecool.spotify.exceptions;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException(long id) {
        super("Could not find album " + id);
    }
}