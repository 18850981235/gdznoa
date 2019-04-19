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
    <title>商务材料详情</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcMaterial/mcMaterialAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/mc/mcMaterial/mcMaterialParticular.js"></script>
</head>
<body>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <a class="page-left ">商务材料详情</a>
</div>
<div id="content-in">
    <div id="center">
        <form>
            <!--<table border="1">-->
            <!--<tr style="text-align: center;height: 45px ">-->
            <!--<td colspan="4" style="width: 900px;background-color: #efefef "><b>商务材料详情</b><input style="display: none" name="id"></td>-->
            <!--</tr>-->
            <!--<tr style="height: 45px ">-->
            <!--<td style="width:150px ;background-color: #efefef;">申请部门</td>-->
            <!--<td style="width:300px ;"></td>-->
            <!--<td style="width:150px ;;background-color: #efefef">申请日期</td>-->
            <!--<td style="width:300px ;"></td>-->
            <!--</tr>-->
            <!--<tr  style="height: 45px ">-->
            <!--<td style="width:150px ;background-color: #efefef;">提供方式</td>-->
            <!--<td style="width:300px ;"></td>-->
            <!--<td style="width:150px ;background-color: #efefef;">收件人</td>-->
            <!--<td style="width:300px ;"></td>-->
            <!--</tr>-->
            <!--<tr style="height: 45px ">-->
            <!--<td style="width:150px ;background-color: #efefef;">收件人电话</td>-->
            <!--<td colspan="3" ></td>-->
            <!--</tr>-->
            <!--<tr style="height: 45px ">-->
            <!--<td style="width:150px ;background-color: #efefef;">收件地址</td>-->
            <!--<td colspan="3" ></td>-->
            <!--</tr>-->
            <!--<tr style="height: 45px ">-->
            <!--<td style="width:150px ;background-color: #efefef;">申请商务资料的内容及要求</td>-->
            <!--<td colspan="3" ></td>-->
            <!--</tr>-->
            <!--<tr style="height: 45px ">-->
            <!--<td style="width:150px ;background-color: #efefef;">资料用途说明</td>-->
            <!--<td colspan="3" ></td>-->
            <!--</tr>-->
            <!--<tr style="height: 45px ">-->
            <!--<td style="width:150px ;background-color: #efefef;">附件</td>-->
            <!--<td colspan="3" ></td>-->
            <!--</tr>-->

            <!--</table>-->

            <a href="#" id="no" style="color: #333;margin-left: 450px ">返回</a>
        </form>
    </div>
</div>
</body>
</body>
</html>