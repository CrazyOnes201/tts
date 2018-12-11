package com.dbsd6th.dao;

import com.dbsd6th.entity.TrainType;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainType record);

    int insertSelective(TrainType record);

    TrainType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainType record);

    int updateByPrimaryKey(TrainType record);
}