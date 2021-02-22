<%@ page import="com.company.entity.Product" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/21
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有商品</title>
    <%
        String uid = (String) request.getAttribute("uid");
        Collection<Product> allProducts = (Collection<Product>) request.getAttribute("allProducts");
    %>
</head>
<body>
<form action="UserBuy" method="post">
<table>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>amount</th>
        <th>quantity</th>
    </tr>
    <% for (Product product : allProducts) { %>
    <tr>
        <td><%=product.getPname() %></td>
        <td><%=product.getPprice() %></td>
        <td><%=product.getAmount() %></td>
        <td><input type="text" value="0" name="<%=product.getPname()%>"></td>
    </tr>
        <% } %>
</table>
    <input type="text" value="<%=uid%>" name="uid" hidden>
    <input type="submit" value="加入购物车">
</form>
</body>
</html>
