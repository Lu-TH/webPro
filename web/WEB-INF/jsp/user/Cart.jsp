<%@ page import="java.util.Collection" %>
<%@ page import="com.company.entity.OrdersAndOrderItemsAndProduct" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/20
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <%
        String uid = (String) request.getAttribute("uid");
        Collection<OrdersAndOrderItemsAndProduct> prods = (Collection<OrdersAndOrderItemsAndProduct>) request.getAttribute("prods");
        double total = 0;
        int oid = 0;
        for (OrdersAndOrderItemsAndProduct p:prods) {
            double price = Double.parseDouble(p.getPprice());
            int num = p.getQuantity();
            total = price*num + total;
            oid = p.getOid();
        }
    %>
</head>
<body>
<div id="userInfo">
    <form action="UserInfo" method="post">
        <input type="submit" name="uid" value="<%=uid%>">
    </form>
</div>
<form action="UserCar" method="post">
    <input type="text" name="uid" value="<%=uid%>" hidden>
    <input type="submit" value="个人订单">
</form>
<table>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>quantity</th>
    </tr>
    <% for (OrdersAndOrderItemsAndProduct prod:prods) { %>
    <tr>
        <td><%=prod.getPname()%></td>
        <td><%=prod.getPprice()%></td>
        <td><%=prod.getQuantity()%></td>
    </tr>
    <% } %>
</table>
<label>共需要支付<%=total%>元</label>
<form action="PayAli" method="post">
    <input type="text" name="oid" value="<%=oid%>" hidden>
    <input type="submit" value="支付宝支付">
</form>
<form action="PayWe" method="post">
    <input type="text" name="oid" value="<%=oid%>" hidden>
    <input type="submit" value="微信支付">
</form>
</body>
</html>
