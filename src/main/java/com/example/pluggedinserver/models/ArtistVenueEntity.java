package com.example.pluggedinserver.models;

import javax.persistence.*;

@Entity
class ArtistVenueEntity {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    Artist artist;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    Venue venue;

}
