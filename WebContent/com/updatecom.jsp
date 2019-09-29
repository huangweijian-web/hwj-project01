<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
</head>
<body>
	<c:set value="${requestScope.co }" var="co"/>
	<form action="${pageContext.request.contextPath }/admineService" method="post">
		<input type="hidden" name="op" value="updatecom">
		<input type="hidden" name="comId" value="${co.comId }">
		<table>
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="comName" value="${co.comName }"></td>
			</tr>
			<tr>
				<td>商品类型：</td>
				<td><input type="text" name="comType" value="${co.comType }"></td>
			</tr>
			<tr>
				<td>商品产地：</td>
				<td><input type="text" name="origin" value="${co.origin }"></td>
			</tr>
			<tr>
				<td>商品价格：</td>
				<td><input type="text" name="price" value="${co.price }"></td>
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