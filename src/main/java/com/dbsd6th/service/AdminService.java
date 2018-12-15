package com.dbsd6th.service;

import com.dbsd6th.entity.TrainAndTicket;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author hjs
 * @date 2018/12/11 18:27
 */
public interface AdminService {

     //管理员根据指定日期一键查询全部车次及余票信息
    public ArrayList<TrainAndTicket> selectAllTrainAndTicket(Date date);

    /** 管理员增加车次信息
     *  管理员需要增加的信息如下：（XXX）内的由数据库自动产生来引入，其他需要管理员手动录入
     *  1.train表
     *  (列车自动生成的id)，车次当天始发时间（年月日随便），当天结束时间，始发站，终点站，全程长度，列车类型id，经过站点总数，列车号
     *  2.route表
     *  (站点的唯一id)，(列车id自动生成)，站点名称，站点顺序号，与下一站的距离，该站当天出发时间（年月日随便），该站当天到达时间（年月日随便）
     */
      public Boolean adminAddTrainInfo(HashMap<String,Object> add);


    /** 管理员增加余票信息
     *  管理员需要增加的信息如下:
     *  管理员输入 列车号trainNum 以及 日期date 来为该日期下的该列车进行票数生成，插入到 ticket_count表里。具体各等级座位票数由系统自动参照trainType表
     *  不需要管理员手动录入
     */
      public Boolean adminAddTicketRemain(String trainNum,Date date);

}
