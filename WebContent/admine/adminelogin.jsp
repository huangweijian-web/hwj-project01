<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admineService" method="post">
		<input type="hidden" name="op" value="adminelogin">
		<table>
			<tr>
				<td>账号:</td>
				<td><input type="text" name="admineName"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="adminePass"></td>
			</tr>
			<tr>
	  			<td colspan="2">
	  	  		<input type="submit" value="登录">
	  	  		<input type="reset" value="重置"> 
	  		</td>
	  		</tr>
		</table>
	</form>	
</body>
</html>