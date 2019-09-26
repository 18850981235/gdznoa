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
    <title>工程维保人员查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/../layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/engineering/maintenance/news/newsList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>-->
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/projectName.js"></script>-->
    <script src="<%=basePath%>/js/engineering/maintenance/news/newsList.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top" style="height: 40px ">
                <div class="top1" >
                    <span>项目名称</span>
                    <select class=""  style="height: 35px ;width: 295px ">
                        <option value="">请选择</option>
                    </select>
                </div>
                <div class="top2" >
                    <span>人员名称</span>
                    <input style="width: 280px ">
                </div>
            </div>

            <div class="query-button">
                <a href="personnelAdd.html" class="add">新建</a>
                <input value="快速查询"  type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; " >
                    <td style="width: 100px ">序号</td>
                    <td style="width: 200px ">项目名称</td>
                    <td style="width: 250px ">人员名称</td>
                    <td style="width: 250px ">联系电话</td>
                    <td style="width: 250px ">身份证</td>
                    <td style="width: 130px ">操作</td>
                </tr>
            </table>
            <table class="sea2"  style="text-align: center">

            </table>
        </div>
        <div id="paginator-test" style="height: 60px "></div>
    </div>
</div>
</body>
</html>