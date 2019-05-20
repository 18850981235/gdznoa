<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/27
  Time: 16:02
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
    <title>项目立项</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/project/projectList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/bd/project/projectList.js"></script>
</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <!---->
    <a class="page-left ">项目立项</a>
</div>
<!---->
<div id="content-in" >
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>项目编号：	</span>
                    <input class="name2">
                </div>
                <div class="top2">
                    <span>单位类型：	</span>
                    <select class="name1" style="height: 25px ">
                        <option value="">请选择</option>
                        <option value="政府">政府</option>
                        <option value="国有企业" >国有企业</option>
                        <option value="事业单位">事业单位</option>
                        <option value="外资企业">外资企业</option>
                        <option value="民营企业">民营企业</option>
                    </select>
                </div>
                <div class="top3">
                    <span>状态</span>
                    <select class="name4" style="height: 25px ">
                        <option value="">请选择</option>
                        <option value="进行中">进行中</option>
                        <option value="已结束">已结束</option>
                        <option value="不通过">不通过</option>
                    </select>
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>项目名称：	</span>
                    <input class="name3">
                </div>
                <div class="in2">
                    <span>项目立项时间：</span>
                    <input type="date" class="time-x">
                    <span>至</span>
                    <input type="date" class="time-d">
                    <input  style="display:none;" class="time-z">
                </div>
            </div>
            <div class="query-button" >

                <input value="新增" type="submit" class="add">
                <input value="快速查询"  type="submit" class="query"/>
                <input value="重置"  type="submit" class="reset">

            </div>
        </div>
        <div class="paging">
            <table >
                <tr style="height: 40px" class="start">
                    <td style="width: 80px"><b>选择</b></td>
                    <td style="width: 300px"><b>项目编号</b></td>
                    <td style="width: 300px"><b>项目名称</b></td>
                    <td style="width: 100px"><b>项目负责人</b></td>
                    <td style="width: 150px"><b>项目合作方式</b></td>
                    <td style="width: 150px"><b>项目成立时间</b></td>
                    <td style="width: 100px"><b>状态</b></td>
                    <td style="width: 150px"><b>操作</b></td>
                </tr>

            </table>
        </div>
        <div id="paginator-test"></div>
    </div>
</div>
<!---->
</body>
</html>