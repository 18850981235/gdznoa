<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 14:53
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
    <title>立项修改</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/project/projectAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/responsible.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/see.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/company.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/region.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/department.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/bd/project/projectPadute.js"></script>
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
<div id="choice1" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="name1" >
        <li class="co1">
            <a class="upload1" href="">
                <span class="name-block1"></span>
                <span class="name-none1" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close1">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="choice2" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no2">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name2" style="display: none">
                <li>
                    <a class="upload-noe" href="">
                        <span class="name-block2"></span>
                        <span class="name-none2" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close2">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="choice3" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="name3" >
        <li class="co3">
            <a class="upload3" href="">
                <span class="name-block3"></span>
                <span class="name-none3" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close3">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="choice4" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="name4" >
        <li class="co4">
            <a class="upload4" href="">
                <span class="name-block4"></span>
                <span class="name-none4" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close4">
        <a class="close-in" >返回</a >
    </div>
</div>
<!---->
<div id="content-in">
    <div id="center">

        <form id="form1" action="/bd/project/update.html" method="post">

            <input id="ok" type="submit" value="保存" style="margin-left: 350px ">
            <a href="/bd/project/query" id="no" style="">返回</a>
        </form>
    </div>
</div>
</body>
</html>