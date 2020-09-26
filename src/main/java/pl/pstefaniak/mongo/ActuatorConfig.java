package pl.pstefaniak.mongo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pstefaniak.mongo.reservation.repository.ReservationRepository;

@Configuration
public class ActuatorConfig {

    @Bean
    HealthIndicator countHealthIndicator(ReservationRepository reservationRepository) {
        return () -> {

            Status status = reservationRepository.count() > 0 ? Status.UP : Status.DOWN;
            return Health.status(status)
                    .build();
        };
    }
}
