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
    <title>外经证</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/outerTube/outerTubeList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/projectName.js"></script>-->
    <script src="<%=basePath%>/js/finance/outerTube/outerTubeList.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <!--<div id="query-button">-->
            <!--<div class="query-top" style="display: block;height: 45px ">-->
                <!--<div class="top1">-->
                    <!--<span>品牌</span>-->
                    <!--<input>-->
                <!--</div>-->
                <!--<div class="top2">-->
                    <!--<span>主要产品及设备</span>-->
                    <!--<input>-->
                <!--</div>-->
            <!--</div>-->
            <!--<div class="query-button" style="display: block">-->
                <!--<a href="merchantAdd.html" class="add">新建</a>-->
                <!--<input value="快速查询"  type="submit" class="query"/>-->
            <!--</div>-->
        <!--</div>-->
        <div class="paging">
            <table   style="text-align: center" >
                <tr class="seal" style="height: 40px;background-color: #c4de83; " >
                    <td style="width: 100px ">序号</td>
                    <td style="width: 350px ">项目名称</td>
                    <td style="width: 250px ">申请人</td>
                    <td style="width: 250px ">申请日期</td>
                    <td style="width: 150px ">完成时间</td>
                    <td style="width: 110px ">操作</td>
                </tr>
            </table>
            <table class="sea2"  style="text-align: center">

            </table>
        </div>
        <!--<div id="paginator-test" style="height: 60px;margin-left: 600px  "></div>-->
        <a href="/ga/show" class="add" style="height: 25px;margin-left: 600px  ">返回</a>
    </div>
</div>
</body>
</html>