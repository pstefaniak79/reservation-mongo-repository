import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pstefaniak.mongo.ActuatorConfig;
import pl.pstefaniak.mongo.MongoConfig;
import pl.pstefaniak.mongo.reservation.ReservationService;
import pl.pstefaniak.mongo.reservation.repository.MongoReservationsRepository;
import pl.pstefaniak.mongo.reservation.repository.Reservation;

import java.math.BigDecimal;

//@TestPropertySource(properties = { "spring.config.location=classpath:application.properties" })
@SpringBootTest(classes = { MongoConfig.class} )
//@ComponentScan(basePackages = "pl.pstefaniak")
@DataMongoTest
@RunWith(SpringRunner.class)
public class ReservationServiceTest {

    //@Autowired
    //MongoReservationsRepository mongoReservationsRepository;


    @BeforeAll
    public void setUp() {
       // mongoReservationsRepository.save(new Reservation(1l, 4l, new BigDecimal(500)));
    }

    @Test
    public void findReservation() {
        //mongoReservationsRepository.save(new Reservation(1l, 4l, new BigDecimal(500)));
    }
}
