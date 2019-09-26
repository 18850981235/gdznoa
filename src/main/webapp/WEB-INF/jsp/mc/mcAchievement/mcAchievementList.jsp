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
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcAchievement/mcAchievementList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/mc/mcAchievement/mcAchievementList.js"></script>

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
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>项目名称</span>
                    <input class="projectName" name="projectName">
                </div>
                <div class="top2">
                    <span>签约时间</span>
                    <input type="text" style="float: left" placeholder="请选择日期" id="test1" class="bidTimeStart" >
                    <span style="width:25px ;">-</span>
                    <input type="text" placeholder="请选择日期" id="test2" class="bidTimeEnd" >
                </div>"
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>验收时间</span>
                    <input type="text" placeholder="请选择日期" id="test3" class="acceTimeStart"  >
                    <span style="width:25px ;">-</span>
                    <input type="text" placeholder="请选择日期" id="test4" class="accTimeEnd"  >
                </div>
                <div class="in2">
                    <span>借用情况</span>
                    <input class="borrow" name="borrow">
                </div>
            </div>
            <div class="query-button">
                <a href="/mc/performanceDate/addPerformanceDatePage" class="add">新增</a>
                <input value="快速查询" type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 120px ">序号</td>
                    <td style="width: 200px ">项目名称</td>
                    <td style="width: 130px ">中标时间</td>
                    <td style="width: 140px ">签约时间</td>
                    <td style="width: 140px ">验收时间</td>
                    <td style="width: 130px ">资料借用情况</td>
                    <td style="width: 150px ">导出记录</td>
                    <td style="width: 130px ">操作</td>
                </tr>
            </table>
            <table class="sea2" style="text-align: center">

            </table>
        </div>
        <div id="paginator-test"></div>
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

</script>
</body>
</html>

