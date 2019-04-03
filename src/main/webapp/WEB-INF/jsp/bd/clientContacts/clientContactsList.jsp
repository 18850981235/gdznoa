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
    <title>联系人管理</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/contact-manage.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jump.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/contacts-manage.js"></script>
</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
</div>

<div id="page">
    <a class="page-left ">联系人管理</a>
</div>

<div id="content-in" >
    <table   border="1">
        <tr style="height:46px">
            <td style="width:150px "><span>客户名称：</span></td>
            <td colspan="3" style="width: 1060px "><input class="name1"></td>
        </tr>
        <tr style="height:46px  ">
            <td style="width:150px "><span>联系人姓名：	</span></td>
            <td colspan="5" style="width:300px">
                <input class="name2">
            </td>
        </tr>
        <tr style="height:46px ">
            <td colspan="6">
                <input value="快速查询"  type="submit" class="query"/>
                <input value="重置"  type="submit" class="reset">
            </td>
        </tr>
    </table>
    <div class="paging">
        <table >
            <tr style="height: 40px" class="start">
                <td style="width: 100px"><b>选择</b></td>
                <td style="width: 300px"><b>客户单位</b></td>
                <td style="width: 130px"><b>姓名</b></td>
                <td style="width: 150px"><b>职务</b></td>
                <td style="width: 250px"><b>联系电话</b></td>
                <td style="width: 250px"><b>手机</b></td>
                <td style="width: 250px"><b>微信</b></td>
                <td style="width: 250px"><b>负责的工作内容</b></td>
                <td style="width: 250px"><b>EMAIL</b></td>
                <td style="width: 250px"><b>操作</b></td>
            </tr>

        </table>
    </div>
    <div id="paginator-test"></div>
</div>

</body>
</html>
