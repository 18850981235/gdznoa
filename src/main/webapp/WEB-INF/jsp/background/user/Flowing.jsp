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
    <title>流程</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <!--<link rel="stylesheet" href="<%=basePath%>/css/background/user/Flowing.css">-->
    <link rel="stylesheet" href="<%=basePath%>/css/background/user/department.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/responsible.js"></script>-->
    <script src="<%=basePath%>/js/background/user/Flowing.js"></script>
</head>
<body>
<div id="choice1" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        <!--福建省广电智能系统集成工贸有限公司-->
        广电智能
    </p>
    <ul class="yiji-no1">
        <li class="co1" style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name1" style="display: none">
                <li>
                    <a class="upload1" href="">
                        <span class="name-block1"></span>
                        <span class="name-none1" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close1">
        <a class="close-in" href="">返回</a>
    </div>
</div>
<div id="choice2" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        <!--福建省广电智能系统集成工贸有限公司-->
        广电智能
    </p>
    <ul class="yiji-no2">
        <li class="co2" style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name2" style="display: none">
                <li>
                    <a class="upload" href="">
                        <span class="name-block2"></span>
                        <span class="name-none2" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close2">
        <a class="close-in" href="">返回</a>
    </div>
</div>
<div id="choice3" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        <!--福建省广电智能系统集成工贸有限公司-->
        广电智能
    </p>
    <ul class="yiji-no3">

    </ul>
    <div id="close3">
        <a class="close-in" href="">返回</a>
    </div>
</div>
<div id="choice4" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        <!--福建省广电智能系统集成工贸有限公司-->
        广电智能
    </p>
    <ul class="yiji-no4">

    </ul>
    <div id="close4">
        <a class="close-in" href="">返回</a>
    </div>
</div>
<div id="choice5" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        <!--福建省广电智能系统集成工贸有限公司-->
        广电智能
    </p>
    <ul class="yiji-no5">
    </ul>
    <div id="close5">
        <a class="close-in" href="">返回</a>
    </div>
</div>
<div id="choice6" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        <!--福建省广电智能系统集成工贸有限公司-->
        广电智能
    </p>
    <ul class="yiji-no6">

    </ul>
    <div id="close6">
        <a class="close-in" href="">返回</a>
    </div>
</div>


<div id="content-in">
    <div id="center">
        <table border="1">
            <tr style="height: 40px ;background-color: #efefef">
                <td colspan="4" style="text-align: center;width: 800px ">
                    <b>流程管理</b>
                </td>
            </tr>
        </table>
        <div >
            <div style="width: 400px;height: 400px ;overflow: auto;display: inline-block;float: left">
                <span style="margin-left: auto;margin-right: auto;font-size: 24px;text-align: center;width: 100% ;display: block">模块</span>
                <ul id="second">

                </ul>
            </div>
            <div style="width:300px ;display: inline-block;height: 500px ;float: left">
                <span style="float: left;margin-left: auto;display: block;width: 100%;text-align: center;font-size: 24px ">流程</span>
                <ul id="fun" style="display: none">
                    <li class="second">
                        <span>盖章申请管</span>
                    </li>
                    <li>
                        <span>商务部审核</span>
                    </li>
                    <li>
                        <span>信息中心复核</span>
                    </li>
                    <li>
                        <span>分公司总经理审准</span>
                    </li>
                    <li>
                        <span>公司分管领导审批</span>
                    </li>
                    <li>
                        <span>公司领导批准</span>
                    </li>
                    <li>
                        <span>经办盖印办理</span>
                    </li>
                </ul>
                <ul id="f" style="display: inline-block;text-align: center;margin-right: auto;margin-left:auto">

                </ul>
                <input id="content">
                <input type="submit" class="ok" id="submitted" style="margin-left: 120px " value="修改">
            </div>

        </div>


    </div>
</div>
<script>


</script>
</body>
</html>