<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admineService" method="post">
		<input type="hidden" name="op" value="addcom">
		<table>
			<tr>
				<td>商品名：</td>
				<td><input type="text" name="comName"/></td>
			</tr>
			<tr>
				<td>商品类型：</td>
				<td><input type="text" name="comType"/></td>
			</tr>
			<tr>
				<td>产地：</td>
				<td><input type="text" name="origin"/></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="price"/></td>
			</tr>
			<tr>
	  			<td colspan="2">
	  	  		<input type="submit" value="新增">
	  	  		<input type="reset" value="重置"> 
	  		</td>
		</table>
	</form>
</body>
</html>