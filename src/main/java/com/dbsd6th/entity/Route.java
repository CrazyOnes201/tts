package com.dbsd6th.entity;

import java.util.Date;

public class Route {
    private Integer id;

    private Integer trainId;

    private String stationName;

    private Integer routeSeq;

    private Integer nextDistance;

    private Date departureTime;

    private Date arriveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getRouteSeq() {
        return routeSeq;
    }

    public void setRouteSeq(Integer routeSeq) {
        this.routeSeq = routeSeq;
    }

    public Integer getNextDistance() {
        return nextDistance;
    }

    public void setNextDistance(Integer nextDistance) {
        this.nextDistance = nextDistance;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", trainId=" + trainId +
                ", stationName='" + stationName + '\'' +
                ", routeSeq=" + routeSeq +
                ", nextDistance=" + nextDistance +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                '}';
    }
}