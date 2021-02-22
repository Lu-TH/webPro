<%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/21
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员业务</title>
</head>
<body>
<form action="ProductAdd" method="post">
    <label>商品编号</label><input type="text" name="pid"><br>
    <label>商品名字</label><input type="text" name="pname"><br>
    <label>商品单价</label><input type="text" name="pprice"><br>
    <label>商品库存</label><input type="text" name="amount"><br>
    <label>商品类型</label><input type="text" name="ptype"><br>
    <input type="submit" value="添加商品">
</form><br>
<form action="ProductDelete" method="post">
    <label>请输入需要删除的商品编号</label><input type="text" name="pid"><br>
    <input type="submit" value="删除商品">
</form><br>
<form action="ProductAdd" method="get">
    <label>商品编号</label><input type="text" name="pid"><br>
    <label>商品名字</label><input type="text" name="pname"><br>
    <label>商品单价</label><input type="text" name="pprice"><br>
    <label>商品库存</label><input type="text" name="amount"><br>
    <label>商品类型</label><input type="text" name="ptype"><br>
    <input type="submit" value="更新商品">
</form>
<br><br>
<form method="post" action="OrdersCancleAndCheck">
    <label>输入需要取消的订单号:</label><input type="text" name="oid"><br>
    <input type="submit" value="取消订单">
</form><br>
<form method="get" action="OrdersCancleAndCheck">
    <label>输入需要查看的订单号:</label><input type="text" name="oid"><br>
    <input type="submit" value="查看订单">
</form><br>
<form method="post" action="OrderItemsUpdate">
    <label>订单号:</label><input type="text" name="oid"><br>
    <label>商品号:</label><input type="text" name="pid"><br>
    <label>商品数量:</label><input type="text" name="quantity"><br>
    <input type="submit" value="修改订单">
</form>
<br><br>
<form action="UserInfo" method="get">
    <input type="submit" value="查看所有用户">
</form><br>
<form action="ModUserInfo" method="get">
    <label>用户id:</label><input type="text" name="uid">
    <br>
    <label>姓名:</label><input type="text" name="uname" >
    <br>
    <label>手机号:</label><input type="text" name="uphone">
    <br>
    <label>地址:</label><input type="text" name="uaddress">
    <br>
    <input type="submit" value="修改用户">
</form>
<form action="UserDelete" method="post">
    <label>输入需要删除的用户编号:</label><input type="text" name="uid"><br>
    <input type="submit" value="删除用户">
</form>
</body>
</html>
