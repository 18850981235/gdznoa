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
    <title>职位管理</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/background/user/department.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <script src="<%=basePath%>/js/public/position.js"></script>
    <script src="<%=basePath%>/js/background/user/position.js"></script>
    <!--<script src="<%=basePath%>/js/background/user/userList.js"></script>-->
</head>
<body>
<div id="content-in">
    <div id="center">
        <table border="1">
            <tr style="height: 40px ;background-color: #efefef">
                <td colspan="4" style="text-align: center;width: 800px ">
                    <b>职位管理</b>
                </td>
            </tr>
        </table>
        <div style="display: flex">
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">已有的职位</span>
                <ul id="dept">

                </ul>
            </div>
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">新增职位</span>
                <input id="Add" style="border: 1px solid;width: 150px ;height: 25px;display: block ;margin-left: auto;margin-right: auto" placeholder="增加职位名称" required>
                <input id="Add-in" class="ok" style="margin-left: 70px;margin-top: 15px " type="submit" value="添加">
            </div>
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">修改职位</span>
                <select id="change" class="position" style="display: block;width: 150px ;height: 25px;margin-left: auto;margin-right: auto">

                </select>
                <input id="change-on" style="border: 1px solid;width: 150px ;height: 25px;display: block ;margin-left: auto;margin-right: auto;margin-top: 10px " placeholder="修改职位名称" required>
                <input id="change-in" class="ok" style="margin-left: 70px;margin-top: 15px " type="submit" value="修改">
            </div>
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">删除职位</span>
                <select id="delete" class="position" style="display: block;width: 150px ;height: 25px;margin-left: auto;margin-right: auto">

                </select>
                <!--<input id="delete" style="border: 1px solid;width: 150px ;height: 25px;display: block;margin-left: auto;margin-right: auto ">-->
                <input id="delete-in" class="ok" style="margin-left: 70px;margin-top: 15px " type="submit" value="删除">
            </div>
        </div>


    </div>
</div>
<script>

</script>
</body>
</html>