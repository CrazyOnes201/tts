package com.dbsd6th.dao;

import com.dbsd6th.entity.Route;
import com.dbsd6th.entity.TrainInfo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RouteMapper {

    public int deleteByPrimaryKey(Integer id);

    public int insert(Route record);

    public int insertSelective(Route record);

    public Route selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Route record);

    public int updateByPrimaryKey(Route record);

    /*基本查询
     * 根据出发站、目的站和出发时间查询车次信息*/
    public List<TrainInfo> selectByStation(String chufazhan, String mudizhan,Date chufashijian);

    /*高级查询1
     * 根据出发站、目的站和出发时间查询最短路径的车次信息*/
    public List<TrainInfo> selectShortestPath(String chufanzhan,String mudizhan,Date chufashijian);

    /*高级查询2
     * 根据出发站、目的站和出发时间查询最便宜路径的车次信息*/
    public List<TrainInfo> selectCheapestPath(String chufazhan,String mudizhan,Date chufashijian);

    /*高级查询3
     * 根据出发站、目的站和出发时间查询最少时间的车次信息*/
    public List<TrainInfo> selectLeastTime(String chufazhan,String mudizhan,Date chufashijian);

    /*高级查询4：
      如果没有出发站和目的站的直达路线，使用中转站查询功能(具体实现在service层,只中转一次)
      子操作1 */
    public List<Route> selectTransferStation(String chufazhan,String mudizhan,Date chufashijian);

    /*高级查询4：
      子操作2 */
    public List<Route> selectTransferStation2(int trainId1,int trainId2,int routeSeq1,int routeSeq2);

    /*高级查询4：
      子操作3 */
    public Route selectTransferStation3(int trainId,String station);

    /*管理员在前台根据列车号train_num*/
    public int deleteByPrimaryKey();

}