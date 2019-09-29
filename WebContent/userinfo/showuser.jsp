<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户信息</title>
</head>
<body>
	<div>
	<h3>用户信息</h3>
	<div>用 户 Id: ${requestScope.userInfo.userId }</div>
	<div>用  户  名: ${requestScope.userInfo.userName }</div>
	<div>密        码: ${requestScope.userInfo.userPass }</div>
	<div>手机号码: ${requestScope.userInfo.mobilePhone }</div>
   
	</div>
</body>
</html>