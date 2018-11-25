package com.dbsd6th.dao;

import com.dbsd6th.entity.TrainInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author hjs
 * @date 2018/11/24 18:31
 */
public class RouteMapperTest {

    private ApplicationContext applicationContext;
    @Autowired
    private RouteMapper routeMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //加载spring配置文件

        routeMapper = applicationContext.getBean(RouteMapper.class);
        //在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void selectByStation() {
    try {
        if(routeMapper == null) {
            System.out.println("route mapper is null!!!!");
        }
/*         SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
         Date date = adf.parse("2019-01-01");*/
         List<TrainInfo> list = routeMapper.selectByStation("深圳", "北京");
         System.out.println(list);
    }catch(Exception e){
        e.printStackTrace();
    }

    }
}