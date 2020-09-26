package pl.pstefaniak.mongo.reservation.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.pstefaniak.mongo.reservation.ReservationRepresentation;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mappings({
            @Mapping(target = "reservationId", source = "r.reservationId"),
            @Mapping(target = "hotelId", source = "r.hotelId"),
            @Mapping(target = "name", source = "r.name"),
            @Mapping(target = "startDate", source = "r.startDate"),
            @Mapping(target = "endDate", source = "r.endDate"),

    })
    ReservationRepresentation reservationToReservationRepresentation(Reservation r);

    @Mappings({
            @Mapping(target = "reservationId", source = "rr.reservationId"),
            @Mapping(target = "hotelId", source = "rr.hotelId"),
            @Mapping(target = "name", source = "rr.name"),
            @Mapping(target = "startDate", source = "rr.startDate"),
            @Mapping(target = "endDate", source = "rr.endDate")
    })
    Reservation reservationRepresentationToReservation(ReservationRepresentation rr);


}
