package com.dbsd6th.service;


import com.dbsd6th.entity.OrderTicket;
import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author hjs
 * @date 2018/11/29 16:42
 */


public interface OrderTicketService {

    //用户购票功能
    public boolean buyTrainTicket(String level, TrainAndTicket trainInfoList, User user);

    //用户查询所有历史订单（包括订票（生效）与退票（失效）记录）
    public ArrayList<HashMap<String,Object>> searchHistoryRecord(User user);

    //用户查询已成功订票的历史订单
    public ArrayList<HashMap<String,Object>> searchNeedRefundRecord(User user);

    //用户退票功能
    public boolean refundTrainTicket(Integer orderId);
}
