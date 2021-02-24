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
    <%
        String addMessage = (String) request.getAttribute("addMessage");
        String delMessage = (String) request.getAttribute("delMessage");
        if (delMessage == null) {
            delMessage = "";
        }if (addMessage == null) {
        addMessage = "";
    }
    %>
    <script>
        var insPros = document.getElementsByClassName("insPro");
        var flag1 = false;
        var flag2 = false;
        var flag3 = false;
        var flag4 = false;
        var flag5 = false;
        function regPid2(obj){
            var reg = "[a-z][0-9][0-9][0-9][0-9]";
            var regexpObj = new RegExp(reg);
            if(regexpObj.test(obj.value)){
                flag1 = true;
                document.getElementById("l6").innerText = "";
            }else {
                document.getElementById("l6").innerText = "商品编号格式错误";
            }
        }
        function regPid1(obj){
           var reg = "[a-z][0-9][0-9][0-9][0-9]";
            var regexpObj = new RegExp(reg);
            if(regexpObj.test(obj.value)){
                flag1 = true;
                document.getElementById("l1").innerText = "";
            }else {
                document.getElementById("l1").innerText = "商品编号格式错误";
            }
        }
        function regPname(obj){
            var reg = " ";
            var regexpObj = new RegExp(reg);
            if(!regexpObj.test(obj.value) && obj.value != ""){
                flag2 = true;
                document.getElementById("l2").innerText = "";
            }else {
                document.getElementById("l2").innerText = "商品名字格式错误";
            }
        }
        function regPrice(obj){
            var reg = "[1-9][0-9]";
            var regexpObj = new RegExp(reg);
            if(regexpObj.test(obj.value)){
                flag3 = true;
                document.getElementById("l3").innerText = "";
            }else {
                document.getElementById("l3").innerText = "商品价格格式错误";
            }
        }
        function regAmount(obj){
            var reg = "[1-9][0-9]";
            var regexpObj = new RegExp(reg);
            if(regexpObj.test(obj.value)){
                flag4 = true;
                document.getElementById("l4").innerText = "";
            }else {
                document.getElementById("l4").innerText = "商品库存格式错误";
            }
        }
        function regPtype(obj){
            var reg = " ";
            var regexpObj = new RegExp(reg);
            if(!regexpObj.test(obj.value) && obj.value != ""){
                flag5 = true;
                document.getElementById("l5").innerText = "";
            }else {
                document.getElementById("l5").innerText = "商品类型格式错误";
            }
        }
        function regAll(obj){
            if(!flag1){
                document.getElementById("l1").innerText = "商品编号格式错误";
            }
            if(!flag2){
                document.getElementById("l2").innerText = "商品名字格式错误";
            }
            if(!flag3){
                document.getElementById("l3").innerText = "商品单价格式错误";
            }
            if(!flag4){
                document.getElementById("l4").innerText = "商品库存格式错误";
            }
            if(!flag5){
                document.getElementById("l5").innerText = "商品类型格式错误";
            }
            if(flag1 && flag2 && flag3 && flag4 && flag5){
                obj.type = "submit";
            }
        }
        function regDel(obj){
            regPid2(document.getElementById("delPid"));
            if(flag1){
                obj.type = "submit";
            }else{
                obj.type = "button";
            }
        }
    </script>
</head>
<body>
<form action="ProductAdd" method="post">
    <label>商品编号</label><input class="insPro" type="text" name="pid" onblur="regPid1(this)"><label id="l1"></label><br>
    <label>商品名字</label><input class="insPro" type="text" name="pname" onblur="regPname(this)"><label id="l2"></label><br>
    <label>商品单价</label><input class="insPro" type="text" name="pprice" onblur="regPrice(this)"><label id="l3"></label><br>
    <label>商品库存</label><input class="insPro" type="text" name="amount" onblur="regAmount(this)"><label id="l4"></label><br>
    <label>商品类型</label><input class="insPro" type="text" name="ptype" onblur="regPtype(this)"><label id="l5"></label><br>
    <input id="insert" type="button" value="添加商品" onclick="regAll(this)"><label style="color: red"><%=addMessage%></label>
</form><br>
<form action="ProductDelete" method="post">
    <label>请输入需要删除的商品编号</label><input type="text" name="pid" id="delPid" onblur="regPid2(this)"><label id="l6"></label><br>
    <input type="button" value="删除商品" onclick="regDel(this)"><label style="color: red"><%=delMessage%></label>
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
