package com.dbsd6th.service.impl;

import com.dbsd6th.dao.UserMapper;
import com.dbsd6th.entity.Route;
import com.dbsd6th.entity.User;
import com.dbsd6th.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author hjs
 * @date 2018/11/23 13:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Boolean userRegist(User user) {
        if(this.userMapper.insertSelective(user)==1) {
            System.out.println("成功进行了注册操作");
            return true;
        }
        else {
            System.out.println("没有成功进行注册操作");
            return false;
        }
    }


    public int userLogin(Integer userid, String password) {
        User existUser = this.userMapper.selectByPrimaryKey(userid);
        if (existUser == null) {
            System.out.println("数据库里没有对应的信息");
            return 0;
        } else if (existUser.getPassword().equals(password)){

            System.out.println("成功进行了登录操作");
            return 1;
        } else {
            System.out.println("没有成功进行登录操作");
            System.out.println("前台传入的密码是"+password);
            System.out.println("相同id号对应的密码是"+existUser.getPassword());
            return -1;
        }
    }


    public User selectUser(Integer id) {

        return this.userMapper.selectByPrimaryKey(id);
    }


    public User deleteUser(Integer id) {
        return null;
    }



}
