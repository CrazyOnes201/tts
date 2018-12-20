<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<link href="/tots/css/login-style.css" rel="stylesheet" type="text/css" />
<title>Login</title>
</head>
<body>
<div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;"><img src="/tots/images/1.jpg" width="100%" height="100%"/></div>
<div class="main">
  <div class="denglu">
    <div class="dlk">
      <s:form action="/login" method="post">
      <table width="292" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="76" colspan="3"style="font-size:24px;text-align:center;color:black ">用户登陆</td>
        </tr>
        <c:if test="${result eq 0}">
        <tr>
          <td colspan="3">
            <h3 style="color: #96180e;">用户名或密码错误，请重新输入</h3>
          </td>
        </tr>
        </c:if>
        <tr>
          <td width="65" style="font-size:18px">用户名</td>
          <td colspan="2"><input name="loginname" type="text" class="dlinput" placeholder="用户/管理员" /></td>
        </tr>
        <tr>
          <td height="16" colspan="3"></td>
        </tr>
        <tr>
          <td style="font-size:18px">密码</td>
          <td colspan="2"><input name="password" type="password" class="dlinput" /></td>
        </tr>
        <tr>
          <td height="16" colspan="3"></td>
        </tr>
        
        <tr>
          <td height="16" colspan="3"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td colspan="2"><input type="submit" value="登 录" class="loginbtn" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td colspan="2"><table width="224" border="0" cellspacing="0" cellpadding="0">
            <tr>
			</br>
              <td height="24"><a href="#none" class="mm" style="color: blue">忘记登录密码？</a></td>
              <td align="right"><a href="/tots/register.jsp" class="zc" style="font-size:13px; color:blue" >立即网上注册</a></td>
            </tr>
            <br>
          </table></s:form></td>
        </tr>
      </table>
    </div>
  </div>
</div>
</body>
</html>