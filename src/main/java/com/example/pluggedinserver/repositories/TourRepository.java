package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Tour;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {

    @Query("select tour from Tout tour where tour.id=:tid")
    public Tour findTourById(@Param("tid") Integer id);

    @Query("select tour from Tour tour where tour.manager.id=:mid")
    public List<Tour> findAllToursForManager(@Param("mid") Integer id);

}
