<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<head>
    <meta charset="UTF-8">
    <title>客户详细信息</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/customer-see.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jump.js"></script>
    <script src="<%=basePath%>/js/jump-no.js"></script>

</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <a class="page-left ">客户详细信息</a>
</div>
<!---->
<div id="content-in">
    <table border="1">
        <tr style="height: 45px">
            <th colspan="4" style="width: 600px ">基本信息：</th>
        </tr>
        <tr >
            <td style="width:150px ;">客户名称：</td>
            <td colspan="3">${client.name}</td>
        </tr>
        <tr>
            <td>客户编号：</td>
            <td style="width:150px ;">${client.code}</td>
            <td style="width:150px ;">所属部门：</td>
            <td >${client.dept.name}</td>
        </tr>
        <tr>
            <td>单位类型：</td>
            <td>${client.unitType}</td>
            <td>业务负责人：</td>
            <td >${client.user.name}</td>
        </tr>
        <tr>
            <td>所在地区：</td>
            <td colspan="3">${client.address}</td>

        </tr>
        <tr>
            <td>电话：</td>
            <td>${client.phone}</td>
            <td>传真：</td>
            <td >${client.fax}</td>
        </tr>
        <tr>
            <td>客户业务内容：</td>
            <td colspan="3">${client.content}</td>
        </tr>
    </table>
    <table border="1">
        <tr>
            <th style="width: 600px ">客户主要人员架构</th>
        </tr>
        <tr>
            <td>
                <table border="1" style="text-align: center">
                    <tr>
                        <td style="width: 70px ">姓名</td>
                        <td style="width: 70px ">职务</td>
                        <td style="width: 100px ">手机</td>
                        <td style="width: 90px ">微信</td>
                        <td style="width: 100px ">E-mail</td>
                        <td style="width: 150px ">负责工作内容</td>

                    <c:forEach var="user" items="${client.contacts}">
                    </tr>
                        <td>${user.name}</td>
                        <td>${user.role}</td>
                        <td>${user.phone}</td>
                        <td>${user.wechat}</td>
                        <td>${user.email}</td>
                        <td>${user.content}</td>
                        </tr>
                    </c:forEach>


                </table>
            </td>
        </tr>
    </table>
    <table border="1">
        <tr>
            <th colspan="4" style="width: 600px ">开票财务信息</th>
        </tr>
        <tr>
            <td style="width:150px ;">税号:</td>
            <td style="width:150px ;">${client.tfn}</td>
            <td style="width:150px ;">开户行：</td>
            <td>${client.bankname}</td>
        </tr>
        <tr>
            <td>对公账号：</td>
            <td>${client.bankaccount}</td>
            <td>开户地址：</td>
            <td>${client.bankaddress}</td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center"><a href="/bd/client/query" >关闭</a></td>
        </tr>
    </table>
</div>
</body>
</html>
