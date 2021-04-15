# Getting Started

curl -X POST http://localhost:8104/reservations/1/findAllReservations -H "Accept: application/json" -H "Content-type:application/json" -d "{\"name\": \"Piotr\",\"startDate\": \"2020-01-01\",\"endDate\": \"2020-01-02\" }" | jq .
curl -X POST http://localhost:8104/reservations/3/addReservation -H "Content-Type: application/json" -d "{\"reservationId\": \"0\", \"hotelId\": \"3\", \"name\":\"Piotr\", \"startDate\":\"2021-01-01\" , \"endDate\": \"2021-01-05\"}"