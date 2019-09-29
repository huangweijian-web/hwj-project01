<%@page import="org.web.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>

<link href="${pageContext.request.contextPath }/css/usermain.css" rel="styleshet">

</head>
<body >

	<div id="usermain">
		<c:set var="userInfo" value="${sessionScope.userInfo }"/>
		<c:choose>
		<c:when test="${userInfo == null }" >
			
			<a href="${pageContext.request.contextPath }/userinfo/login.jsp">登录</a>
			
			
			<a href="${pageContext.request.contextPath }/userinfo/register.jsp">注册</a>
			
			
		</c:when>
		<c:otherwise>
		您好！${sessionScope.userInfo.userName }<br>
		<a href="${pageContext.request.contextPath }/userinfo/showmy.jsp">查看个人信息</a><br>
		<a href="${pageContext.request.contextPath }/userInfoService?op=browescom">查看商品列表</a>
		</c:otherwise>
		</c:choose>
	</div>



	



</body>
</html>