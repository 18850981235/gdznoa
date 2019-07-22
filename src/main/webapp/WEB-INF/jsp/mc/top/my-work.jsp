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
    <title>我的工作</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/top/my-work.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/mc/top/my-work-1.js"></script>
    <script src="<%=basePath%>/js/mc/top/my-work.js"></script>
</head>
<body>

<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>流程类型</span>
                    <select class="department" style="width: 200px;height: 30px ">
                        <option value="0">请选择</option>
                    </select>
                </div>
                <div class="top2">
                    <span>流水号</span>
                    <input class="stampType">
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>接受时间</span>
                    <input type="text"  placeholder="请选择日期" id="test1" style="width: 110px;display: inline-block;float: left " class="start">
                    <span style="width: 20px ">-</span>
                    <input type="text"  placeholder="请选择日期" id="test2" style="width: 110px;display: inline-block " class="end" >
                </div>
            </div>
            <div class="query-button">
                <input value="快速查询" type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 160px ">流水号</td>
                    <td style="width: 450px ">流程类型</td>
                    <td style="width: 200px ">发起人</td>
                    <td style="width: 200px ">接收时间</td>
                    <td style="width: 110px ">操作</td>
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
</script>
</body>
</html>