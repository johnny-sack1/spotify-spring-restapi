package com.codecool.spotify.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="album")
public class Album {
    private long id;
    private int price;
    private String title;

    public Album(long id, int price, String title) {
        this.id = id;
        this.price = price;
        this.title = title;
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
