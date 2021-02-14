import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pstefaniak.mongo.ReservationMongoRepositoryApplication;
import pl.pstefaniak.mongo.reservation.repository.MongoReservationsRepository;
import pl.pstefaniak.mongo.reservation.repository.Reservation;
import pl.pstefaniak.mongo.room.RoomType;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReservationMongoRepositoryApplication.class)
public class ReservationServiceTest {

    @Autowired
    MongoReservationsRepository mongoReservationsRepository;

    @Value("${spring.data.mongodb.host}")
    String host;

    @Before
    public void setUp() {
        mongoReservationsRepository.save(new Reservation("", LocalDate.now(), LocalDate.now(), 2, RoomType.QUEEN));
    }

    @Test
    public void findReservation() {
        mongoReservationsRepository.save(new Reservation("", LocalDate.now(), LocalDate.now(), 2, RoomType.QUEEN));
        System.out.println(host);
    }
}
