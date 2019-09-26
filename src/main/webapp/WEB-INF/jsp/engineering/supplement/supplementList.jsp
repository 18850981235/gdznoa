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
    <title>工程量增补查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/engineering/supplement/supplementList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <!--<script src="<%=basePath%>/js/public/pipelineNumber.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/engineering/supplement/supplementList.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>项目名</span>
                    <select id="ap" class="projectId" >
                        <option value="">请选择</option>
                    </select>
                </div>
                <div class="top2">
                    <span>系统名称</span>
                    <select class="subitemId"><option value="">请选择</option></select>
                </div>
                <div class="top3">
                    <span>类型</span>
                    <select class="type">
                        <option value="">请选择</option>
                        <option value="新建清单">新建清单</option>
                        <option value="增加清单">增加清单</option>
                        <option value="减少清单">减少清单</option>
                    </select>
                </div>
            </div>

            <div class="query-button" style="display: block">
                <a href="/ed/Quantity/toaddPage" class="add">新增</a>
                <input value="快速查询" type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 350px ">项目名</td>
                    <td style="width: 350px ">系统名称</td>
                    <td style="width: 300px ">类型</td>
                    <td style="width: 140px ">操作</td>
                </tr>
            </table>
            <table class="sea2" style="text-align: center">

            </table>
        </div>
        <div id="paginator-test"></div>
    </div>
</div>
</body>
</html>