package com.dbsd6th.service.impl;

import com.dbsd6th.dao.RouteMapper;
import com.dbsd6th.entity.TrainAndTicket;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author hjs
 * @date 2018/12/2 17:15
 */
public class SearchTicketServiceImplTest {

    private ApplicationContext applicationContext;
    @Autowired
    private SearchTicketServiceImpl searchTicketServiceImpl;


    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //加载spring配置文件

        searchTicketServiceImpl = applicationContext.getBean(SearchTicketServiceImpl.class);
        //在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    /*测试查票逻辑（将车次信息+余票信息整合并传给前端）*/
    public void getTrainAndTicketList() throws Exception{
        if(searchTicketServiceImpl == null) {
            System.out.println("searchTicketServiceImpl 为空！");
        }
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
        Date chufashijian = adf.parse("2019-01-15");
        ArrayList<TrainAndTicket> resultList = this.searchTicketServiceImpl.getTrainAndTicketList("深圳",
                "石家庄",chufashijian,0);//直达路线余票查询
        System.out.println("车次余票信息记录有："+resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }
}