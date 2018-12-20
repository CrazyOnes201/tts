package com.dbsd6th.controller;

import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期四, 12/20 2018 15:30 UTC  **
 * *****************************************
 * *****************************************
 * **     用途:  用户订单表控制层      **
 * *****************************************
 */
@Controller
public class OrderTicketController {

    @Autowired
    private RouteService routeService;

    @RequestMapping("/preBuy/{tatIndex}")
    public String preBuy(HttpSession session, @PathVariable("tatIndex") Integer tatIndex) {
        List<TrainAndTicket> trainAndTicketList = (List<TrainAndTicket>)session.getAttribute("tatList");
        /*若无对应数据则返回到查询页面*/
        if(trainAndTicketList == null) {
            return "tots/searchTicket";
        }

        TrainAndTicket tarTat = trainAndTicketList.get(tatIndex);
        tarTat.getTrainInfo().setDistance(routeService.getDistance(tarTat));


        return null;
    }



    private static String transRowNameToSeatName(String seatType) {
        if (seatType.equals("stand_remain"))
            seatType = "无座";
        else if (seatType.equals("second_remain"))
            seatType = "二等座";
        else if (seatType.equals("first_remain"))
            seatType = "一等座";
        else if (seatType.equals("business_remain"))
            seatType = "商务座";
        else if (seatType.equals("soft_sleeper_remain"))
            seatType = "软卧";
        else if (seatType.equals("advanced_soft_remain"))
            seatType = "高级软卧";
        else if (seatType.equals("highspeed_sleeper_remain"))
            seatType = "动卧";
        else if (seatType.equals("hard_sleeper_remain"))
            seatType = "硬卧";
        else if (seatType.equals("soft_remain"))
            seatType = "软座";
        else if (seatType.equals("hard_remain"))
            seatType = "硬座";

        return seatType;
    }
}
