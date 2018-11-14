package com.codecool.spotify.controllers;

class ResourceNotFoundException extends RuntimeException{
    ResourceNotFoundException(long id) {
        super("Could not find resource id: " + id);
    }
}
