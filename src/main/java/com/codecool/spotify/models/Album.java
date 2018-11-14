package com.codecool.spotify.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="album")
public class Album {
    private long id;
    private int price;
    private String title;
    private Artist artist;
    private int genre_id;

    @Column(name = "genre_id")
    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album(long id, int price, String title, Artist artist, int genre_id) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.artist = artist;
        this.genre_id = genre_id;
    }

    public Album() {}

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique=true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
