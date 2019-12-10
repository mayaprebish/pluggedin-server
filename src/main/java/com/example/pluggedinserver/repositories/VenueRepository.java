package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VenueRepository extends CrudRepository<Venue, Integer> {

    @Query("select venue from Venue venue where venue.id=:vid")
    public Venue findVenueById(@Param("vid") Integer id);

}
