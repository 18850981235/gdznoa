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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../icon-font/iconfont.css">
    <link rel="stylesheet" href="../css/sign.css">
    <script src="../js/jquery-3.3.1.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/sign.js"></script>

</head>
<body>
<div id="on">
    <div id="on-in">

        <div class="on-time">
            <img class="logo" src="../imgs/logo.png" />
            <input id="time">
            <div id="day-time">
                <input id="day">
                <input id="daytime">
            </div>
            <div class="user">
                <img src="../imgs/user.png" />
                <form class="user-left">
                    <span>${user.company}</span>
                    <span>${user.name}</span>
                    <a href="">退出</a>
                </form>
            </div>
        </div>
        <div class="content">
            <ul>
                <li class="colour-1 Height"  >
                    <a href="/bd/project/query" class="modular " >
                        <span class="iconfont icon-yewushouli size" ></span>
                        <p class="name" >项目报备</p>
                    </a>
                </li>
                <li style="line-height:400%">
                    <a href="" class="modular1 colour-2">
                        <span class="iconfont icon-caigoudan size"></span>
                        <p class="name1">采购</p>
                    </a>
                    <a href="" class="modular1 colour-3">
                        <span class="iconfont icon-navicon-gystj size"></span>
                        <p class="name1">供应商</p>
                    </a>
                </li>
                <li class="colour-4 Height">
                    <a href="" class="modular ">
                        <span class="iconfont icon-fanganguihua size"></span>
                        <p class="name">解决方案</p>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="colour-5 Height">
                    <a href="" class="modular ">
                        <span class="iconfont icon-xiaoshouqushi size"></span>
                        <p class="name">销售合同</p>
                    </a>
                </li>
                <li class="colour-6 Height">
                    <a href="/mc/stamp/query" class="modular ">
                        <span class="iconfont icon-shangwu size"></span>
                        <p class="name" >商务管理</p>
                    </a>
                </li>
                <li class="colour-7 Height">
                    <a href="" class="modular">
                        <span class="iconfont icon-caiwu size"></span>
                        <p class="name">财税管理</p>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="colour-8 Height">
                    <a href="/bd/client/query" class="modular  ">
                        <span class="iconfont icon-kehuziliao size"></span>
                        <p class="name" >客户CRM</p>
                    </a>
                </li>
                <li style="line-height:400%">
                    <a href="" class="modular1 colour-9">
                        <span class="iconfont icon-fapiaoguanli size"></span>
                        <p class="name2">跨区涉税申请</p>
                    </a>
                    <a href="" class="modular1 colour-10">
                        <span class="iconfont icon-fuwu-active size"></span>
                        <p class="name1">专业服务</p>
                    </a>
                </li>
                <li class="colour-11 Height">
                    <a href="" class="modular" style="margin-right: auto;margin-left:20%">
                        <span class="iconfont icon-fl-gongcheng size"></span>
                        <p class="name">工程管理</p>
                    </a>
                </li>
            </ul>
            <ul >
                <li  class="colour-12">
                    <a href="" class="modular2" style="margin: 0px ;padding: 0px ">
                        <p class="iconfont1" style="">信息发布</p>
                    </a>
                </li>
            </ul>
        </div>

    </div>
</div>
</body>
</html>
