package com.kodilla.patterns.enums.hotel;

import java.math.BigDecimal;

public enum Season {

    LOW(new BigDecimal(250), new BigDecimal(350), new BigDecimal(400)),
    HIGH(new BigDecimal(320), new BigDecimal(400), new BigDecimal(470)),
    HOLIDAY(new BigDecimal(400), new BigDecimal(500), new BigDecimal(550));

    private final BigDecimal singleRoomPrice;
    private final BigDecimal doubleRoomPrice;
    private final BigDecimal vipRoomPrice;

    Season(BigDecimal singleRoomPrice, BigDecimal doubleRoomPrice, BigDecimal vipRoomPrice) {
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
        this.vipRoomPrice = vipRoomPrice;
    }

    public BigDecimal getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public BigDecimal getDoubleRoomPrice() {
        return doubleRoomPrice;
    }

    public BigDecimal getVipRoomPrice() {
        return vipRoomPrice;
    }
}
