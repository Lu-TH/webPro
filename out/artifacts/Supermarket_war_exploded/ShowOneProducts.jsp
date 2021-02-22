<%@ page import="com.company.entity.Product" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/21
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示一种商品</title>
    <%
        Collection<Product> oneTypeProducts = (Collection<Product>) request.getAttribute("products");
    %>
</head>
<body>
<table>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>amount</th>
    </tr>
    <% for (Product product : oneTypeProducts) { %>
    <tr>
        <td><%=product.getPname() %></td>
        <td><%=product.getPprice() %></td>
        <td><%=product.getAmount() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
