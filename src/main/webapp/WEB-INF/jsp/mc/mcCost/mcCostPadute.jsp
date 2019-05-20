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
    <title>资料费管理修改</title>
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
    <script src="<%=basePath%>/js/public/projectName.js"></script>
    <script src="<%=basePath%>/js/mc/mcCost/mcCostPadute.js"></script>
</head>
<body>
<div id="left">
    <img src="<%=basePath%>/imgs/logo1.png" />
    <div id="menu">
        <div class="list">
            <ul class="yiji" >
                <li style="display: none">
                    <a href="#" class="inactive"></a>
                    <ul style="display: none">
                        <li>
                            <a href="#" class="inactive active"></a>
                            <ul>
                                <li><a href="#"></a></li>
                            </ul>
                        </li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="top" >

    <a>
        <img src="<%=basePath%>/imgs/icon1.png" height="25" width="25"/>
        <p>首页</p>
    </a>
    <a>
        <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
        <p>我的工作</p>
    </a>

    <a class="top-right">
        <img src="<%=basePath%>/imgs/20160602111922932.png" height="25" width="25"/>
        <p>用户管理</p>
    </a>
    <a style="float: right">
        <p>名称</p>
        <P>公司</P>
    </a>
    <div class="day-time">
        <input id="day">
        <input id="daytime">
    </div>
    <input id="time">
    <div id="weather">
        <p></p>
        <span></span>
        <p class="comment"></p>
    </div>
</div>
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
    <a class="page-left ">资料费管理修改</a>
</div>
<div id="content-in">
    <div id="center">
        <form action="/mc/datum/update.html" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>资料费管理修改</b><input style="display: none" name="id">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">项目名:</td>
                    <td colspan="3">
                        <select class="projectname" style="width: 500px ;height: 35px " name="projectid">

                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门:</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid">

                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">申请日期:</td>
                    <td style="width:300px ;">
                        <input type="date" style="width:280px "  name="createtime">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">项目负责人:</td>
                    <td >
                        <input class="Eliminate" readonly >
                        <input style="display: none" class="Eliminate-no" name="userid">
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">项目预算:</td>
                    <td style="width:300px ;">
                        <input  style="width:280px " name="budget">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">商务部按标准核定费用:</td>
                    <td ><input style="width: 300px "name="mcVerifyCost" ></td>
                    <td style="width:150px ;background-color: #efefef;">管理负责人审批金额:</td>
                    <td ><input style="width: 300px " name="principalCost"></td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">附件:</td>
                    <td colspan="3"><input type="file" style="width: 700px " name="file"></td>
                </tr>
            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="#" id="no" style="color: #333">取消</a>
        </form>
    </div>
</div>
</body>
</html>