<%--
  Created by IntelliJ IDEA.
  User: Crazy Ones
  Date: 2018/1/6
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
    <script type="text/javascript" src="g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css"></script>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="jqueryui/style.css">
    <script>
        $(function() {
            $( "#datepicker" ).datepicker();
        });
    </script>
    <title>Insert title here</title>
</head>
<body>
<div class="Navigation">
    <div class="left_logo">
        <img src="images/logo.png" alt="logo" align="left"/>
        <p class="project_name">
            火车订票系统</p>
    </div>
    <div id="navfirst">
        <ul id="menu">
            <li id="s3"><a href="searchTicket.jsp" title="车票查询">车票查询</a></li>
            <li id="s1"><a href="userinfo.jsp" title="个人中心">个人中心</a></li>
            <li id="s2"><a href="login.jsp" title="记账">退出登陆</a></li>
        </ul>
    </div>
</div>
<h2 style="text-align:center;">高级查询</h2>
<div class="search">

    <form id="form-msg" class="sui-form form-horizontal"  method="post" action="/ticketSearch">
        <div id="navfirst">
            <ul id="menu">
                <li > <div class="control-group">
                    <label for="startpoint" class="control-label">起点：</label>
                    <div class="controls">
                        <input type="text" id="startpoint"  name="beginStation" class="input-middle"
                               value="${sessionScope.adtatList[0].trainInfo.chufazhan}"/>
                    </div></div></li>
                <li ><div class="control-group">
                    <label for="finishpoint" class="control-label">终点：</label>
                    <div class="controls">
                        <input type="text" id="finishpoint"  name="targetStation" class="input-middle"
                               value="${sessionScope.adtatList[1].trainInfo.mudizhan}" />
                    </div></div></li>
                <li ><div class="control-group">
                    <label for="time" class="control-label">出发日期：</label>
                    <div class="controls">
                        <input type="text" name="targetDate" id="datepicker" />
                    </div></div></li>
               <%-- <li ><div class="control-group">
                    排序方式：
                    <div class="controls">
                        <select name="advancedFlag">
                            <option value ="0">最省钱出行</option>
                            <option value ="1">最节约时间出行</option>
                            <option value="2">最短路程出行</option>
                        </select>
                    </div></div></li>--%>
                <li ><div class="control-group">
                    <label for="time" class="control-label"></label>
                    <div class="controls">
                        <input type="hidden" name="flag" value="1" />
                        <input type="submit"  class="input-small" value="车次查询" />
                    </div></div></li></ul>
        </div>
    </form>
</div>
<div class="contain">
    <div class="traintable">
        <table class="sui-table table-primary">
            <thead>
            <tr>
                <th>车次</th>
                <th>起点</th>
                <th>终点</th>
                <th>出发时间</th>
                <th>到达时间</th>
                <th>特等座/商务座</th>
                <th>一等座</th>
                <th>二等座</th>
                <th>高级软卧</th>
                <th>软卧</th>
                <th>动卧</th>
                <th>硬卧</th>
                <th>软座</th>
                <th>硬座</th>
                <th>无座</th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${! empty sessionScope.isAdPostResponse}">
            <c:choose>
                <c:when test="${empty sessionScope.adtatList}">
                    <td colspan="16" style="text-align:center;font-weight:bold;">
                       没有对应车次
                    </td>
                </c:when>
                <%--<c:when test="${empty requestScope.adtatList[0].ticketList}">--%>
                    <%--<td colspan="6" style="text-align:center;font-weight:bold;">--%>
                        <%--查询日期车票不能购买--%>
                    <%--</td>--%>
                <%--</c:when>--%>
                <c:when test="${! empty sessionScope.adtatList}">
                    <c:forEach items="${sessionScope.adtatList}" var="elemTrain" varStatus="status">
                        <tr>
                            <td>${elemTrain.trainInfo.trainNum}</td>
                            <td>${elemTrain.trainInfo.chufazhan}</td>
                            <td>${elemTrain.trainInfo.mudizhan}</td>
                            <td>${elemTrain.trainInfo.departureTime}</td>
                            <td>${elemTrain.trainInfo.arriveTime}</td>
                            <td>${elemTrain.ticketCount.businessRemain}</td>
                            <td>${elemTrain.ticketCount.firstRemain}</td>
                            <td>${elemTrain.ticketCount.secondRemain}</td>
                            <td>${elemTrain.ticketCount.advancedSoftRemain}</td>
                            <td>${elemTrain.ticketCount.softSleeperRemain}</td>
                            <td>${elemTrain.ticketCount.highspeedSleeperRemain}</td>
                            <td>${elemTrain.ticketCount.hardSleeperRemain}</td>
                            <td>${elemTrain.ticketCount.softRemain}</td>
                            <td>${elemTrain.ticketCount.hardRemain}</td>
                            <td>${elemTrain.ticketCount.standRemain}</td>
                            <td><button><a href="/adPreBuy/${status.index}">预定</a></button></td>

                        </tr>
                        <c:if test="${status.count%2==0}">
                            <tr>
                                <td colspan="16"></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:when>
            </c:choose>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
<script type="text/javascript">
    $('#demo1 input').datepicker({size:"small"});
</script>
<style type="text/css">
    * { padding:0; margin:0;}

    .Navigation{
        width: 100%;
        height: 80px;
        background-color:#4b6cd8;
        overflow:hidden;
    }
    img{
        width:100px;
        height:80px;
    }

    p.project_name{
        font-style: normal;
        font-size: 30px;
        color: #ffffff;
        float: left;
        margin-top:30px;
    }

    #menu {
        font:50px verdana, arial, sans-serif; /* 设置文字大小和字体样式 */
        margin-left:400px;
    }

    #menu, #menu li {
        list-style:none; /* 将默认的列表符号去掉 */
    }

    #menu li {
        float:left;
    }

    #menu li a {
        display:block;
        padding:8px 30px;
        color:#ffffff;
        text-decoration:none;
        margin-top: 0px;
        font-size: 30px;
    }
    .search{
        margin:20px 10%;
        width:80%;
        text-align:center;
        background-color:#cde8f1;
        height:60px;

    }
    body{
        margin:0;
        padding:0;
    }
    #navfirst{

    }
    #menu {
        font:15px verdana, arial, sans-serif; /* 设置文字大小和字体样式 */

    }
    #menu, #menu li {
        list-style:none; /* 将默认的列表符号去掉 */
        margin-top:20px;
    }

    #menu li {
        float:left;
    }
    .contain{
        margin:20px 10%;
        width:80%;
        text-align:center;
        background-color:#cde8f1;
        height:600px;
    }
    .traintable{
        width:80%;
        margin:40px 10%;
        text-align:center;
        background-color:#fff;

    }
</style>
</html>