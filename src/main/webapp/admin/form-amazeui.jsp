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
<body >

<div class="Navigation">
    <div class="left_logo">
        <img src="/tots/images/logo.png" alt="logo" align="left"/>
        <p class="project_name">
            火车订票系统</p>
    </div>
    <div id="navfirst">
        <ul id="menu">
            <li id="s3"><a href="/admin/form-amazeui.jsp" title="管理个人信息" style="color: red">管理个人信息</a></li>
            <li id="s1"><a href="/admin/form-line.jsp" title="车次管理">车次管理</a></li>
            <li id="s2"><a href="/admin/form-line1.jsp" title="车站管理">车站管理</a></li>
            <li id="s4"><a href="/refreshticket" title="刷新车票">车票刷新</a></li>
        </ul>
    </div>
</div>
<div class="contain">
    <div class="traintable">
        <form class="sui-form form-horizontal sui-validate" action="/operateUser" method="post">
            <div class="control-group">
                <label class="control-label" for="user-name">用户名：</label>
                <div class="controls">
                    <input  id="user-name" type="text" placeholder="请输入用户名" name="userName">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword">密码：</label>
                <div class="controls">
                    <input title="密码" id="inputPassword" type="password" placeholder="请输入密码"  name="password">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="identitynum">身份证号：</label>
                <div class="controls">
                    <input id="identitynum" type="text" placeholder="请输入身份证号" name="identityNum">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="user-phone">手机号：</label>
                <div class="controls">
                    <input id="user-phone" type="text" placeholder="请输入手机号" name="phone">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="user-email">邮箱：</label>
                <div class="controls">
                    <input id="user-email" type="text" placeholder="请输入邮箱" name="email">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputGender">类型：</label>
                <div class="controls"><span class="sui-dropdown dropdown-bordered select"><span class="dropdown-inner"><a class="dropdown-toggle" role="button" href="#" data-toggle="dropdown">
            <input type="hidden" data-rules="required" name="operationType"><i class="caret"></i><span>请选择</span></a>
          <ul class="sui-dropdown-menu" id="menu4" role="menu" aria-labelledby="drop4">
            <li role="presentation"><a tabindex="-1" role="menuitem" href="javascript:void(0);" value="a">增加</a></li>
            <li role="presentation"><a tabindex="-1" role="menuitem" href="javascript:void(0);" value="b">修改</a></li>
              <li role="presentation"><a tabindex="-1" role="menuitem" href="javascript:void(0);" value="c">删除</a></li>
          </ul></span></span></div>
            </div>
            <div class="control-group">
                <label class="control-label"></label>
                <div class="controls">
                    <button class="sui-btn btn-primary" type="submit">提交</button>
                </div>
            </div>
        </form>
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
        background-color:#eef1f8;
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
        background-color:#eef1f8;
        height:600px;
    }
    .traintable{

        width:80%;
        margin-left: 600px;
        margin-top: 100px;

    }

</style>
</html>
