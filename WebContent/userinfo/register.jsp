<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/userInfoService" method="post">
       <input type="hidden" name="op" value="register">
       <table>
           <tr>
              <td>用户名：</td>
              <td><input type="text" name="userName"></td>
           </tr>
           <tr>
              <td>密码：</td>
              <td><input type="password" name="userPass"></td>
           </tr>        
           <tr>
              <td colspan="2">
                  <input type="submit" value="注册">
                  <input type="reset" value="重置">
              </td>
           </tr>
       </table>
    </form>
</body>
</html>