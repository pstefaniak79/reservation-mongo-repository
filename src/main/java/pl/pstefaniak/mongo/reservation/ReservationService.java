package pl.pstefaniak.mongo.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pstefaniak.mongo.reservation.repository.Reservation;
import pl.pstefaniak.mongo.reservation.repository.ReservationRepository;

import java.util.List;

@AllArgsConstructor
@Component
public class ReservationService {
    ReservationRepository repository;

    public Reservation create(Reservation reservation) {
        return repository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        return repository.findAll();
    }

    public List<Reservation> findAllReservationsByHotelId(int hotelId) {
        return repository.findByHotelId(hotelId);
    }

}
