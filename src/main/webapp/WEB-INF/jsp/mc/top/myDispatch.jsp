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
    <title>人员派遣详情</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcStamp/mcStampAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/Approval.js"></script>
    <script src="<%=basePath%>/js/mc/top/myDispatch.js"></script>
</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        福建省广电智能系统集成工贸有限公司
    </p>
    <ul class="yiji-no">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name" style="display: none">
                <li class="co">
                    <a class="upload" href="">
                        <span class="name-block"></span>
                        <span class="name-none" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="page">
    <a class="page-left ">人员派遣详情</a>
</div>
<div id="content-in">
    <div id="center">

        <!--<table border="1">-->
        <!--<tr style="height: 40px ;background-color: #efefef">-->
        <!--<td colspan="4" style="text-align: center"><b>人员派遣详情</b><input style="display: none" name="id"></td>-->
        <!--</tr>-->
        <!--<tr style="height:40px;">-->
        <!--<td style="width:150px ;;background-color: #efefef">项目名</td>-->
        <!--<td style="width:300px ;"></td>-->
        <!--<td style="width:150px ;background-color: #efefef;">申请部门</td>-->
        <!--<td style="width:300px ;"></td>-->
        <!--</tr>-->
        <!--<tr  style="height:40px;">-->
        <!--<td style="width:150px ;background-color: #efefef;">申请人派遣要求</td>-->
        <!--<td colspan="3"></td>-->
        <!--</tr>-->
        <!--<tr style="height:40px;">-->
        <!--<td style="width:150px ;background-color: #efefef;">预计出差时间</td>-->
        <!--<td ></td>-->
        <!--<td style="width:150px ;background-color: #efefef;">人员出场费用</td>-->
        <!--<td ></td>-->
        <!--</tr>-->
        <!--<tr style="height:40px;">-->
        <!--<td style="width:150px ;background-color: #efefef;">附件</td>-->
        <!--<td colspan="3">-->
        <!--&lt;!&ndash;<form  action="http://192.168.1.191:8080/util/fileDown" style="width: 700px ">&ndash;&gt;-->
        <!--&lt;!&ndash;<input style="width: 700px " name="file" >&ndash;&gt;-->
        <!--&lt;!&ndash;<input style="background-color: transparent"  type="submit" >&ndash;&gt;-->
        <!--&lt;!&ndash;</form>&ndash;&gt;-->
        <!--</td>-->
        <!--</tr>-->

        <!--</table>-->
        <form id="Approval">


        </form>
        <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
        <a href="#" id="no" style="color: #333">取消</a>
    </div>
</div>
</body>
</html>