package pl.pstefaniak.mongo.reservation;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@AllArgsConstructor
//@RequestMapping("/")
public class ReservationController {

    private ReservationService reservationService;

    @Timed(value = "find_all_reservations")
    @GetMapping("/findAllReservations")
    public List<ReservationRepresentation> findAllReservations() {
        return reservationService.findAllReservations().stream()
                .map(ReservationRepresentation::of)
                .collect(toList());
    }

    @Timed(value = "find_all_reservations_in_hotel")
    @PostMapping("/{hotelId}/findAllReservations")
    public List<ReservationRepresentation> calculateFor(@PathVariable("hotelId") int hotelId,
                                                        @RequestBody ReservationRequest request) {
        return reservationService.findAllReservationsByHotelId(hotelId).stream()
                .map(ReservationRepresentation::of)
                .collect(toList());
    }

}
