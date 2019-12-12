package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Artist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    @Query("select artist from Artist artist where artist.manager.id=:mid")
    public List<Artist> findAllArtistsForManager(@Param("mid") Integer id);

    @Query("select artist from Artist artist")
    public List<Artist> findAllArtists();

    @Query("select artist from Artist artist where artist.id=:aid")
    public Artist findArtistById(@Param("aid") Integer aid);

    @Transactional
    @Modifying
    @Query("delete from Artist artist where artist.id=:aid and artist.manager.id=:mid")
    public void deleteArtist(@Param("aid") Integer aid,
                             @Param("mid") Integer mid);
}
