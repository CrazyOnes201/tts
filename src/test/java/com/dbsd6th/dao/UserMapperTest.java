package com.dbsd6th.dao;

import com.dbsd6th.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserMapperTest {
    private UserMapper userMapper;
    private ApplicationContext applicationContext;

    @Before
    public void doBefore() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
        userMapper = applicationContext.getBean(UserMapper.class);
    }

    @After
    public void doAfter() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUserName("user");
        user.setUserPassword("imuser");
        user.setUserRole("ROLE_USER");

        userMapper.insert(user);
    }

    @Test
    public void selectByUserName() {
        String userName = "user";
        User user = userMapper.selectByUserName(userName);
        System.out.println(user);
    }
}