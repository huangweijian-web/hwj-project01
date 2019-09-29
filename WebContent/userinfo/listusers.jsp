<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table border="1" cellspacing="0">
		<tr>
			<th>用户Id</th>
			<th>用户名</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.userInfoList }" var="u">
		<tr>
			<td>${u.userId }</td>
			<td>${u.userName }</td>
			<td>
			<a href="${pageContext.request.contextPath }/admineService?op=showuser&userId=${u.userId}">查看</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
		 <a href="${pageContext.request.contextPath }/admine/adminemain.jsp">返回主页</a>
		</tr>
	</table>
</body>
</html>