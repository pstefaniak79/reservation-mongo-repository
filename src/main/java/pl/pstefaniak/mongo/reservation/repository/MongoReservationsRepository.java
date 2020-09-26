package pl.pstefaniak.mongo.reservation.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MongoReservationsRepository implements ReservationRepository {

    SpringDataReservationsRepository repository;

    @Override
    public boolean isEmpty() {
        return repository.count() == 0;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<Reservation> findOne(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Reservation> findByReservationId(long reservationId) {
        return repository.findByReservationId(reservationId);
    }

    @Override
    public List<Reservation> findByHotelId(long hotelId) {
        return repository.findByHotelId(hotelId);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    interface SpringDataReservationsRepository extends MongoRepository<Reservation, String> {
        List<Reservation> findByReservationId(long reservationId);

        List<Reservation> findByHotelId(long hotelId);
    }
}
