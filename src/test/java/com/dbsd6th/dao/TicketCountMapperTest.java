package com.dbsd6th.dao;

import com.dbsd6th.entity.TicketCount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author hjs
 * @date 2018/11/29 14:04
 */
public class TicketCountMapperTest {

    private ApplicationContext applicationContext;
    @Autowired
    private TicketCountMapper ticketCountMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //加载spring配置文件

        ticketCountMapper = applicationContext.getBean(TicketCountMapper.class);
        //在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() {
        try{
            if(ticketCountMapper == null)
                System.out.println("ticketCountMapper is null!");
            TicketCount tc = this.ticketCountMapper.selectByPrimaryKey(1);
            System.out.println(tc);
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}