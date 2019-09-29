<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改个人信息</title>
</head>
<body>
	<c:set value="${sessionScope.userInfo }" var="u"/>
	<form action="${pageContext.request.contextPath }/userInfoService" method="post">
		<input type="hidden" name="op" value="update">
		<input type="hidden" name="userId" value="${u.userId }">
		<table>
		  <tr>
		  	<td>用户名:</td>
		  	<td><input type="text" name="userName" value="${u.userName }" ></td>
		  </tr>
		  <tr>
		  	<td>密码:</td>
		  	<td><input type="password" name="userPass" value="${u.userPass }"></td>
		  </tr>
		  <tr>
		  	<td>手机号:</td>
		  	<td><input type="text" name="mobilePhone" value="${u.mobilePhone }"></td>
		  </tr>
		  <tr>
		  	<td colspan="2">
		  	  <input type="submit" value="修改">
		  	  <input type="reset" value="重置"> 
		  	</td>
		  </tr>
		</table>
	</form>
</body>
</html>