package com.dbsd6th.entity;

import java.util.Date;

public class Route {
    private Integer id;

    private String trainId;

    private Integer stationName;

    private Integer routeSeq;

    private Integer nextDistance;

    private Date arriveTime;

    private Date departureTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public Integer getStationName() {
        return stationName;
    }

    public void setStationName(Integer stationName) {
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

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}