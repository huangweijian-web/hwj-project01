<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
	<table border="1" cellspacing="0">
		<tr>
			<th>商品Id</th>
			<th>商品名</th>
			<th>商品类型</th>
			<th>产地</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.comList }" var="com">
		<tr>
			<td>${com.comId }</td>
			<td>${com.comName }</td>
			<td>${com.comType }</td>
			<td>${com.origin }</td>
			<td>${com.price }</td>
			<td>
			    <a href="${pageContext.request.contextPath }/admineService?op=showcom&comId=${com.comId }">修改</a>
				<a href="${pageContext.request.contextPath }/admineService?op=deletecom&comId=${com.comId }">删除</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
       	    <td colspan="6">
       	   		<c:forEach begin="1" end="${requestScope.totalPages }" step="1" var="i">
       	   			<a href="${pageContext.request.contextPath }/admineService?op=getComPage&page=${i}">${i }</a>
       	   		</c:forEach>
      	</tr>
      	<tr>
      		<a href="${pageContext.request.contextPath }/admine/adminemain.jsp">返回主页</a>
      	</tr>
	</table>
	<a href="${pageContext.request.contextPath }/com/addcom.jsp">新增商品</a>
	
</body>
</html>