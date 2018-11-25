package com.dbsd6th.entity;

import java.sql.Date;

/**
 * @author hjs
 * @date 2018/11/24 16:35
 */
public class TrainInfo {
    private String trainNum;
    private String chufanzhan;
    private String mudizhan;
    private Date departureTime;
    private Date arriveTime;

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getChufanzhan() {
        return chufanzhan;
    }

    public void setChufanzhan(String chufanzhan) {
        this.chufanzhan = chufanzhan;
    }

    public String getMudizhan() {
        return mudizhan;
    }

    public void setMudizhan(String mudizhan) {
        this.mudizhan = mudizhan;
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
        return "TrainInfo{" +
                "trainNum='" + trainNum + '\'' +
                ", chufanzhan='" + chufanzhan + '\'' +
                ", mudizhan='" + mudizhan + '\'' +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                '}';
    }
}
