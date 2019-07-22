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
    <title>人员派遣查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcDispatch/mcDispatchList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/projectName.js"></script>
    <script src="<%=basePath%>/js/mc/mcDispatch/mcDispatchList.js"></script>
</head>
<body>


<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>项目名称</span>
                    <select class="projectname" style="width:250px;height: 30px " name="projectid" required>
                        <option value="">请选择</option>
                    </select>
                </div>
                <div class="top2">
                    <span>申请部门</span>
                    <select class="department" style="width: 100px;height: 30px;   " name="deptid" required>
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>派遣人员情况</span>
                    <input class="personnelCondition">
                </div>
                <div class="in2">
                    <span>出差时间</span>
                    <input style="float: left" type="text" class="demo-input start" placeholder="请选择日期" id="test1" name="start">
                    <span style="width:10px ;">-</span>
                    <input  type="text" class="demo-input end" placeholder="请选择日期" id="test2" name="end">
                </div>
            </div>
            <div class="query-button">
                <a href="/mc/dispatched/add" class="add">新建</a>
                <input value="快速查询"  type="submit" class="query"/>

            </div>
        </div>
        <div class="paging">
            <table   style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 60px ">序号</td>
                    <td style="width: 250px ">项目名称</td>
                    <td style="width: 100px ">申请部门</td>
                    <td style="width: 100px ">申请人</td>
                    <td style="width: 200px ">派遣人员情况</td>
                    <td style="width: 100px ">实际出差时间</td>
                    <td style="width: 130px ">人员费用结算</td>
                    <td style="width: 110px ">差旅费用结算</td>
                    <td style="width: 130px ">操作</td>
                </tr>
            </table>
            <table class="sea2"  style="text-align: center">

            </table>
        </div>
        <div id="paginator-test" style="height: 60px "></div>
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