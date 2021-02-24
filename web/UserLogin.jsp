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
    <title>登录</title>
    <%
        String errorPwd = (String) request.getAttribute("errorPwd");
        String errorUid = (String) request.getAttribute("errorUid");
        if (errorUid == null) {
            errorUid = "";
        }
        if (errorPwd == null) {
            errorPwd = "";
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
                document.getElementsByClassName("errorMessage")[0].innerText = "";
            }else{
                document.getElementsByClassName("errorMessage")[0].innerText = "账号非法";
            }
            //alert(flagAccount)
        }
        function regPwd(){
            var reg = " ";
            var regexpObj = new RegExp(reg);
            //alert(regexpObj.test(infos[1].value));
            if(regexpObj.test(infos[1].value) || infos[1].value == ""){
                document.getElementsByClassName("errorMessage")[1].innerText = "密码非法";
            }else{
                flagPwd = true;
                document.getElementsByClassName("errorMessage")[1].innerText = "";
            }
            //alert(flagPwd)
        }
        function regAll(){
            //regPhone();
            regPwd();
            regAccount();
            if(flagPwd && flagAccount){
                document.getElementById("sub1").type = "submit";
            }
        }
    </script>
</head>
<body>
<div>
    <form method="post" action="UserLogin">
        <label>账号：</label><input class="infos" type="text" name="uid" onblur="regAccount()"><label class="errorMessage"><%=errorUid%></label><br>
        <br>
        <label>密码：</label><input class="infos" type="password" name="pwd" onblur="regPwd()"><label class="errorMessage"><%=errorPwd%></label><br>
        <br>
        <input id="sub1" type="button" value="登录" onclick="regAll()">
        <a href="UserRegist.jsp" type="button" style="text-decoration: none"><input type="button" value="注册"></a>
    </form>
</div>
</body>
</html>
