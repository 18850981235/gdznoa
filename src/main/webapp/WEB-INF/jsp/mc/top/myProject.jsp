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
    <%--<script src="<%=basePath%>/js/public/Approval.js"></script>--%>
    <script src="<%=basePath%>/js/mc/top/myProject.js"></script>

</head>
<body>


<div id="content-in">
    <form action="/bd/project/approvalDetailed" id="center">

        <div id="Approval">

        </div>
        <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
        <a href="/showMyWork" id="no" >取消</a>
    </form>

</div>
</body>
</html>