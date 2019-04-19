<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lpy
  Date: 2019/1/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/sign-in.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/sign-in.js"></script>
</head>
<body onload="checkForm()">


<input name="message" value="${login}" hidden="hidden">
<div id="top">
    <img src="<%=basePath%>/imgs/logo.png"/>
    <div id="on">
        <div class="in">
            <p>福建广电智能信息管理系统</p>
            <form method="post" action="/page/login">
                <div class="conduct">
                    <div class="back-img">
                        <img src="<%=basePath%>/imgs/user1.png"/>
                    </div>
                    <input placeholder="请输入用户名" style="color: #ffffff" name="account" value="${account}">
                    <c:if test="${error=='没有该账号'}">
                        <span class="co"> * 没有该账号</span>
                    </c:if>
                </div>
                <div class="conduct">
                    <div class="back-img">
                        <img src="<%=basePath%>/imgs/password.png"/>
                    </div>
                    <input placeholder="请输入密码" style="color: #ffffff" type="password" name="password" value="123456">
                    <c:if test="${error=='密码错误'}">
                        <span class="co1">*密码错误</span>
                    </c:if>

                </div>
                <div class="drag">
                    <div class="bg"></div>
                    <div class="text" onselectstart="return false;">请拖动滑块解锁</div>
                    <div class="btn">>></div>
                </div>
                <input value="登陆" type="submit" class="ok" disabled="disabled">
            </form>
            <div class="jump">
                <a>注册账号</a>
                <a class="retrieve">忘记密码</a>
            </div>
        </div>
        <p class="bottom">福建省广电智能系统集成工贸有限公司@股份所有</p>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    function checkForm() {
        var flag = true;
        var message = $("input[name='message']").val();
        if (message != null && message != "") {
            alert(message);
            flag = false;
        }
        return flag;
    }

</script>