package pl.pstefaniak.mongo.reservation;

import lombok.Data;

import java.util.Date;

@Data
class ReservationRequest {
    private String name;
    private Date startDate;
    private Date endDate;
}
