package com.dbsd6th.dao;

import com.dbsd6th.entity.OrderTicket;

public interface OrderTicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTicket record);

    int insertSelective(OrderTicket record);

    OrderTicket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderTicket record);

    int updateByPrimaryKey(OrderTicket record);
}