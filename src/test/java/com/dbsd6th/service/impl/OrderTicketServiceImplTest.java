package com.dbsd6th.service.impl;

import com.dbsd6th.dao.UserMapper;
import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @author hjs
 * @date 2018/12/4 22:00
 */
public class OrderTicketServiceImplTest {
    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderTicketServiceImpl orderTicketServiceImpl;

    @Autowired
    private SearchTicketServiceImpl searchTicketServiceImpl;



    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        userMapper = applicationContext.getBean(UserMapper.class);
        orderTicketServiceImpl = applicationContext.getBean(OrderTicketServiceImpl.class);
        searchTicketServiceImpl = applicationContext.getBean(SearchTicketServiceImpl.class);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    /*实现整个购票流程模拟测试：
     (1)用户在前端输入出发站、目的站、出发时间，并选中直达路线查询，点击查询后进行车次信息和余票信息查询
     (2)用户获得所有满足条件的 车次+余票信息 的组合列表,并在前端进行显示  (后端测试在控制台打印输出)
     (3)用户在列表中进行筛选，选中其中某条trainAndTicket,然后输入座位等级，进行购票并自动生成订单
     (4)订票成功
     */
    public void buyTrainTicket() {
        try {
            User user = this.userMapper.selectByPrimaryKey(1); //假设当前session里存放的是 id=1 的用户
            if (user == null) {
                System.out.println("user is null！");
            } else {
                String chufazhan = "广州"; //用户输入出发站
                String mudizhan = "南京"; //用户输入目的站
                SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
                Date chufashijian = adf.parse("2019-01-15"); //用户输入出发时间
                int flag = 0; //用户选择直达路线查询模式
                List<TrainAndTicket> lists = this.searchTicketServiceImpl.getTrainAndTicketList(chufazhan, mudizhan, chufashijian, flag);
                //用户点击查询
                //用户获得所有满足条件的 车次+余票信息 的列表结果
                for (int i = 0; i < lists.size(); i++) {
                    System.out.println(lists.get(i));
                }

                // 用户选中某条trainAndTicket，并进行购票操作，并自动生成订单。若购票操作成功且订单生成成功，
                // 控制台会打印输出成功。否则，只要其中购票和订票生成两个操作只要有一个操作失败，都会输出失败

                TrainAndTicket trainAndTicket = lists.get(0);//用户选择第一条信息
                String level = "first_remain"; //用户选择X等座
                Boolean result = this.orderTicketServiceImpl.buyTrainTicket(level, trainAndTicket, user);//用户购票并生成订单
                if (result == true) {
                    System.out.println("成功！");
                } else {
                    System.out.println("失败！");
                }
            }
        } catch(ParseException e){
                e.printStackTrace();
        }
    }

    @Test
    /**实现整个查询所有历史订单的流程模拟测试
     * 当前用户点击“查询所有历史订单”的按钮时，将会得到所有历史订单记录（包括订票和退票）
     */
    public void searchHistoryRecord(){
        try{
            User user = this.userMapper.selectByPrimaryKey(1);
            if (user == null){
                System.out.println("user is null");
            }else{
                ArrayList<HashMap<String,Object>> result = this.orderTicketServiceImpl.searchHistoryRecord(user);
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    /**实现整个查询所有已订票订单的流程模拟测试
     * 当前用户点击“查询订票记录”时，将会得到所有成功订票记录（包括过期和未过期）
     */
    public void searchNeedRefundRecord(){
        try{
            User user = this.userMapper.selectByPrimaryKey(1);
            if (user == null){
                System.out.println("user is null");
            }else{
                ArrayList<HashMap<String,Object>> result = this.orderTicketServiceImpl.searchNeedRefundRecord(user);
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    /**实现整个退票流程的模拟测试
     * （1）当前用户(id=1)点击“查询订票记录”时，将会得到所有成功订票记录（包括过期和未过期）
     * （2）用户选择其中一条订票记录进行退票操作
     * （3）用户再次点击“查询订票记录”，检查成功订票记录
     * （4）用户点击“查询所有历史订单”，检查所有历史订单记录
     */
    public void refundTrainTicket(){
        /*try{
            User user = this.userMapper.selectByPrimaryKey(1);
            if (user == null){
                System.out.println("user is null");
            }else{
                ArrayList<HashMap<String,Object>> result = this.orderTicketServiceImpl.searchNeedRefundRecord(user);
                if(result==null){
                    System.out.println("没有订票记录");
                }
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i));
                }
                Boolean flag = this.orderTicketServiceImpl.refundTrainTicket();//删除第一条记录
                if (flag==true){
                    System.out.println("退票成功！");
                }else{
                    System.out.println("退票失败！");
                }

                ArrayList<HashMap<String,Object>> result2 = this.orderTicketServiceImpl.searchHistoryRecord(user);
                for (int i = 0; i < result2.size(); i++) {
                    System.out.println(result2.get(i));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
}