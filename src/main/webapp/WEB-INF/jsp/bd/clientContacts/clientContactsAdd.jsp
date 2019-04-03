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
    <link rel="stylesheet" href="<%=basePath%>/css/contact-new.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jump.js"></script>

</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <a class="page-left ">新建联系人</a>
</div>
<div id="new">
    <form action="/bd/client_contacts/add.html" method="post">
        <table border="1">
            <tr style="height: 30px ">
                <td colspan="4" style="width:500px">联系人基本信息</td>
            </tr>
            <tr>
                <td style="height: 50px ">客户单位：</td>
                <td colspan="3">
                    <select required name="clientid">
                    <option value="">请选择</option>
                    <c:forEach items="${clientName}" var="a">
                        <option value=${a.id}>${a.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td style="height: 50px ">姓名:</td>
                <td><input required name="name"></td>
                <td>职务：</td>
                <td><input required name="role"></td>
            </tr>
            <tr>
                <td style="height: 50px " >联络电话:</td>
                <td><input name="mobile"></td>
                <td>手机：</td>
                <td><input required name="phone"></td>
            </tr>
            <tr>
                <td style="height: 50px ">微信号:</td>
                <td><input required name="wechat"></td>
                <td>EMAIL：</td>
                <td><input required name="email"></td>
            </tr>
            <tr>
                <td style="height: 50px ">负责工作内容：</td>
                <td colspan="3"><input required name="content"></td>
            </tr>

            <tr style="height: 30px ">
                <td colspan="4" style="width:500px;text-align: center">
                    <input type="submit" value="确定">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>