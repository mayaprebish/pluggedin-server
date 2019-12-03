package com.example.pluggedinserver.models;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private String genre;

    // many venues
    // one manager

    public Artist() {}
}
