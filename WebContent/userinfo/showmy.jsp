<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查看个人信息</title>
</head>
<body>
<div>
	<h3>用户信息：</h3>
	<div>用户名:${sessionScope.userInfo.userName }</div>
	<div>密    码:${sessionScope.userInfo.userPass }</div>
	<div>手机号:${sessionScope.userInfo.mobilePhone }</div>
	
	
	<br>
	<a href="${pageContext.request.contextPath }/userinfo/update.jsp">修改个人信息</a>
</div>
</body>
</html>