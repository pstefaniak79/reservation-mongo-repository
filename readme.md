# Getting Started

curl -X POST http://localhost:8104/reservations/1/findAllReservations -H "Content-type:application/json" -d "{\"name\": \"Piotr\",\"startDate\": \"2020-01-01\",\"endDate\": \"2020-01-02\" }" | jq .

