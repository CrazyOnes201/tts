package com.dbsd6th.dao;

import com.dbsd6th.entity.TicketCount;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface TicketCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketCount record);

    int insertSelective(TicketCount record);

    TicketCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketCount record);

    int updateByPrimaryKey(TicketCount record);

    TicketCount searchTicket(HashMap<String, Object> condition);
}