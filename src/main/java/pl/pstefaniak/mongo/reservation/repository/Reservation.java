package pl.pstefaniak.mongo.reservation.repository;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pstefaniak.mongo.room.RoomType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import static java.math.BigDecimal.ZERO;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reservation {
    public Reservation(String name, LocalDate startDate, LocalDate endDate, int hotelId, RoomType roomType) {
        this.roomPrice = roomType.getRoomPrice();
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.hotelId = hotelId;
    }

    @Id
    private String id;

    @NotNull
    RoomType roomType;

    @NotNull
    int hotelId;

    @NotNull
    private long reservationId;

    @NotNull
    private String name;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private BigDecimal roomPrice;

    private ReservationStatus reservationStatus = ReservationStatus.OPEN;

    @NotNull
    private BigDecimal price = ZERO;

    private BigDecimal calculatePriceOf(LocalDate startDate, LocalDate endDate, RoomType roomType) {
        return roomType.getRoomPrice().multiply(BigDecimal.valueOf(Period.between(endDate, startDate).getDays()));
    }
}
