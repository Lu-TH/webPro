<%@ page import="java.util.Collection" %>
<%@ page import="com.company.entity.OrdersAndOrderItemsAndProduct" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/22
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人订单</title>
    <%
        Collection<OrdersAndOrderItemsAndProduct> products = (Collection<OrdersAndOrderItemsAndProduct>) request.getAttribute("products");
    %>
</head>
<body>
<table>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>quantity</th>
    </tr>
    <% for (OrdersAndOrderItemsAndProduct obj : products) { %>
    <tr>
        <td><%=obj.getPname()%></td>
        <td><%=obj.getPprice()%></td>
        <td><%=obj.getQuantity()%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
