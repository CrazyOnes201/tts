package com.dbsd6th.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hjs
 * @date 2018/12/4 17:46
 */
public class SeatTypeMapperTest {

    private ApplicationContext applicationContext;

    @Autowired
    private SeatTypeMapper seatTypeMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        seatTypeMapper = applicationContext.getBean(SeatTypeMapper.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPercostBySeatType() {
        System.out.println(this.seatTypeMapper.getPercostBySeatType("soft_remain"));
    }

}