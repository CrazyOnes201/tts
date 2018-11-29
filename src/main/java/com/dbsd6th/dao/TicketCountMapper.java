package com.dbsd6th.dao;

import com.dbsd6th.entity.TicketCount;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCountMapper {
    public int deleteByPrimaryKey(Integer id);

    public int insert(TicketCount record);

    public int insertSelective(TicketCount record);

    public TicketCount selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(TicketCount record);

    public int updateByPrimaryKey(TicketCount record);
}