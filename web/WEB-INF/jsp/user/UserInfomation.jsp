<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/20
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <%
        User user = (User) request.getAttribute("userObj");
    %>
</head>
<body>
<div>
    <img src="<%=user.getUlogo() %>">
</div>
<form action="ModUserInfo" method="post" enctype="multipart/form-data">
    <input type="text" name="uid" value="<%=user.getUid()%>" hidden>
    <label>修改头像  </label>
    <input type="file" name="logo">
    <br><br>
    <label>用户名 :</label><input type="text" name="uname" value="<%=user.getUname()%>">
    <br><br>
    <label>手机号 :</label><input type="text" name="uphone" value="<%=user.getUphone()%>">
    <br><br>
    <label>地址  :</label><input type="text" name="uaddress" value="<%=user.getUaddress()%>">
    <br><br>
    <input type="submit" value="确认修改">
</form>
</body>
</html>
