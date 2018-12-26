<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/tots/css/register-style.css">
	
<title>register</title>
  </head>
  
  <body>
    <div class="register-container">
	<h1>HDU火车订票系统</h1>
	
	<div class="connect">
		<h2>旅客注册</h2>
	</div>

	<form action="/register" method="post" id="registerForm">
		<div>
			<input type="text" name="userName" class="realname" placeholder="输入真实姓名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		<%--</div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>--%>
		<div>
			<%--<input type="text" name="realname" class="" placeholder="" autocomplete="off" />--%>
		</div>
		<div>
			<input type="text" name="identityNum" class="idnumber" placeholder="输入二代身份证号" autocomplete="off" />
		</div>
		<div>
			<input type="text" name="phone" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number"/>
		</div>
		<div>
			<input type="email" name="email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false" />
		</div>

		<button id="submit" type="submit">注 册</button>
	</form>
	<a href="login.jsp" type="submit" class="register-tis" >登陆</a>

</div>
  </body>
</html>
