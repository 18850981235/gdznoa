<%--
  Created by IntelliJ IDEA.
  User: lpy
  Date: 2019/1/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>登录</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/css/index.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/sign-in.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            height: 100%;
            width: 100%;
            background:url("<%=basePath%>/imgs/ob.jpg")no-repeat center ;
            z-index: 0;
            background-size: 100% 100%;
            position: relative;
        }

        #github-iframe {
            position: fixed;
            left: 32px;
            top: 32px;
        }

        #area-render {
            position: fixed;
            width: 320px;
            height: 160px;
            right: 4px;
            bottom: 4px;
            border: dashed 1px #ccc;
        }
        #logo{
            position: absolute;
            left: 70px  ;
            top:70px ;

        }
        #logo img{
            width: 170px ;
            height: 140px ;
        }

    </style>
</head>
<body <%--onload="checkForm()"--%>>
<input name="message" value="${login}" hidden="hidden">
<div id="github-iframe"></div>
<div id="logo"><img src="<%=basePath%>/imgs/logo.png"></div>
<div id="top">

    <div id="on">
        <div class="in">
            <h3>互联网+运营管理系统</h3>
            <form method="post" action="/page/login">
                <div class="conduct">
                    <div class="back-img">
                        <img src="<%=basePath%>/imgs/user1.png" />
                    </div>
                    <input placeholder="请输入用户名" name="account" value="${account}">
                    <c:if test="${error=='没有该账号'}">
                        <span class="co"> * 没有该账号</span>
                    </c:if>
                </div>
                <div class="conduct">
                    <div class="back-img">
                        <img src="<%=basePath%>/imgs/password.png" />
                    </div>
                    <input placeholder="请输入密码"  style="color: #000000" type="password"  name="password" value="123456">
                    <c:if test="${error=='密码错误'}">
                        <span class="co1">*密码错误</span>
                    </c:if>
                </div>
                <div class="drag">
                    <div class="bg"></div>
                    <div class="text" onselectstart="return false;">请拖动滑块解锁</div>
                    <div class="btn">>></div>
                </div>
                <input value="登陆"  type="submit" class="ok"  style="background-color:#0067b8 " disabled="disabled" >
            </form>
            <div class="jump">
                <a>注册账号</a>
                <a class="retrieve">忘记密码</a>
            </div>
        </div>
        <p class="bottom">福建省广电智能系统集成工贸有限公司@版权所有</p>
    </div>

</div>
<!--<div id="area-render"></div>-->

<script type="text/javascript" color="255,255,255" pointColor="255,255,255" opacity='40' zIndex="-2" count="500" src="<%=basePath%>/canvas-nest.js-master/dist/canvas-nest.js"></script>
<script type="text/javascript" src="<%=basePath%>/canvas-nest.js-master/dist/canvas-nest.umd.js"></script>
<%--<script type="text/javascript">
    var cn = new CanvasNest(document.getElementById('area-render'), {
        color: '255,0,255',
        count: 5,
    });


    loadGitHubBtn();
    function checkForm() {
        var flag = true;
        var message = $("input[name='message']").val();
        if (message != null && message != "") {
            alert(message);
            flag = false;
        }
        return flag;
    }

</script>--%>
</body>
</html>
