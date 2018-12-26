package com.dbsd6th.service.impl;

import com.dbsd6th.dao.RouteMapper;
import com.dbsd6th.entity.Route;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author hjs
 * @date 2018/11/28 23:27
 */
public class RouteServiceImplTest {
    private ApplicationContext applicationContext;
    @Autowired
    private RouteServiceImpl routeServiceImpl;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //加载spring配置文件

        routeServiceImpl = applicationContext.getBean(RouteServiceImpl.class);
        //在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findTransferStation() {
        try{
            if(routeServiceImpl == null) {
                System.out.println("routeServiceImpl 为空！");
            }
            /*SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
            Date chufashijian = adf.parse("2019-01-01");*/
            List<List<Route>> lists = routeServiceImpl.findTransferStation("深圳","无锡");
            System.out.println("从数据库中获得的查询结果为"+(lists.size()/2)+"条");
          /*  System.out.println(lists.get(0).get(0));
            System.out.println(lists.get(0).get(1));
            System.out.println(lists.get(1).get(0));
            System.out.println(lists.get(1).get(1));
            System.out.println(lists.get(0).get(2));
            System.out.println(lists.get(0).get(3));
            System.out.println(lists.get(1).get(2));
            System.out.println(lists.get(1).get(3));*/
            for (int i = 0; i < lists.get(0).size(); i=i+2) {
                System.out.println(lists.get(0).get(i));
                System.out.println(lists.get(0).get(i+1));
                System.out.println(lists.get(1).get(i));
                System.out.println(lists.get(1).get(i+1));
            }



        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}