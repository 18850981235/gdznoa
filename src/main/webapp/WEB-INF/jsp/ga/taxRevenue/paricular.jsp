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
    <title>税收项详情</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/outerTube/outerTubeAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/finance/taxRevenue/indexParticular.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form  method="post"  enctype="multipart/form-data">

            <a href="/ga/show" id="no" style="margin-left: 480px " >返回</a>
        </form>
    </div>
</div>
</body>
</html>