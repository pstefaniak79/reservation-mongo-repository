package pl.pstefaniak.mongo.room;

import java.math.BigDecimal;

public enum RoomType {
    STANDARD(new BigDecimal(1)), QUEEN(new BigDecimal(100));

    BigDecimal roomPrice;

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    RoomType(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }
}

