<%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/21
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<div>
    <form method="post" action="ManagerLogin">
        <label>账号：</label><input type="text" name="mid"><br>
        <br>
        <label>密码：</label><input type="password" name="pwd"><br>
        <br>
        <input type="submit" value="登录">
        <a href="ManagerRegist.jsp" type="button" style="text-decoration: none">
            <input type="button" value="注册">
        </a>
    </form>
</div>
</body>
</html>
