package pl.pstefaniak.mongo;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.pstefaniak.mongo.reservation.repository.MongoReservationsJavaDriverRepository;
import pl.pstefaniak.mongo.reservation.repository.MongoReservationsRepository;
import pl.pstefaniak.mongo.reservation.repository.Reservation;
import pl.pstefaniak.mongo.room.RoomType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableMongoRepositories(considerNestedRepositories = true)
public class MongoConfig {


    @Bean
    public static ApplicationRunner testDataInitializer(MongoReservationsRepository repository, MongoReservationsJavaDriverRepository mongoReservationsJavaDriverRepository) {
        return args -> {
            repository.save(new Reservation("Piotr Stefaniak", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.QUEEN));
            repository.save(new Reservation("Aleksander Stefaniak", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.STANDARD));
            repository.save(new Reservation("Lena Stefaniak", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.STANDARD));


            Reservation magdalena_kaczmarska_reservation = new Reservation("Magdalena Kaczmarska", LocalDate.of(2020, 2, 12), LocalDate.of(2020, 2, 20), 1, RoomType.STANDARD);
            mongoReservationsJavaDriverRepository.save(magdalena_kaczmarska_reservation);

            Optional<Reservation> one = mongoReservationsJavaDriverRepository.findOne(magdalena_kaczmarska_reservation.getId());
            System.out.println(one);
        };
    }

    @Value("${spring.data.mongodb.host}")
    String host;

    @Value("${spring.data.mongodb.port}")
    int port;

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connString = new ConnectionString(
                "mongodb://" + host + ":" + port+"/reservation"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient;
    }

    @Bean
    public MongoReservationsJavaDriverRepository mongoReservationsJavaDriverRepository() {
        return new MongoReservationsJavaDriverRepository(mongoClient(), mongoTemplate());
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "reservation" );
    }
}
