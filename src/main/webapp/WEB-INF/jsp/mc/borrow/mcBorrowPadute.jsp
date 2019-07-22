<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 11:13
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
    <title>原件借用修改</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcStamp/mcStampAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/mc/mcBorrow/mcBorrowPadute.js"></script>
</head>
<body>

<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name" style="display: none">
                <li class="co">
                    <a class="upload" href="">
                        <span class="name-block"></span>
                        <span class="name-none" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="choice4" style="display: none" >
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <div class="search">
        <input class="search-1" style="border: 1px solid">
        <input class="search-2"  type="button" value="搜索">
        <input class="search-3" type="button" value="返回">
    </div>
    <div class="choice4-con" style="display: none">
        <a class="noe">
            <p>资历证书</p>
        </a>
        <a class="tow">
            <p>业绩证书</p>
        </a>
    </div>
    <div class="noe-no" style="display: none">

    </div>
    <div class="tow-no">

    </div>
    <div class="on" style="text-align: center"></div>
    <div id="close4">
        <a class="close-in" >关闭</a >
    </div>
</div>
<div id="content-in">
    <div id="center">
        <form action="/mc/borrow/update.html" method="post"  enctype="multipart/form-data">
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/borrow/query" id="no"  >取消</a>
        </form>
    </div>
</div>
</body>
</html>