<%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/21
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册</title>
</head>
<body>
<div>
    <form method="post" action="ManagerRegist">
        <label>账号：</label><input type="text" name="mid"><br>
        <br>
        <label>密码：</label><input type="password" name="pwd"><br>
        <br>
        <label>姓名：</label><input type="text" name="mname"><br>
        <br>
        <input type="submit" value="注册">
    </form>
</div>
</body>
</html>
