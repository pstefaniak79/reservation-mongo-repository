package pl.pstefaniak.mongo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.pstefaniak.mongo.reservation.repository.MongoReservationsRepository;
import pl.pstefaniak.mongo.reservation.repository.Reservation;
import pl.pstefaniak.mongo.room.RoomType;

import java.time.LocalDate;

@Configuration
@EnableMongoRepositories(considerNestedRepositories = true)
public class MongoConfig {

    @Bean
    public static ApplicationRunner testDataInitializer(MongoReservationsRepository repository) {
        return args -> {
            repository.save(new Reservation("Piotr Stefaniak", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.QUEEN));
            repository.save(new Reservation("Aleksander Stefaniak", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.STANDARD));
            repository.save(new Reservation("Lena Stefaniak", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.STANDARD));
        };
    }


}
