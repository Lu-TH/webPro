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
    <title>登录</title>
    <%
        String errorPwd = (String) request.getAttribute("errorPwd");
        String errorUid = (String) request.getAttribute("errorUid");
        if (errorUid == null) {
            errorUid = "";
        }
        if (errorPwd == null) {
            errorPwd = "";
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
    <form method="post" action="UserLogin">
        <label>账号：</label><input type="text" name="uid"><label class="errorMessage"><%=errorUid%></label><br>
        <br>
        <label>密码：</label><input type="password" name="pwd"><label class="errorMessage"><%=errorPwd%></label><br>
        <br>
        <input type="submit" value="登录">
        <a href="UserRegist.jsp" type="button" style="text-decoration: none"><input type="button" value="注册"></a>
    </form>
</div>
</body>
</html>
