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
    <title>注册备案管理查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcRegister/mcRegisterList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/mc/mcRegister/mcRegisterList.js"></script>
</head>
<body>

<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>申请部门</span>
                    <select class="department" style="width: 100px;height: 30px " name="deptid" required>
                        <option value="">请选择</option>
                    </select>
                </div>
                <div class="top2">
                    <span>申请时间</span>
                    <input style="float: left " type="text" class="demo-input startTime" placeholder="请选择日期" id="test1" >
                    <span style="width:20px ;">-</span>
                    <input  type="text" class="demo-input endTime" placeholder="请选择日期" id="test2" >

                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>注册备案名称</span>
                    <input class="recordsName" name="recordsName">
                </div>
                <div class="in2">
                    <span>注册备案类型</span>
                    <select class="recordsType"  style="height: 30px ;margin-top: 4px  " name="recordsType">
                        <option value="">请选择</option>
                        <option>入省备案</option>
                        <option>采购投标CA</option>
                        <option>工程投标CA</option>
                        <option>其他</option>
                    </select>
                </div>
            </div>
            <div class="query-button">
                <a  href="/mc/register/add" class="add">新增</a>
                <input value="快速查询"  type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table   style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 60px ">序号</td>
                    <td style="width: 300px ">注册备案名称</td>
                    <td style="width: 150px ">申请日期</td>
                    <td style="width: 100px ">负责人</td>
                    <td style="width: 150px ">注册备案类型</td>
                    <td style="width: 100px ">注册备案状态</td>
                    <td style="width: 150px ">CA借用情况</td>
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


