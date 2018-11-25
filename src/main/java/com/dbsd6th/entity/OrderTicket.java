package com.dbsd6th.entity;

import java.util.Date;

public class OrderTicket {
    private Integer id;

    private Date orderTime;

    private String trainId;

    private Integer ticketPrice;

    private Integer seatId;

    private Integer seatType;

    private Integer userId;

    private String ticketId;

    private Integer arriveRouteId;

    private Integer depatureRouteId;

    private Integer effect;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getSeatType() {
        return seatType;
    }

    public void setSeatType(Integer seatType) {
        this.seatType = seatType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getArriveRouteId() {
        return arriveRouteId;
    }

    public void setArriveRouteId(Integer arriveRouteId) {
        this.arriveRouteId = arriveRouteId;
    }

    public Integer getDepatureRouteId() {
        return depatureRouteId;
    }

    public void setDepatureRouteId(Integer depatureRouteId) {
        this.depatureRouteId = depatureRouteId;
    }

    public Integer getEffect() {
        return effect;
    }

    public void setEffect(Integer effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "OrderTicket{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", trainId='" + trainId + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", seatId=" + seatId +
                ", seatType=" + seatType +
                ", userId=" + userId +
                ", ticketId='" + ticketId + '\'' +
                ", arriveRouteId=" + arriveRouteId +
                ", depatureRouteId=" + depatureRouteId +
                ", effect=" + effect +
                '}';
    }
}