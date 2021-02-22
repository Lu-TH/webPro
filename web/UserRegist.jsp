<%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/18
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%
        String errorUid = (String) request.getAttribute("errorUid");
        if (errorUid == null) {
            errorUid = "";
        }
    %>
    <style>
        .errorMessage{
            color: red;
        }
    </style>
</head>
<body>
<div>
    <form method="post" action="UserRegist">
        <label>账号：</label><input type="text" name="uid"><label class="errorMessage"><%=errorUid%></label><br>
        <br>
        <label>密码：</label><input type="password" name="pwd"><br>
        <br>
        <label>手机号：</label><input type="text" name="phone"><br>
        <br>
        <input type="submit" value="注册">
    </form>
</div>
</body>
</html>
