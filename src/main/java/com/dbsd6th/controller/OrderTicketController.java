package com.dbsd6th.controller;

import com.dbsd6th.entity.SeatType;
import com.dbsd6th.entity.TicketCount;
import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.entity.User;
import com.dbsd6th.service.OrderTicketService;
import com.dbsd6th.service.RouteService;
import com.dbsd6th.service.SeatTypeService;
import com.dbsd6th.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SeatTypeService seatTypeService;
    @Autowired
    private OrderTicketService orderTicketService;

    @RequestMapping("/preBuy/{tatIndex}")
    public String preBuy(HttpSession session, @PathVariable("tatIndex") Integer tatIndex) {
        List<TrainAndTicket> trainAndTicketList = (List<TrainAndTicket>)session.getAttribute("tatList");
        /*若无对应数据则返回到查询页面*/
        if(trainAndTicketList == null) {
            return "tots/searchTicket";
        }

        TrainAndTicket tarTat = trainAndTicketList.get(tatIndex);
        List<Map<String, Object>> seatFormList = getSeatTypeForm(tarTat);

        session.setAttribute("tarTat", tarTat);
        session.setAttribute("seatFormList", seatFormList);

        return "tots/showticket";
    }

    @RequestMapping("/adPreBuy/{tatIndex}")
    public String adPreBuy(HttpSession session, @PathVariable("tatIndex") Integer tatIndex) {
        List<TrainAndTicket> trainAndTicketList = (List<TrainAndTicket>)session.getAttribute("adtatList");
        /*若无对应数据则返回到查询页面*/
        if(trainAndTicketList == null) {
            return "tots/searchTicket";
        }

        TrainAndTicket tarTat = trainAndTicketList.get(tatIndex);
        List<Map<String, Object>> seatFormList = getSeatTypeForm(tarTat);

        session.setAttribute("tarTat", tarTat);
        session.setAttribute("seatFormList", seatFormList);

        return "tots/showticket";
    }

    private List<Map<String, Object>> getSeatTypeForm(TrainAndTicket tarTat) {
        tarTat.getTrainInfo().setDistance(routeService.getDistance(tarTat));
        List<SeatType> seatTypeList = seatTypeService.getAllSeatType();

        List<Map<String, Object>> seatFormList = new ArrayList<Map<String, Object>>();
        for(SeatType seatType: seatTypeList) {
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("type", transRowNameToSeatName(seatType.getSeattype()));
            map.put("ticketNum", getSeatRemainFromName(seatType.getSeattype(), tarTat.getTicketCount()));
            map.put("cost", seatType.getPercost().multiply(
                    BigDecimal.valueOf(tarTat.getTrainInfo().getDistance())
            ).setScale(2, BigDecimal.ROUND_HALF_UP));
            map.put("typeRowName", seatType.getSeattype());

            seatFormList.add(map);
        }

        return seatFormList;
    }

    @RequestMapping(path = "/buyOneTicket", method = RequestMethod.POST)
    public String buyOneTicket(HttpSession session, String tarLevel) {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "/tots/login";
        }

        TrainAndTicket tat = (TrainAndTicket)session.getAttribute("tarTat");
        if(tat == null || StringUtil.isEmpty(tarLevel)) {
            return "/tots/searchTicket";
        }

        session.removeAttribute("tarTat");
        session.removeAttribute("isPostResponse");
        session.removeAttribute("tatList");
        if(orderTicketService.buyTrainTicket(tarLevel, tat, user)) {
            return "/tots/userinfo";
        } else {
            return "/tots/searchTicket";
        }
    }

    @RequestMapping(path = "/getMyTicket", method = RequestMethod.POST)
    public String getMyTicket(HttpSession session, Model model) {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "/tots/login";
        }

        model.addAttribute("userticketList", orderTicketService.searchHistoryRecord(user));

        return "/tots/userinfo";
    }

    @RequestMapping(path = "/refundTicket", method = RequestMethod.POST)
    public String refundTicket(Integer orderId) {
        orderTicketService.refundTrainTicket(orderId);

        return "/tots/userinfo";
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

    private static Integer getSeatRemainFromName(String seatType, TicketCount ticketCount) {
        Integer result = null;
        if (seatType.equals("stand_remain"))
            result = ticketCount.getStandRemain();
        else if (seatType.equals("second_remain"))
            result = ticketCount.getSecondRemain();
        else if (seatType.equals("first_remain"))
            result = ticketCount.getFirstRemain();
        else if (seatType.equals("business_remain"))
            result = ticketCount.getBusinessRemain();
        else if (seatType.equals("soft_sleeper_remain"))
            result = ticketCount.getSoftSleeperRemain();
        else if (seatType.equals("advanced_soft_remain"))
            result = ticketCount.getAdvancedSoftRemain();
        else if (seatType.equals("highspeed_sleeper_remain"))
            result = ticketCount.getHighspeedSleeperRemain();
        else if (seatType.equals("hard_sleeper_remain"))
            result = ticketCount.getHardSleeperRemain();
        else if (seatType.equals("soft_remain"))
            result = ticketCount.getSoftRemain();
        else if (seatType.equals("hard_remain"))
            result = ticketCount.getHardRemain();

        return result;
    }
}
