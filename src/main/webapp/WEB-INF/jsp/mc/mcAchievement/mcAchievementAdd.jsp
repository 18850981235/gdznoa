<%--
  Created by IntelliJ IDEA.
  User: lpy
  Date: 2019/1/9
  Time: 15:18
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
    <title>业绩资料新增</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcAchievement/mcAchievementAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>

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
        <form  action="/mc/performanceDate/addPerformanceDate" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>业绩资料申请</b>
                        <input style="display:none;">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>项目名称(*)</span>
                    </td>
                    <td  style="width:300px ;">
                        <select id="ap" style="height: 30px " name="projectId">
                            <option>请选择</option>
                        </select>
                    </td>

                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">中标通知书</td>
                    <td style="width:300px ;">
                        <input type="file"  style="width: 170px ;display: inline-block" name="didFile">
                        <input type="text"  placeholder="请选择日期" id="test1" style="width: 80px;display: inline-block " name="biddingTime" >
                    </td>
                    <td style="width:150px ;background-color: #efefef;">业绩合同</td>
                    <td >
                        <input type="file"  style="width: 170px ;display: inline-block" name="performanceFile">
                        <input type="text"  placeholder="请选择日期" id="test2" style="width: 80px;display: inline-block " name="signingTime">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px;background-color: #efefef">验收报告</td>
                    <td style="width:300px">
                        <input type="file"  style="width: 170px ;display: inline-block" name="acceptanceFile">
                        <input type="text"  placeholder="请选择日期" id="test3" style="width: 80px;display: inline-block "name="acceptanceTime" >
                    </td>
                    <td style="width:150px ;background-color: #efefef;">维保证明</td>
                    <td >
                        <input type="file"  style="width: 170px ;display: inline-block" name="maintenanceFile">
                        <input type="text"  placeholder="请选择日期" id="test4" style="width: 80px;display: inline-block " name="maintenanceTime">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px;background-color: #efefef">中标公示网址</td>
                    <td style="width:300px;">
                        <input    style="width: 270px ;display: inline-block" name="publicAddress">
                    </td>
                    <td style="width:150px;background-color: #efefef;">中标公示截图</td>
                    <td >
                        <input type="file"  style="width: 270px ;display: inline-block" name="ImpFile">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px;background-color: #efefef">资料借用情况</td>
                    <td   style="width:300px ;">
                        <input    style="width: 270px ;display: inline-block" name="borrowStada">
                    </td>
                    <td style="width:150px;background-color: #efefef">PDF导出</td>
                    <td  style="width:300px ;">
                        <input type="file"   style="width: 270px ;display: inline-block" name="pdfout">

                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px;background-color: #efefef  ">年审负责人(*)</td>
                    <td >
                        <input class="Eliminate" readonly>
                        <input style="display: none" class="Eliminate-no" name="managerId"required>
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">资料归档时间</td>
                    <td >
                        <input type="text"  placeholder="请选择日期" id="test5" style="width: 80px;display: inline-block " name="filingTime">
                    </td>
                </tr>
            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/performanceDate/query" id="no" >取消</a>
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
    laydate.render({
        elem: '#test3', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test4', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test5', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    $(document).ready(function () {

        $.ajax({
            type:"post",
            dataType:"json",
            url:"/util/getGCProject",
            success:function (data) {
                $.each(data,function (index,obj) {
                    var html="";

                    html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

                    $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                })
            }
        })
    });
</script>
</body>
</html>


