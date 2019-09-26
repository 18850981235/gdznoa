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
    <title>用户查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/background/user/userList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/background/user/userList.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top" style="display: block">
                <div class="top1">
                    <span>姓名</span>
                    <input class="name">
                </div>
                <div class="top2">
                    <span>账号</span>
                    <input class="account">
                </div>
            </div>

            <div class="query-button">
                <%--<a  href="/user/user/questPage" type="submit" class="add">权限审批 </a>--%>
                <input value="快速查询"  type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table   style="width:1211px ;text-align: center">
                <tr class="seal" style="width:1211px ;height: 40px;background-color: #c4de83; ">
                    <td style="width:50px">序号</td>
                    <td style="width:230px">账号</td>
                    <td style="width:150px">姓名</td>
                    <td style="width:80px">部门</td>
                    <td style="width:130px">职位</td>
                    <td style="width:80px">性别</td>
                    <td style="width:130px">电话</td>
                    <td style="width:200px ">邮箱</td>
                    <td style="width:110px ">操作</td>
                </tr>
            </table>
            <table  class="paging-in1">
                <tr class="paging-in"></tr>
            </table>
        </div>
        <div id="paginator-test" style="margin-left: 550px "></div>
    </div>
</div>
</body>
</html>