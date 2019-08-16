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
    <title>注册备案管理申请</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcRegister/mcRegisterAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/mc/mcRegister/mcRegisterAdd.js"></script>
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
<div id="choice5" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no5">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name" style="display: none">
                <li class="co5">
                    <a class="upload5" href="">
                        <span class="name-block5"></span>
                        <span class="name-none5" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close5">
        <a class="close-in" >返回</a >
    </div>
</div>

<div id="content-in">
    <div id="center">
        <form  action="/mc/register/addImpl" method="post"  enctype="multipart/form-data">
            <table border="1">

                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>注册备案管理申请</b>
                    </td>
                </tr>

                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门(*)</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid" required>
                            <option value="">
                                请选择
                            </option>
                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">申请日期(*)</td>
                    <td style="width:300px ;">

                        <input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test1"name="createtime">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td     style="width:150px;background-color: #efefef  ">申请人</td>
                    <td >
                        <input class="" readonly  >
                        <input class="" style="display: none"  name="principal" required>
                    </td>
                    <td   style="width:150px ;background-color: #efefef ">联系电话</td>
                    <td style="width:300px ;">
                        <input style="width:280px " name="phone">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">备案名称(*)</td>
                    <td colspan="3"><input   style="width: 700px " name="recordsName"></td>
                </tr>
                <tr  style="height:40px;">
                    <td     style="width:150px;background-color: #efefef  ">注册备案类型</td>
                    <td >
                        <select class="recordsType" style="height: 30px ;margin-top: 4px  " name="recordsType">
                            <option value="">请选择</option>
                            <option>入省备案</option>
                            <option>采购投标CA</option>
                            <option>工程投标CA</option>
                            <option>其他</option>
                        </select>
                    </td>
                    <td   style="width:150px;background-color: #efefef">管理人员(*) </td>
                    <td style="width:300px ;">
                        <input class="Eliminate-5" readonly>
                        <input style="display: none" class="Eliminate-no-5" name="manager" required>
                        <a target="_blank " class="add-to5">添加</a>
                        <a class="clear-to5" >
                            <input value="清空" class="input5"  onClick="" type="button">
                        </a>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">所需资料及条件</td>
                    <td colspan="3"><input   style="width: 700px " name="dataConditions"></td>
                </tr>
                <tr  style="height:40px;">
                    <td     style="width:150px;background-color: #efefef  ">注册备案状态</td>
                    <td >
                        <select class="recordsType" style="width: 100px;height:30px;margin-top: 4px  " name="recordsState">
                            <option value="">请选择</option>
                            <option>正常</option>
                            <option>年审</option>
                            <option>超期</option>
                        </select>
                    </td>
                    <td   style="width:150px;background-color: #efefef">CA借用情况 </td>
                    <td style="width:300px ;">
                        <select class="recordsType" style="width: 100px ;height:30px;margin-top: 4px  " name="caBorrow" required>
                            <option value="">请选择</option>
                            <option>借出</option>
                            <option>未借</option>
                        </select>
                    </td>
                </tr>

                <tr  style="height:40px;">
                    <td     style="width:150px;background-color: #efefef  ">年审负责人(*)</td>
                    <td >
                        <input class="Eliminate" readonly>
                        <input style="display: none" class="Eliminate-no" name="annualPrincipal" required>
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>

                    <td   style="width:150px;background-color: #efefef">年审时间(*)</td>
                    <td style="width:300px ;">
                        <input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test2"name="annualTime">
                    </td>
                </tr>
            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/register/query" id="no"  >取消</a>
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


