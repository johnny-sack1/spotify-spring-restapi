package com.codecool.spotify.controller;

class ResourceNotFoundException extends RuntimeException{
    ResourceNotFoundException(int id) {
        super("Could not find resource id: " + id);
    }
}
