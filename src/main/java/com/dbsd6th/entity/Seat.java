package com.dbsd6th.entity;

public class Seat {
    private Integer seatid;

    private Integer seatstatus;

    private Integer seattype;

    private Integer kmprice;

    private String trainid;

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public Integer getSeatstatus() {
        return seatstatus;
    }

    public void setSeatstatus(Integer seatstatus) {
        this.seatstatus = seatstatus;
    }

    public Integer getSeattype() {
        return seattype;
    }

    public void setSeattype(Integer seattype) {
        this.seattype = seattype;
    }

    public Integer getKmprice() {
        return kmprice;
    }

    public void setKmprice(Integer kmprice) {
        this.kmprice = kmprice;
    }

    public String getTrainid() {
        return trainid;
    }

    public void setTrainid(String trainid) {
        this.trainid = trainid;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatid=" + seatid +
                ", seatstatus=" + seatstatus +
                ", seattype=" + seattype +
                ", kmprice=" + kmprice +
                ", trainid='" + trainid + '\'' +
                '}';
    }
}