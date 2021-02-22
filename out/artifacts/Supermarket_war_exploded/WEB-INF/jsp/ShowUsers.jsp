<%@ page import="java.util.Collection" %>
<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/21
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有用户</title>
    <%
        Collection<User> users = (Collection<User>) request.getAttribute("users");
    %>
</head>
<body>
<table>
    <tr>
        <th>uid</th>
        <th>name</th>
        <th>phone</th>
        <th>address</th>
    </tr>
    <% for (User user : users) { %>
    <tr>
        <td><%=user.getUid() %></td>
        <td><%=user.getUname() %></td>
        <td><%=user.getUphone() %></td>
        <td><%=user.getUaddress() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
