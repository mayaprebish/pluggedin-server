package com.example.pluggedinserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * An artist is a band or music creator with a name, a location and a genre. Tour managers have many artists listed
 * on their profiles.
 */
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private String genre;

    @ManyToOne
    @JsonIgnore
    private Manager manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<ArtistVenueEntity> getVenues() {
        return venues;
    }

    public void setVenues(List<ArtistVenueEntity> venues) {
        this.venues = venues;
    }

    // venues that this artist has played at
    // represents many to many relationship
    @OneToMany(mappedBy = "artist")
    private List<ArtistVenueEntity> venues;

    public Artist(String name, String location, String genre, Manager manager) {
        this.name = name;
        this.location = location;
        this.genre = genre;
        this.manager = manager;
        this.venues = new ArrayList<>();
    }

    public Artist() {}
}
