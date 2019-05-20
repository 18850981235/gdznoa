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
    <title>项目详细</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/project/projectParticular.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/Approval.js"></script>
    <script src="<%=basePath%>/js/mc/top/myProject.js"></script>

</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <!---->
    <div id="choice" style="display: none">
        <p class="title">
            <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
            福建省广电智能系统集成工贸有限公司
        </p>
        <ul class="yiji-no">
            <li style="display:none;">
                <a href="#" class="click"></a>
                <ul class="name" style="display: none">
                    <li>
                        <a class="upload" href="">
                            <span class="name-block"></span>
                            <span class="name-none" style="display: none"></span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <div id="close">
            <a class="close-in" href="">返回</a>
        </div>
    </div>

    <a class="page-left ">项目详细</a>
</div>
<!---->
<div id="content-in">
    <div id="center">

        <div id="Approval">

        </div>

    </div>

</div>
</body>
</html>