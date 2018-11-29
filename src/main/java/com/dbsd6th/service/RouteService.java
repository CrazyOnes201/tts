package com.dbsd6th.service;

import com.dbsd6th.dao.RouteMapper;
import com.dbsd6th.entity.Route;

import java.util.Date;
import java.util.List;

/**
 * @author hjs
 * @date 2018/11/28 10:20
 */
public interface RouteService {
    public List<List<Route>> findTransferStation(String chufazhan, String mudizhan, Date chufashijian);
}
