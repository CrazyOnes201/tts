package com.dbsd6th.service.impl;

import com.dbsd6th.dao.TrainMapper;
import com.dbsd6th.entity.Route;
import com.dbsd6th.entity.TicketCount;
import com.dbsd6th.entity.Train;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author hjs
 * @date 2018/12/14 19:20
 */
public class AdminServiceImplTest {
    private ApplicationContext applicationContext;

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //加载spring配置文件

        adminServiceImpl = applicationContext.getBean(AdminServiceImpl.class);
        //在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void adminAddTrainInfo() throws ParseException {

        //管理员输入：
        String startTime = "2019-01-18 06:00:00";
        String endTime = "2019-01-18 11:00:00";
        String startStation = "珠海";
        String endStation = "厦门";
        Double totalDistance = 1000.0;
        Integer trainTypeId = 1;
        Integer totalStationNum = 3;
        String trainNum = "D886";
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sTime = adf.parse(startTime);
        Date eTime = adf.parse(endTime);

        Train addTrain = new Train();
        addTrain.setStartTime(sTime);
        addTrain.setEndTime(eTime);
        addTrain.setStartStationName(startStation);
        addTrain.setEndStationName(endStation);
        addTrain.setTotalDistance(totalDistance);
        addTrain.setTrainTypeId(trainTypeId);
        addTrain.setTotalStationNum(totalStationNum);
        addTrain.setTrainNum(trainNum);


        ArrayList<Route> routes = new ArrayList<Route>();
        Route route1 = new Route();//站点1
        route1.setStationName("珠海");
        route1.setArriveTime(adf.parse("2019-01-18 06:00:00"));
        route1.setDepartureTime(adf.parse("2019-01-18 06:10:00"));
        route1.setNextDistance(400);
        route1.setRouteSeq(1);


        Route route2 = new Route();//站点2
        route2.setStationName("汕头");
        route2.setArriveTime(adf.parse("2019-01-18 08:00:00"));
        route2.setDepartureTime(adf.parse("2019-01-18 08:10:00"));
        route2.setNextDistance(600);
        route2.setRouteSeq(2);

        Route route3 = new Route();//站点3
        route3.setStationName("厦门");
        route3.setArriveTime(adf.parse("2019-01-18 11:00:00"));
        route3.setDepartureTime(adf.parse("2019-01-18 11:00:00"));
        route3.setNextDistance(0);
        route3.setRouteSeq(3);

        routes.add(route1);
        routes.add(route2);
        routes.add(route3);

        HashMap<String,Object> info = new HashMap<String, Object>();
        info.put("Train",addTrain);
        info.put("routelist",routes);
        Boolean flag = this.adminServiceImpl.adminAddTrainInfo(info);
        if (flag = true){
            System.out.println("管理员增加车次成功！");
        }else{
            System.out.println("管理员增加车次失败！");
        }
    }

    @Test
    public void adminAddTicketRemain() {
        //管理员输入
        String trainNum = "D886";
        String generateNewTicketTime = "2019-01-18 06:00:00";

        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date time = adf.parse(generateNewTicketTime);
            Boolean flag = this.adminServiceImpl.adminAddTicketRemain(trainNum , time);
            if (flag == true){
                System.out.println("管理员增加日期为" + generateNewTicketTime + "列车号为" + trainNum + "的余票信息成功！");
            }else{
                System.out.println("管理员添加失败！");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}