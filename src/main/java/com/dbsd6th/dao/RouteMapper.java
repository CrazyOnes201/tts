package com.dbsd6th.dao;

import com.dbsd6th.entity.Route;

public interface RouteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Route record);

    int insertSelective(Route record);

    Route selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);
}