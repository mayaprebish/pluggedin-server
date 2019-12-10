package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

    @Query("select booking from Booking booking where booking.id=:bid")
    public Booking findBookingById(@Param("bid") Integer id);

    @Query("select booking from Booking booking")
    public List<Booking> findAllBookings();

    @Query("select booking from Booking booking where booking.owner.id=:oid")
    public List<Booking> findAllBookingsForOwner(@Param("oid") Integer id);

    @Query("select booking from Booking booking where booking.tour.id=:tid")
    public List<Booking> findAllBookingsForTour(@Param("tid") Integer id);

    @Query("select booking from Booking booking where booking.venue.id=:vid")
    public List<Booking> findAllBookingsForVenue(@Param("vid") Integer id);

    @Query("select booking from Booking booking where booking.artist.id=:aid")
    public List<Booking> findAllBookingsForArtist(@Param("aid") Integer id);

}
