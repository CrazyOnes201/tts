package com.dbsd6th.entity;

import java.util.Date;

public class OrderTicket {
    private Integer id;//每一笔订单的编号

    private Date orderTime;//用户订购时间

    private String trainId;//列车号

    private Integer ticketPrice;//票价

    private Integer seatId;//座位

    private Integer seatType;//座位类型

    private Integer userId;//用户id

    private String ticketId;//列车票票号

    private Integer arriveRouteId;//目的站所在路线的Id

    private Integer depatureRouteId;//起始站所在路线Id

    private Integer effect;//是否有效，默认为1，当用户退票时，将该订单号置为0

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