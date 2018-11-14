package com.codecool.spotify.controllers;

class ResourceNotFoundException extends RuntimeException{
    ResourceNotFoundException(int id) {
        super("Could not find resource id: " + id);
    }
}
