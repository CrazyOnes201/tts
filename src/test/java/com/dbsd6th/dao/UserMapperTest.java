package com.dbsd6th.dao;

import com.dbsd6th.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author hjs
 * @date 2018/11/23 13:55
 */
public class UserMapperTest {

    private ApplicationContext applicationContext;
    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //加载spring配置文件

        userMapper = applicationContext.getBean(UserMapper.class);
        //在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUserName("ceshi");
        int result = userMapper.insertSelective(user);
        System.out.println(result);
        assert (result == 1);

    }

    @Test
    public void selectByPrimaryKey(){
        User user = this.userMapper.selectByPrimaryKey(1);
        System.out.println(user);

    }

    @Test
    public void selectByEmailOrPhone() {
        User user = new User();
        user.setPhone("18100172238");

        User selectUser = userMapper.selectByEmailOrPhone(user);
        System.out.println(selectUser);
    }
}