package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    //@Query
    List<Artist> findAllArtists();

}
