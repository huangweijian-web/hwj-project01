
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员</title>
</head>
<body>
	
	<c:set var="admine" value="${sessionScope.admine }"/>
	<c:choose>
	<c:when test="${admine ==null }">
		<a href="${pageContext.request.contextPath }/admine/adminelogin.jsp">登陆</a>

	</c:when>
	<c:otherwise>
	
	您好，欢迎登陆！！！${sessionScope.admine.admineName }<br>
	<a href="${pageContext.request.contextPath }/admineService?op=listuser">查看用户列表</a>
	<a href="${pageContext.request.contextPath }/admineService?op=getComPage">查看商品列表</a>
	<a href="${pageContext.request.contextPath }/com/addcom.jsp">新增商品</a>
	</c:otherwise>
	
	</c:choose>
	

   	
   	</body>
</html>