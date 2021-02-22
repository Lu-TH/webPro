<%@ page import="com.company.entity.Orders" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/21
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单展示</title>
    <%
        Orders orders = (Orders)request.getAttribute("ordersObj");
    %>
</head>
<body>

<table>
    <tr>
        <th>oid</th>
        <th>date</th>
        <th>state</th>
        <th>uid</th>
    </tr>
    <tr>
        <td><%=orders.getOid() %></td>
        <td><%=orders.getOdate() %></td>
        <td><%=orders.getOstate() %></td>
        <td><%=orders.getFk_uid() %></td>
    </tr>
</table>
</body>
</html>
