package pl.pstefaniak.mongo.reservation.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pl.pstefaniak.mongo.reservation.ReservationRepresentation;

import java.util.List;
import java.util.Optional;


public class MongoReservationsJavaDriverRepository implements ReservationRepository {
    private final SpringDataReservationsJavaDriverRepository repository;

    public MongoReservationsJavaDriverRepository(MongoClient mongoClient, MongoTemplate mongoTemplate) {
        repository = new SpringDataReservationsJavaDriverRepositoryImpl(mongoClient, mongoTemplate);
    }

    @Override
    public boolean isEmpty() {
        return repository.count() == 0;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<Reservation> findOne(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Reservation> findByReservationId(long reservationId) {
        return repository.findByReservationId(reservationId);
    }

    @Override
    public List<Reservation> findByHotelId(long hotelId) {
        return repository.findByHotelId(hotelId);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    interface SpringDataReservationsJavaDriverRepository {
        List<Reservation> findByReservationId(long reservationId);

        List<Reservation> findByHotelId(long hotelId);

        long count();

        List<Reservation> findAll();

        Optional<Reservation> findById(String reservationId);

        Reservation save(Reservation r);
    }

    @AllArgsConstructor
    class SpringDataReservationsJavaDriverRepositoryImpl implements SpringDataReservationsJavaDriverRepository {

        private final MongoClient mongoClient;
        private final MongoTemplate mongoTemplate;

//        public SpringDataReservationsJavaDriverRepositoryImpl(MongoClient mongoClient) {
//            this.mongoClient = mongoClient;
//        }

        @Override
        public List<Reservation> findByReservationId(long reservationId) {
            return null;
        }

        @Override
        public List<Reservation> findByHotelId(long hotelId) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public List<Reservation> findAll() {
            return null;
        }

        @Override
        public Optional<Reservation> findById(String id) {
            return Optional.ofNullable(mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Reservation.class));
        }

        @Override
        public Reservation save(Reservation r) {
            MongoCollection<Document> chopinReservations = mongoClient.getDatabase("reservation").getCollection("reservation");

//            Document document = new Document("name", "Café Con Leche")
//                    .append("roomPrice", r.getName())
//                    .append("roomType", r.getRoomType().name())
//                    .append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));

            Document document = Document.parse(ReservationRepresentation.of(r).toJson());

            chopinReservations.insertOne(document);
            r.setId(document.get("_id").toString());

            return r;
        }
    }

}
