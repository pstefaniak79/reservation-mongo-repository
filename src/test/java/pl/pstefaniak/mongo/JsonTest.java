package pl.pstefaniak.mongo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.bson.Document;
import pl.pstefaniak.mongo.reservation.ReservationRepresentation;
import pl.pstefaniak.mongo.reservation.repository.Reservation;
import pl.pstefaniak.mongo.room.RoomType;

import java.io.IOException;
import java.time.LocalDate;

public class JsonTest {


    public static void main(String[] args) {
        Reservation reservation = new Reservation("Piotr Stefaniak", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.QUEEN);


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            String json = mapper.findAndRegisterModules().writerWithDefaultPrettyPrinter().writeValueAsString(ReservationRepresentation.of(reservation));
            System.out.println(json);

            //Use pretty print for printing the output
//            String beutifulJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reservation);
//            System.out.println(beutifulJson);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
