package com.dbsd6th.entity;

import java.util.Date;

/**
 * @author hjs
 * @date 2018/11/24 16:35
 */
public class TrainInfo {
    private int trainId;
    private String trainNum;
    private String chufazhan;
    private String mudizhan;
    private Date departureTime;
    private Date arriveTime;

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getChufazhan() {
        return chufazhan;
    }

    public void setChufazhan(String chufazhan) {
        this.chufazhan = chufazhan;
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
                "trainId=" + trainId +
                ", trainNum='" + trainNum + '\'' +
                ", chufazhan='" + chufazhan + '\'' +
                ", mudizhan='" + mudizhan + '\'' +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                '}';
    }
}
