package com.dbsd6th.service.impl;

import com.dbsd6th.dao.OrderTicketMapper;
import com.dbsd6th.dao.RouteMapper;
import com.dbsd6th.dao.SeatTypeMapper;
import com.dbsd6th.dao.TicketCountMapper;
import com.dbsd6th.entity.*;
import com.dbsd6th.service.OrderTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author hjs
 * @date 2018/12/2 18:41
 */

@Service
public class OrderTicketServiceImpl implements OrderTicketService {

    @Autowired
    private OrderTicketMapper orderTicketMapper;
    @Autowired
    private SearchTicketServiceImpl searchTicketServiceImpl;
    @Autowired
    private TicketCountMapper ticketCountMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private SeatTypeMapper seatTypeMapper;




    //购票（由于座位表还有待确定，不产生具体座位信息）
    public boolean buyTrainTicket(String level,TrainAndTicket trainAndTicket,User user) {
        Boolean isSuccess = false;//初始结果为购买失败

        //直达路线的购票逻辑
        if(trainAndTicket==null){
            return isSuccess;//没查到符合的车票，怎样购买都失败
        }else {
            try {
                SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
                String str = adf.format(trainAndTicket.getTicketCount().getOrderTime());
                Date sTime = adf.parse(str);
                HashMap<String, Object> input = new HashMap<String, Object>();
                input.put("sTime", sTime);
                input.put("level", level);
                input.put("tid", trainAndTicket.getTicketCount().getTrainId());
                /*input.put("nowNum",trainAndTicket.getTicketCount().);*/

                /*进行购票操作-1*/
                int result = this.ticketCountMapper.minusBySeatLevel(input);

                if (result == 1) {//购票成功
                    System.out.println("已经执行了对应车次的总票数-1，对应座位类型票数-1的子操作！");
                    List<Route> lists = this.routeMapper.getRouteListForCount(trainAndTicket.getTrainInfo().getTrainId(),
                            trainAndTicket.getTrainInfo().getRouteSeq1(),trainAndTicket.getTrainInfo().getRouteSeq2());
                    int totalDistance=0;
                    for (int i = 0; i < lists.size(); i++) {
                        totalDistance = totalDistance + lists.get(i).getNextDistance();//统计该直达路线的总距离(km)
                    }
                    BigDecimal perCost = this.seatTypeMapper.getPercostBySeatType(level);//获得对应座位的每公里运费(元/km)

                    BigDecimal price = new BigDecimal(Integer.toString(totalDistance)).multiply(perCost);//计算得到总票价

                    /*接下来进行生成订单操作*/
                    OrderTicket orderTicket = new OrderTicket();
                    /*orderTicket主键id自动生成并插入*/

                    orderTicket.setOrderTime(new Date());//设置用户当前购票时间
                    orderTicket.setTrainId(trainAndTicket.getTrainInfo().getTrainId());//设置用户所购车次id
                    orderTicket.setTicketPrice(price);//设置用户本次行程的总花费金额

                    //orderTicket.setSeatId(0);
                    //因为座位号码如何生成我们还没真正确定，所以我这一部分的赋值先忽略

                    orderTicket.setSeatType(level);//设置用户订购的座位类型
                    orderTicket.setUserId(user.getId());//设置用户个人的id号
                    orderTicket.setTicketId(trainAndTicket.getTicketCount().getId());//设置ticketCount的Id
                    orderTicket.setDepatureRouteId(trainAndTicket.getTrainInfo().getRouteSeq1());//设置出发站在该路线的序号
                    orderTicket.setArriveRouteId(trainAndTicket.getTrainInfo().getRouteSeq2());//设置目的站在该路线的序号
                    orderTicket.setEffect(new Integer(1));//订票生效

                    int flag = 0;//订票操作结果标志
                    flag = this.orderTicketMapper.insertSelective(orderTicket);
                    if(flag == 1){
                        System.out.println("已经执行了生成订单的操作！");
                        isSuccess = true;
                    }else{
                        System.out.println("购买成功，但生成订单失败！");
                        isSuccess = false;
                    }
                } else {
                    isSuccess = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return isSuccess;
        }
    }



}
