package com.dbsd6th.service;


import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.entity.User;

import java.util.ArrayList;


/**
 * @author hjs
 * @date 2018/11/29 16:42
 */


public interface OrderTicketService {

    //用户购票功能
    public boolean buyTrainTicket(String level, TrainAndTicket trainInfoList, User user);
}
