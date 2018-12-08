package com.dbsd6th.dao;

import com.dbsd6th.entity.OrderTicket;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


@Repository
public interface OrderTicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTicket record);

    int insertSelective(OrderTicket record);

    OrderTicket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderTicket record);

    int updateByPrimaryKey(OrderTicket record);

    /*用户查询所有历史订单*/
    ArrayList<OrderTicket> searchHistoryRecord(Integer userid);

    /*查询历史订票中effect为1的项目*/
    ArrayList<OrderTicket> searchNeedRefundRecord(Integer userid);

    /*修改订票表记录的有效性*/
    int updateTicketEffect(Integer id);




}