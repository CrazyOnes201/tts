package com.dbsd6th.dao;

import com.dbsd6th.entity.Train;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Train record);

    int insertSelective(Train record);

    Train selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);

}