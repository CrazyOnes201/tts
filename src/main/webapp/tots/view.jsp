<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��ʾ������Ϣ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style1.css">


  </head>
  
  <body  background="images/003.jpg">
    <p align="center" class="style1">������Ϣ����</p>
	<hr>
	<p>&nbsp;</p>
    <p>&nbsp;</p>
	<form name="form1" method="post" action="main.jsp">
    <p>&nbsp;</p>
    <table width="443" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="94" height="38">
			<div align="center">
          		<p>��&nbsp;�� ��:</p>
          	</div>
		</td>
        <td width="400">
			<div align="center">
           		<input name="userName" type="text" id="yonghu" size="20" readonly="true" value="${user.userName}"/>
        	</div>
		</td>
      </tr>
      <tr>
        <td height="38"><div align="center">��ʵ����:</div></td>
        <td>
			<div align="center">
          		<input name="realName" type="text" id="xingbin" size="20" value="${user.realName}">
        	</div>
		</td>
      </tr>
      <tr>
        <td height="38"><div align="center">�� &nbsp;&nbsp;&nbsp;��:</div></td> 
        <td>
			<div align="center">
				<input name="gender" type="text" id="xinbie" size="20" value="${user.gender}">          
            </div>
		</td>
      </tr>
      <tr>
        <td height="38"><div align="center">�绰����:</div></td>
        <td>
			<div align="center">
          		<input name="tel" type="text" id="zhengjian" size="20" value="${user.tel}">
        	</div>
		</td>
      </tr>
      <tr>
        <td height="38"><div align="center">�����ʼ�:</div></td>
        <td>
			<div align="center">
          		<input name="email" type="text" id="Emil" size="20" value="${user.email}">
        	</div>
		</td>
      </tr>
    </table>
    <p align="center">
      <input type="submit" name="Submit" value="����">    
	</p>
 </form>
  </body>
</html>
