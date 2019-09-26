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
    <title>供应商人员新增</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/supplier/contacts/contactsAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/responsible.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/projectName.js"></script>-->
    <!--<script src="<%=basePath%>/js/mc/mcDispatch/mcDispatchAdd.js"></script>-->
    <script src="<%=basePath%>/js/public/pipelineNumber.js"></script>
    <script src="<%=basePath%>/js/supplier/contacts/contactsAdd.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form  >
            <table border="1" style="width: 1200px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>供应商人员新增</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">供应商名称</td>
                    <td colspan="3"  style="width:700px ;">
                        <select class="contacts" style="width: 500px;height: 30px  ">
                            <option>请选择</option>
                        </select>
                    </td>

                </tr>
            </table>
            <table border="0" style="width:1200px ;text-align: center">
                <tr style="height: 40px ;background-color:#c4de83 ">
                    <td style="width: 100px  ">名称</td>
                    <td style="width: 100px  ">职务</td>
                    <td style="width: 150px  ">手机</td>
                    <td style="width: 150px  ">传真</td>
                    <td style="width: 200px  ">办公地址</td>
                    <td style="width: 150px  ">邮箱</td>
                    <td style="width: 150px  ">微信</td>
                    <td style="width: 200px  ">工作内容</td>
                </tr>
            </table>
            <table id="con" border="1" style="text-align: center">
                <tr style="height: 40px ;display:none; ">
                    <td style="width: 100px  ">name</td>
                    <td style="width: 100px  ">role</td>
                    <td style="width: 150px  ">phone</td>
                    <td style="width: 150px  ">fax</td>
                    <td style="width: 200px  ">address</td>
                    <td style="width: 150px  ">email</td>
                    <td style="width: 150px  ">wechat</td>
                    <td style="width: 200px  ">jobContent</td>
                </tr>
                <tr style="height: 40px ; ">
                    <td style="width: 100px  ">
                        <input style="width:95px;text-align: center" name="name">
                    </td>
                    <td style="width: 100px  ">
                        <input style="width:95px;text-align: center" name="role">
                    </td>
                    <td style="width: 150px  ">
                        <input style="width:145px;text-align: center" name="phone">
                    </td>
                    <td style="width: 150px  ">
                        <input style="width:145px;text-align: center" name="fax">
                    </td>
                    <td style="width: 200px  ">
                        <input style="width:195px;text-align: center" name="address">
                    </td>
                    <td style="width: 150px  ">
                        <input style="width:145px;text-align: center" name="email">
                    </td>
                    <td style="width: 150px  ">
                        <input style="width:145px;text-align: center" name="wechat">
                    </td>
                    <td style="width: 200px  ">
                        <input style="width:195px;text-align: center" name="jobContent">
                    </td>
                </tr>
            </table>
            <div style="display: block;height: 30px ;text-align: center;padding-top: 6px ">
                <span id="add">添加</span>
                <span id="remove">删除</span>
            </div>
            <!--<tr style="height: 40px ; "><td style="width: 100px  "><input style="width:95px;text-align: center" name="name"></td><td style="width: 100px  "><input style="width:95px;text-align: center" name="role"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="phone"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="fax"></td><td style="width: 200px  "><input style="width:195px;text-align: center" name="address"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="email"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="wechat"></td><td style="width: 200px  "><input style="width:145px;text-align: center" name="jobContent"></td></tr>-->
            <input id="ok"    value="确定" style="margin-left:520px ">
            <a href="/supplier/supplier_staff/query" id="no"  >取消</a>
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