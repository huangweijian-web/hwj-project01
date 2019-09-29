<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="${pageContext.request.contextPath }/css/userlogin.css" rel="stylesheet">
</head>
<body>
<div id="up"></div>
<div id="centre">
  <div id="userlogin">
   <div id="loginup" >密码登录</div>
	<form action="${pageContext.request.contextPath}/userInfoService" method="post">
	  	<input type="hidden" name="op" value="login">
		<table class="userl">
		  <tr>
		  	<td><input type="text" name="userName" placeholder="请输入账号" ></td>
		  </tr>
		  <tr>
		  	<td><input type="password" name="userPass" placeholder="请输入密码" ></td>
		  </tr>
		  <tr>
		  	<td colspan="1" >
		  	  <button id="loginb" type="submit">登录</button>
		  	</td>
		  </tr>
		</table>
	  </form>
	 <div id="logindown" ></div>
	</div>
</div>	
<div id="down"></div>
</body>
</html>