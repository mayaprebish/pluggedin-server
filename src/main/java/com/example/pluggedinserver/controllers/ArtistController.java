package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Artist;
import com.example.pluggedinserver.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ArtistController {

    @Autowired
    ArtistService service;

    @PostMapping("api/users/managers/{mid}/artists")
    public List<Artist> createArtistForManager(@PathVariable("mid") Integer mid,
                                           @RequestBody Artist artist) {
        return service.createArtistForManager(mid, artist);
    }

    @GetMapping("api/users/managers/{mid}/artists")
    public List<Artist> findAllArtistsForManager(@PathVariable("mid") Integer mid) {
        return service.findAllArtistsForManager(mid);
    }

    @GetMapping("api/artists")
    public List<Artist> findAllArtists() {
        return service.findAllArtists();
    }

    @GetMapping("api/artists/{aid}")
    public Artist findArtistById(@PathVariable("aid") Integer aid) {
        return service.findArtistById(aid);
    }

    @PutMapping("api/artists/{tid}")
    public Artist updateTour(@PathVariable("aid") Integer aid, @RequestBody Artist artist) {
        return service.updateArtist(aid, artist);
    }

    @DeleteMapping("api/artists/{aid}")
    public List<Artist> deleteArtist(@PathVariable("aid") Integer aid) {
        return service.deleteArtist(aid);
    }

}
