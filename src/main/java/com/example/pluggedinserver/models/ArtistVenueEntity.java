package com.example.pluggedinserver.models;

import javax.persistence.*;

@Entity
class ArtistVenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    Artist artist;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    Venue venue;

}
