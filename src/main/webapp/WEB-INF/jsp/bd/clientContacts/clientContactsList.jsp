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
    <link rel="stylesheet" href="<%=basePath%>/css/bd/customerStaff/customerStaffList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/bd/clientContacts/clientContactsList.js"></script>

</head>
<body>

<div id="content-in" >
    <div id="center">
        <div id="query-button">
            <div class="query-top" style="height:46px  ">
                <div class="top1" >
                    <span>联系人名称：</span>
                    <input class="name1">
                </div>
                <div class="top2">
                    <span>客户单位：</span>
                    <input class="clientname">
                </div>
            </div>
            <div class="query-button">
                <a href="/bd/client_contacts/add" class="add">新增</a>
                <input value="快速查询"  type="submit" class="query"/>

            </div>
        </div>
        <div class="paging">
            <table>
                <tr style="height: 40px" class="start">
                    <td style="width: 100px"><b>序号</b></td>
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

</div>

</body>
</html>
