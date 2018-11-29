package com.dbsd6th.service.impl;

import com.dbsd6th.dao.RouteMapper;
import com.dbsd6th.entity.Route;
import com.dbsd6th.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hjs
 * @date 2018/11/28 10:26
 */
@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteMapper routeMapper;

    /*高级查询4：中转站查询算法的具体实现(只中转一次)*/
    public List<List<Route>> findTransferStation(String chufazhan, String mudizhan, Date chufashijian) {
        List<Route> cfzRouteList = (List<Route>)this.routeMapper.selectTransferStation(chufazhan , mudizhan , chufashijian);//出发站的route表
        List<Route> mdzRouteList = (List<Route>)this.routeMapper.selectTransferStation(mudizhan , chufazhan , chufashijian);//目的站的route表
        int length1 = cfzRouteList.size();//出发站表长度
        int length2 = mdzRouteList.size();//目的站表长度
        List<Route> cfzRouteResult = new ArrayList<Route>();//出发站到中转站的路线信息
        List<Route> mdzRouteResult = new ArrayList<Route>();//中转站到目的站的路线信息
        for (int i = 0; i < length1; i++) {
            Route cfzRouteListElem = cfzRouteList.get(i);
            for (int j = 0; j < length2; j++) {
                Route mdzRouteListElem = mdzRouteList.get(j);
                List<Route> cfzTransferList = (List<Route>)this.routeMapper.selectTransferStation2(cfzRouteListElem.getTrainId(),
                        mdzRouteListElem.getTrainId(),cfzRouteListElem.getRouteSeq(),mdzRouteListElem.getRouteSeq());
                if(cfzTransferList.size() > 0){
                    Route cfzTransferListElem = cfzTransferList.get(0);//得到“出发站-中转站”的中转站信息
                    Route mdzTransferListElem = this.routeMapper.selectTransferStation3(mdzRouteListElem.getTrainId(),
                            cfzTransferListElem.getStationName());//得到“中转站-目的站”的中转站信息
                    cfzRouteResult.add(cfzRouteListElem);
                    cfzRouteResult.add(cfzTransferListElem);
                    mdzRouteResult.add(mdzTransferListElem);
                    mdzRouteResult.add(mdzRouteListElem);
                }
            }
        }
        List<List<Route>> result = new ArrayList<List<Route>>();
        result.add(cfzRouteResult);
        result.add(mdzRouteResult);
        return result;
    }
}
