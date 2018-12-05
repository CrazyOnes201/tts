package com.dbsd6th.service.impl;

import com.dbsd6th.dao.RouteMapper;
import com.dbsd6th.dao.TicketCountMapper;
import com.dbsd6th.entity.Route;
import com.dbsd6th.entity.TicketCount;
import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.entity.TrainInfo;
import com.dbsd6th.service.SearchTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author hjs
 * @date 2018/12/2 15:22
 */

@Service
public class SearchTicketServiceImpl implements SearchTicketService {
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private RouteServiceImpl routeServiceImpl;
    @Autowired
    private TicketCountMapper ticketCountMapper;

    /*基本功能：根据车次信息进行余票查询，整合出具体车次信息+余票信息*/
    /*
      用户输入出发站：chufazhan
              目的站：mudizhan
              出发日期：chufashijian
              直达路线查询：flag
     */
    public ArrayList<TrainAndTicket> getTrainAndTicketList(String chufazhan, String mudizhan, Date chufashijian,int flag) {

        ArrayList<TrainAndTicket> resultList = new ArrayList<TrainAndTicket>();//存储车次信息和余票信息
        List<TrainInfo> routeList1 = new ArrayList<TrainInfo>();//存储“出发站-目的站”直达路线信息
        List<List<Route>> routeList2 = new ArrayList<List<Route>>();//存储“出发站-中转站,中转站-目的站”列表信息

        if(flag==1){//中转站路线的车次信息和余票信息整合.
            routeList2 = this.routeServiceImpl.findTransferStation(chufazhan,mudizhan,chufashijian);
            //有待开发中......
            //......
        }else{//直达路线的车次信息和余票信息整合

            routeList1 =  this.routeMapper.selectByStation(chufazhan,mudizhan,chufashijian);//直达路线车次信息

            for (int i = 0; i < routeList1.size(); i++) {
                TrainAndTicket trainAndTicket = new TrainAndTicket();
                HashMap<String, Object> input = new HashMap<String, Object>();
                input.put("sTime",chufashijian);
                Calendar c = Calendar.getInstance();
                c.setTime(chufashijian);
                c.add(Calendar.DAY_OF_MONTH,1);
                input.put("eTime",c.getTime());//出发日期+1
                input.put("tid",routeList1.get(i).getTrainId());
                TicketCount ticketCount = this.ticketCountMapper.searchTicket(input);//直达路线车次所对应的余票信息
                TrainInfo trainInfo = new TrainInfo();
                trainInfo.setTrainId(routeList1.get(i).getTrainId());
                trainInfo.setTrainNum(routeList1.get(i).getTrainNum());
                trainInfo.setChufazhan(routeList1.get(i).getChufazhan());
                trainInfo.setMudizhan(routeList1.get(i).getMudizhan());
                trainInfo.setDepartureTime(routeList1.get(i).getDepartureTime());
                trainInfo.setArriveTime(routeList1.get(i).getArriveTime());
                trainInfo.setRouteSeq1(routeList1.get(i).getRouteSeq1());
                trainInfo.setRouteSeq2(routeList1.get(i).getRouteSeq2());

                trainAndTicket.setTicketCount(ticketCount);
                trainAndTicket.setTrainInfo(trainInfo);

                resultList.add(trainAndTicket);//直达路线的车次信息和余票信息的整合
            }
        }

        return resultList;

    }
}
