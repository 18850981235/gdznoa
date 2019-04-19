<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/11
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/sign.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/sign.js"></script>



</head>
<body>
<div id="on">
    <div id="on-in">
        <div class="on-time">
            <img class="logo" src="<%=basePath%>/imgs/logo.png" />
            <input id="time">
            <div class="day-time">
                <input id="day">
                <input id="daytime">
            </div>
            <div class="user">
                <img src="<%=basePath%>/imgs/user.png" />
                <form class="user-left">
                    <span>${user.name}</span>
                    <span>${user.company}</span>
                    <a href="/page/quit">退出</a>
                </form>
            </div>
        </div>
        <div class="content">
            <ul>
                <li>
                    <a href="/bd/project/query" class="modular colour-1">
                        <span class="iconfont icon-yewushouli size"></span>
                        <p class="name">项目报备</p>
                    </a>
                </li>
                <li>
                    <a href="" class="modular1 colour-2">
                        <span class="iconfont icon-caigoudan size"></span>
                        <p class="name1">采购</p>
                    </a>
                    <a href="" class="modular1 colour-3">
                        <span class="iconfont icon-navicon-gystj size"></span>
                        <p class="name1">供应商</p>
                    </a>
                </li>
                <li>
                    <a href="" class="modular colour-4">
                        <span class="iconfont icon-fanganguihua size"></span>
                        <p class="name">解决方案</p>
                    </a>
                </li>
            </ul>
            <ul>
                <li>
                    <a href="" class="modular colour-5">
                        <span class="iconfont icon-xiaoshouqushi size"></span>
                        <p class="name">销售合同</p>
                    </a>
                </li>
                <li>
                    <a href="" class="modular colour-6">
                        <span class="iconfont icon-shangwu size"></span>
                        <p class="name">商务投标</p>
                    </a>
                </li>
                <li>
                    <a href="" class="modular colour-7">
                        <span class="iconfont icon-caiwu size"></span>
                        <p class="name">财税管理</p>
                    </a>
                </li>
            </ul>
            <ul>
                <li>
                    <a href="/bd/client/query" class="modular colour-8">
                        <span class="iconfont icon-kehuziliao size"></span>
                        <p class="name">客户CRM</p>
                    </a>
                </li>
                <li>
                    <a href="" class="modular1 colour-9">
                        <span class="iconfont icon-fapiaoguanli size"></span>
                        <p class="name1">外管</p>
                    </a>
                    <a href="" class="modular1 colour-10">
                        <span class="iconfont icon-fuwu-active size"></span>
                        <p class="name1">专业服务</p>
                    </a>
                </li>
                <li>
                    <a href="" class="modular colour-11">
                        <span class="iconfont icon-fl-gongcheng size"></span>
                        <p class="name">工程管理</p>
                    </a>
                </li>
            </ul>
            <ul>
                <li>
                    <a href="" class="modular2 colour-12">
                        <span class="iconfont "></span>
                    </a>
                </li>
            </ul>
        </div>

    </div>
</div>
</body>
</html>
