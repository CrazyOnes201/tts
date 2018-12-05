package com.dbsd6th.service;

import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.entity.TrainInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author hjs
 * @date 2018/12/2 14:59
 */


public interface SearchTicketService {

    /*基本功能：整合车次信息加余票信息*/
    public ArrayList<TrainAndTicket> getTrainAndTicketList(String chufazhan, String mudizhan, Date chufashijian,int flag);

}
