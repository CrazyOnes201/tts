package com.dbsd6th.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author hjs
 * @date 2018/12/2 13:40
 */
public class TrainAndTicket {
    private TrainInfo trainInfo;
    private TicketCount ticketCount;

    public TrainInfo getTrainInfo() {
        return trainInfo;
    }

    public void setTrainInfo(TrainInfo trainInfo) {
        this.trainInfo = trainInfo;
    }

    public TicketCount getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(TicketCount ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "TrainAndTicket{" +
                "车次信息为：" + trainInfo +
                ", 余票信息为：" + ticketCount +
                '}';
    }
}
