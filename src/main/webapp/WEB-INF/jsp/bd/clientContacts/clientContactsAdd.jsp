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
    <title>新建联系人</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/customerStaff/customerStaffAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/customer.js"></script>
</head>
<body>

<div id="new" >
    <div id="center">
        <form action="/bd/client_contacts/add.html" method="post">
            <table border="1">
                <tr style="height: 45px ;text-align: center">
                    <td colspan="4" style="width:500px;background-color: #efefef">联系人基本信息</td>
                </tr>
                <tr>
                    <td style="height: 50px;background-color: #efefef">客户单位：</td>
                    <td colspan="3">
                        <select class="customer" required style="width:200px ;height: 25px  "  name="clientid" required>
                            <option value="">请选择</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="height: 50px;background-color: #efefef ">姓名：</td>
                    <td ><input required  name="name" required></td>
                    <td style="background-color: #efefef">职务：</td>
                    <td><input required  name="role" required> </td>
                </tr>
                <tr>
                    <td style="height: 50px;background-color: #efefef ">联络电话：</td>
                    <td ><input name="mobile"></td>
                    <td style="background-color: #efefef">手机：</td>
                    <td><input required name="phone" required></td>
                </tr>
                <tr>
                    <td style="height: 50px;background-color: #efefef ">微信号：</td>
                    <td ><input required name="wechat"></td>
                    <td style="background-color: #efefef">EMAIL：</td>
                    <td><input required  name="email"></td>
                </tr>
                <tr>
                    <td style="height: 50px;background-color: #efefef ">负责工作内容：</td>
                    <td colspan="3"><textarea required style="width:350px ; border: 0px solid" name="content"></textarea></td>
                </tr>
            </table>
            <input id="ok" type="submit" value="确定"  style="margin-left: 180px ">
            <a id="no"  href="/bd/client_contacts/query">返回</a>
        </form>
    </div>

</div>
</body>
</html>