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
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcStamp/mcStampAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/projectName.js"></script>
    <script src="<%=basePath%>/js/mc/mcCost/mcCostPadute.js"></script>
</head>
<body>

<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
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

<div id="content-in">
    <div id="center">
        <form action="/mc/datum/update.html" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>资料费管理修改</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">项目名:</td>
                    <td colspan="3">
                        <select class="projectname" style="width: 500px ;height: 35px " name="projectid" required></select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门:</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid" required>
                        </select>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">项目预算:</td>
                    <td style="width:300px ;">
                        <input  style="width:280px " name="budget">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">项目负责人:</td>
                    <td >
                        <input class="Eliminate" readonly >
                        <input style="display: none" class="Eliminate-no" name="userid" required>
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">申请日期:</td>
                    <td style="width:300px ;">
                        <input type="text" class="demo-input" placeholder="请选择日期" id="test1" style="width:280px "  name="createtime">
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
                    <td colspan="3"><input type="file"  style="width: 700px " name="file"></td>
                </tr>

            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/datum/query"id="no"  >取消</a>
        </form>
    </div>
</div>
<script type="text/javascript">
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });

</script>
</body>
</html>