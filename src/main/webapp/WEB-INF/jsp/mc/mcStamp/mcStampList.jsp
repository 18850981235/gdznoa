<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 14:09
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
    <title>商务盖章查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layuiAdmin.std-v1.0.0/src/layuiadmin/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcStamp/mcStampList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layuiAdmin.std-v1.0.0/src/layuiadmin/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/mc/mcStamp/mcStampList.js"></script>
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
                <li>
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
                    <span>项目简称</span>
                    <input class="projectName">
                </div>
                <div class="top2">
                    <span>用章类型</span>
                    <input class="stampType">
                </div>
                <div class="top3">
                    <span>申请部门</span>
                    <select class="deptid department" style="width: 100px;height: 30px " name="" >
                        <option value="">
                            请选择
                        </option>
                    </select>
                </div>

            </div>
            <div class="query-in">
                <div class="in1">
                    <span>盖章内容</span>
                    <input class="contents">
                </div>
                <div class="in2">
                    <span>盖章用途</span>
                    <input class="purpose">
                </div>
                <div class="in3">
                    <span>申请日期</span>
                    <input type="text"  placeholder="请选择日期" id="test1" class="start">
                    <span style="width:40px ;">-</span>
                    <input type="text"  placeholder="请选择日期" id="test2" class="end">
                </div>
            </div>
            <div class="query-button">
                <a href="/mc/stamp/add"  class="add">新建</a>
                <input value="快速查询"  type="submit" class="query"/>

            </div>
        </div>
        <div class="paging">
            <table   style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 60px ">序号</td>
                    <td style="width: 150px ">项目名称</td>
                    <td style="width: 70px ">申请部门</td>
                    <td style="width: 80px ">申请人</td>
                    <td style="width: 100px ">申请日期</td>
                    <td style="width: 100px ">用章类型</td>
                    <td style="width: 200px ">盖章用途</td>
                    <td style="width: 250px ">附件名称</td>
                    <td style="width: 110px ">操作</td>
                </tr>
            </table>

        </div>
        <div id="paginator-test" ></div>

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
