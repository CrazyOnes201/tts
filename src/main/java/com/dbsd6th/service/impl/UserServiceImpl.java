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


    public User userLogin(User user) {
        return userMapper.selectByEmailOrPhone(user);
    }


    public User selectUser(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }


    public User deleteUser(Integer id) {
        return null;
    }

    public void updateUserByIdentityNum(User user) {
        userMapper.updateByIdentityNumSelective(user);
    }

    public void deleteUserByIdentityNum(String identityNum) {
        userMapper.deleteUserByIdentityNum(identityNum);
    }
}
