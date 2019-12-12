package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Venue;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VenueRepository extends CrudRepository<Venue, Integer> {

    @Query("select venue from Venue venue where venue.owner.id=:oid")
    public List<Venue> findAllByOwner(@Param("oid") Integer oid);

    @Query("select venue from Venue venue")
    public List<Venue> findAllVenues();

    @Query("select venue from Venue venue where venue.id=:vid")
    public Venue findVenueById(@Param("vid") Integer vid);

    @Query("select venue from Venue venue where venue.stringKey=:key")
    public Venue findVenueByKey(@Param("key") String key);

    @Query("select venue from Venue venue where venue.id=:vid and venue.owner.id=:oid")
    public Venue findVenueForOwner(@Param("vid") Integer vid, @Param("oid") Integer oid);

    @Transactional
    @Modifying
    @Query("delete from Venue venue where venue.id=:vid and venue.owner.id=:oid")
    public void deleteVenue(@Param("vid") Integer vid, @Param("oid") Integer oid);
}
