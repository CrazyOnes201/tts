package com.dbsd6th.service.impl;

import com.dbsd6th.dao.SeatTypeMapper;
import com.dbsd6th.entity.SeatType;
import com.dbsd6th.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期四, 12/20 2018 16:49 UTC  **
 * *****************************************
 * *****************************************
 * **    用途: 座位类型表业务层实现类     **
 * *****************************************
 */
@Service
public class SeatTypeServiceImpl implements SeatTypeService {

    @Autowired
    private SeatTypeMapper seatTypeMapper;

    public List<SeatType> getAllSeatType() {
        return seatTypeMapper.selectAllSeatType();
    }
}
