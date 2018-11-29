package com.dbsd6th.service;

import com.dbsd6th.entity.TrainInfo;

import java.util.List;

/**
 * @author hjs
 * @date 2018/11/29 16:42
 */
public interface OrderTicketService {
    //用户购票功能
    public boolean buyTrainTicket(List<TrainInfo> trainInfoList);
}
