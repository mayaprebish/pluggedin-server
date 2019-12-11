package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Tour;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {

    @Query("select tour from Tour tour where tour.id=:tid")
    public Tour findTourById(@Param("tid") Integer tid);

    @Query("select tour from Tour tour where tour.manager.id=:mid")
    public List<Tour> findAllToursForManager(@Param("mid") Integer mid);

    @Query("select tour from Tour tour where tour.id=:tid and tour.manager.id=:mid")
    public Tour findTourForManager(@Param("mid") Integer mid, @Param("tid") Integer tid);

    @Transactional
    @Modifying
    @Query("delete from Tour tour where tour.id=:tid and tour.manager.id=:mid")
    public void deleteTour(@Param("tid") Integer tid, @Param("mid") Integer mid);
}
