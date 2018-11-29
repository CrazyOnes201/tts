package com.dbsd6th.service;

import com.dbsd6th.entity.Route;
import com.dbsd6th.entity.Train;
import com.dbsd6th.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author hjs
 * @date 2018/11/23 13:09
 */
public interface UserService {
    public Boolean userRegist(User user);

    public int userLogin(Integer userid,String password);

    public User selectUser(Integer userid);

    public User deleteUser(Integer userid);



}
