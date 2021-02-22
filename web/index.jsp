<%@ page import="java.util.Collection" %>
<%@ page import="com.company.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: LuTH
  Date: 2021/2/2
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>商店首页</title>
    <%
      String uid = (String) request.getAttribute("uid");
    %>
    <style>
      #d01{
        position: absolute;
        left: 800px;
        top: 10px;
        font-size: 9px;
      }
    </style>
  </head>
  <body>
  <div id="d01">
    <a href="UserLogin.jsp">登录</a>
    <a href="UserRegist.jsp">注册</a>
  </div>

  <div id="d02">
    <form method="post" action="SearchProduct">
      <input type="text" name="uid" value="<%=uid%>" hidden>
      <input type="text" name="search">
      <input type="submit" value="搜索">
    </form>
  </div>
  <div id="d03">
    <form method="get" action="SearchProduct">
      <input type="text" name="uid" value="<%=uid%>" hidden>
      <label>排序方法</label><input type="radio" name="order" value="asc" checked>asc
      <input type="radio" name="order" value="desc">desc
      <br>
      <input type="submit" value="查看所有商品">
    </form>
  </div>
  </body>
</html>
