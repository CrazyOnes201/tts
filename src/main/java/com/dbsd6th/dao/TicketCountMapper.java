package com.dbsd6th.dao;

import com.dbsd6th.entity.TicketCount;

public interface TicketCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketCount record);

    int insertSelective(TicketCount record);

    TicketCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketCount record);

    int updateByPrimaryKey(TicketCount record);
}