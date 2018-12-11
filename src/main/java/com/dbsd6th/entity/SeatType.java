package com.dbsd6th.entity;

import java.math.BigDecimal;

public class SeatType {
    private String seattype;

    private BigDecimal percost;

    public String getSeattype() {
        return seattype;
    }

    public void setSeattype(String seattype) {
        this.seattype = seattype;
    }

    public BigDecimal getPercost() {
        return percost;
    }

    public void setPercost(BigDecimal percost) {
        this.percost = percost;
    }

    @Override
    public String toString() {
        return "SeatType{" +
                "seattype='" + seattype + '\'' +
                ", percost=" + percost +
                '}';
    }
}