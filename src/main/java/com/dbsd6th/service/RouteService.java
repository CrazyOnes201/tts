package com.dbsd6th.service;

import com.dbsd6th.dao.RouteMapper;
import com.dbsd6th.entity.Route;
import com.dbsd6th.entity.TrainAndTicket;

import javax.naming.ldap.HasControls;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author hjs
 * @date 2018/11/28 10:20
 */
public interface RouteService {
    List<List<Route>> findTransferStation(String chufazhan, String mudizhan);

    Integer getDistance(TrainAndTicket trainAndTicket);
}
