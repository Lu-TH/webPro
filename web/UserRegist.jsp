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
    <title>注册</title>
    <%
        String errorUid = (String) request.getAttribute("errorUid");
        if (errorUid == null) {
            errorUid = "";
        }
    %>
    <style>
        .errorMessage{
            color: red;
        }
    </style>
    <script>
        var flagAccount = false;
        var flagPwd = false;
        var flagPhone = false;
        var infos = document.getElementsByClassName("infos");

        function regAccount(){
            var reg = "[a-z][0-9][0-9][0-9][0-9]";
            var regexpObj = new RegExp(reg);
            if(regexpObj.test(infos[0].value)){
                flagAccount = true;
            }else{
                document.getElementsByClassName("errorMessage")[0].innerText = "账号非法";
            }
            //alert(flagAccount)
        }
        function regPwd(){
            var reg = "[0-9]{3}";
            var regexpObj = new RegExp(reg);
            if(regexpObj.test(infos[1].value)){
                flagPwd = true;
            }else{
                document.getElementsByClassName("errorMessage")[1].innerText = "密码非法";
            }
            //alert(flagPwd)
        }
        function regPhone(){
            var reg = "^1(3|4|5|7|8)\\d{9}$";
            var regexpObj = new RegExp(reg);
            if(regexpObj.test(infos[2].value)){
                flagPhone = true;
            }else{
                document.getElementsByClassName("errorMessage")[2].innerText = "手机号非法";
            }
           // alert(flagPhone)
        }
        function regAll(){
            regPhone();
            regPwd();
            regAccount();
            if(flagPhone && flagPwd && flagAccount){
                document.getElementById("sub1").type = "submit";
            }
        }
    </script>
</head>
<body>
<div>
    <form method="post" action="UserRegist">
        <label>账号：</label><input class="infos" type="text" name="uid" onblur="regAccount()"><label class="errorMessage"><%=errorUid%></label><br>
        <br>
        <label>密码：</label><input class="infos" type="password" name="pwd" onblur="regPwd()"><label class="errorMessage"></label><br>
        <br>
        <label>手机号：</label><input class="infos" type="text" name="phone" onblur="regPhone()"><label class="errorMessage"></label><br>
        <br>
        <input id="sub1" type="button" value="注册" onclick="regAll()">
    </form>
</div>
</body>
</html>
