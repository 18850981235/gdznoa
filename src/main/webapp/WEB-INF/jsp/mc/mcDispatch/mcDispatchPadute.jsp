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
    <title>人员派遣修改</title>
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
    <script src="<%=basePath%>/js/mc/mcDispatch/mcDispatchPadute.js"></script>
</head>
<body>

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

<div id="content-in">
    <div id="center">
        <form action="/mc/dispatched/update.html" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>人员派遣修改</b>
                        <input style="display: none">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目名</td>
                    <td colspan="3" style="width:300px ;">
                        <select class="projectname" style="width:600px;height: 30px " name="projectid">

                        </select>
                    </td>


                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid" required>
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请人</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:270px ;">
                        <input style="display: none" name="userid" required>
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">申请人派遣要求</td>
                    <td colspan="3">
                        <input style="width: 700px "name="demand">
                    </td>

                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">预计出差时间</td>
                    <td ><input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test1" name="evectionTime"></td>
                    <td style="width:150px ;background-color: #efefef;">派遣人员情况</td>
                    <td ><input style="width: 300px " name="evectionCost"></td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">人员费用标准</td>
                    <td ><input style="width: 300px " name="costStandard"></td>
                    <td style="width:150px ;background-color: #efefef;">人员费用预算</td>
                    <td ><input style="width: 300px " name="evectionBudget"></td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">实际出差时间</td>
                    <td ><input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test2" name="practicalTime"></td>
                    <td style="width:150px ;background-color: #efefef;">出差情况确认</td>
                    <td ><input style="width: 300px " name="evectionCondition"></td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">人员费用结算</td>
                    <td ><input style="width: 300px " name="evectionCost"></td>
                    <td style="width:150px ;background-color: #efefef;">差旅费用结算</td>
                    <td ><input style="width: 300px " name="travelCost"></td>
                </tr>

            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/dispatched/query" id="no"  >取消</a>
        </form>
    </div>
</div>
<script type="text/javascript">
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test2', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });

</script>
</body>
</html>