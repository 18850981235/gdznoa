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
    <title>管理页面</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/background/user-on/administration.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/background/user-on/administration.js"></script>
</head>
<body>

<div id="query-button">
    <div class="query-top">
        <div class="top1">
            <span>名称</span>
            <input class="name">
        </div>

        <div class="top2">
            <span>出差时间</span>
            <input type="text" style="float: left" id="test1" placeholder="请选择时间" >
            <span style="width:10px ;">-</span>
            <input type="text" id="test2" placeholder="请选择时间" >
        </div>
    </div>

    <div class="query-button">

        <input value="快速查询"  type="submit" class="query"/>
    </div>
</div>

<table style="width:1200px ;text-align: center;margin-left: auto;margin-right: auto">
    <tr style="height: 30px;background-color: #efefef ">
        <td colspan="10">我的审批</td>
    </tr>
    <tr style="height: 30px ">
        <td style="width: 60px ">序号</td>
        <td style="width:80px  ">申请人</td>
        <td style="width:90px  ">申请日期</td>
        <td >申请所需权限</td>
        <td style="width: 130px ">联系电话</td>
        <td style="width: 80px ">证明人</td>
        <td style="width:130px  ">证明人电话</td>
        <td style="width:100px ">证明材料</td>
        <td style="width:80px  ">状态</td>
        <td style="width:100px  ">操作</td>
    </tr>


</table>
<table style="width:1200px ;text-align: center;margin-left: auto;margin-right: auto">
    <tr class="table"></tr>
</table>
</body>
<script type="text/javascript">
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test2', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
</script>
</html>