package pl.pstefaniak.mongo.reservation;

import lombok.*;
import pl.pstefaniak.mongo.reservation.repository.Reservation;
import pl.pstefaniak.mongo.reservation.repository.ReservationMapper;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ReservationRepresentation {
    private long reservationId;

    private int hotelId;

    private String name;

    private LocalDate startDate;


    private LocalDate endDate;

    static ReservationRepresentation of(Reservation reservation) {
        return ReservationMapper.INSTANCE.reservationToReservationRepresentation(reservation);
    }
}

