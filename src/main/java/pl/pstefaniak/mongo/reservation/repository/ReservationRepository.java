package pl.pstefaniak.mongo.reservation.repository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    boolean isEmpty();

    long count();

    Optional<Reservation> findOne(String id);

    List<Reservation> findAll();

    List<Reservation> findByReservationId(long reservationId);

    List<Reservation> findByHotelId(long hotelId);


    Reservation save(Reservation reservation);
}
