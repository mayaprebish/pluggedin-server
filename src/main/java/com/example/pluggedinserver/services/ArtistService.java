package com.example.pluggedinserver.services;

import com.example.pluggedinserver.models.Artist;
import com.example.pluggedinserver.models.Manager;
import com.example.pluggedinserver.repositories.ArtistRepository;
import com.example.pluggedinserver.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository repository;

    @Autowired
    ManagerRepository managerRepository;

    public List<Artist> createArtistForManager(Integer mid, Artist artist) {

        Manager manager = managerRepository.findManagerById(mid);
        List<Artist> originalArtists = manager.getArtists();
        originalArtists.add(artist);
        manager.setArtists(originalArtists);
        managerRepository.save(manager);

        Manager updatedManager = managerRepository.findManagerById(mid);
        artist.setManager(updatedManager);
        repository.save(artist);
        return repository.findAllArtistsForManager(mid);

    }

    public List<Artist> findAllArtistsForManager(Integer mid) {

        return repository.findAllArtistsForManager(mid);
    }

    public List<Artist> findAllArtists() {
        return repository.findAllArtists();
    }

    public Artist findArtistById(Integer aid) {
        return repository.findArtistById(aid);
    }

    public Artist updateArtist(Integer aid, Artist artist) {

        Artist curArtist = this.findArtistById(aid);

        curArtist.setId(artist.getId());
        curArtist.setGenre(artist.getGenre());
        curArtist.setLocation(artist.getLocation());
        curArtist.setManager(artist.getManager());
        curArtist.setName(artist.getName());
        curArtist.setVenues(artist.getVenues());

        repository.save(curArtist);
        return curArtist;
    }

    public List<Artist> deleteArtist(Integer aid) {

        repository.deleteById(aid);
        return (List<Artist>)repository.findAll();
    }


}
