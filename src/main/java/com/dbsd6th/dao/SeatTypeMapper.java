package com.dbsd6th.dao;

import com.dbsd6th.entity.SeatType;

import java.math.BigDecimal;

public interface SeatTypeMapper {
    int deleteByPrimaryKey(String seattype);

    int insert(SeatType record);

    int insertSelective(SeatType record);

    SeatType selectByPrimaryKey(String seattype);

    int updateByPrimaryKeySelective(SeatType record);

    int updateByPrimaryKey(SeatType record);

    BigDecimal getPercostBySeatType(String seattype);


}