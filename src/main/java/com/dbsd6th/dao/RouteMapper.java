package com.dbsd6th.dao;

import com.dbsd6th.entity.Route;
import com.dbsd6th.entity.TrainInfo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RouteMapper {
    public int deleteByPrimaryKey(Integer id);

    public int insert(Route record);

    public int insertSelective(Route record);

    public Route selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Route record);

    public int updateByPrimaryKey(Route record);

    public List<TrainInfo> selectByStation(String chufazhan, String mudizhan);
}