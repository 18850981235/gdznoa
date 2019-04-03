<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户管理系统</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/customer-manage.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jump.js"></script>
    <script src="<%=basePath%>/js/customer-manage.js"></script>
    <script src="<%=basePath%>/js/jump-no.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
</head>
<body>
<input name="error" value="${error}">
<jsp:include page="../../in-topleft.jsp"/>
<jsp:include page="../../selectUser.jsp"/>
    <a>
        <img src="<%=basePath%>/imgs/icon1.png" height="25" width="25"/>
        <p>首页</p>
    </a>
    <a>
        <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
        <p>我的工作</p>
    </a>

    <a class="top-right">
        <img src="<%=basePath%>/imgs/20160602111922932.png" height="25" width="25"/>
        <p>用户管理</p>
    </a>
    <a style="float: right">
        <p>${user.name}</p>
        <P>${user.company}</P>
    </a>
    <div class="day-time">
        <input id="day">
        <input id="daytime">
    </div>
    <input id="time">
    <div id="weather">
        <p></p>
        <span></span>
        <p class="comment"></p>
    </div>
</div>

<div id="page">
    <a class="page-left ">客户管理</a>
</div>
<!--客户-->
<div id="content-in" >
    <table   border="1">
        <tr style="height:46px  ">
            <td style="width:150px "><span>客户名称：</span></td>
            <td  style="width:300px"><input class="name" ></td>
            <td style="width:160px"><span>所在地区：	</span></td>
            <td style="width:600px" colspan="3">
                <select class="name1" style="height: 25px ">
                </select>
            </td>
        </tr>
        <tr style="height:46px  ">
            <td style="width:150px "><span>单位类型：	</span></td>
            <td style="width:300px">
                <select class="name2" style="height: 25px ">
                    <option value="">请选择</option>
                    <option value="政府">政府</option>
                    <option value="国有企业" >国有企业</option>
                    <option value="事业单位">事业单位</option>
                    <option value="外资企业">外资企业</option>
                    <option value="民营企业">民营企业</option>
                </select>
            </td>
            <td style="width:160px"><span>业务负责人：	</span></td>
            <td colspan="3" >
                <textarea class="Eliminate" readonly></textarea>
                <input class="Eliminate-no" style="display: none">
                <a target="_blank" class="add-to" >添加</a>
                <a class="clear-to" >
                    <input value="清空"  onClick="" type="reset">
                </a>
            </td>
        </tr>
        <tr style="height:46px  ">
            <td colspan="6">
                <input value="快速查询"  type="submit" class="query" onclick="lo()"/>
                <input value="重置"  type="submit" class="reset">
            </td>
        </tr>
    </table>
    <div class="paging">
        <table>
            <tr style="height: 40px" class="start">
                <td style="width: 100px"><b>选择</b></td>
                <td style="width: 300px"><b>客户名称</b></td>
                <td style="width: 130px"><b>单位类型</b></td>
                <td style="width: 130px"><b>所在地区</b></td>
                <td style="width: 200px"><b>所属部门</b></td>
                <td style="width: 200px"><b>业务负责人</b></td>
                <td style="width: 150px"><b>操作</b></td>
            </tr>
        </table>
        <table class="paging-in">

            <%--<tr style="height:45px;display: none" class="content" >--%>
                <%--<td  class="checklist" style="width: 100px"><input  type="checkbox"></td>--%>
                <%--<td class="content-in" style="width: 300px"></td>--%>
                <%--<td class="content-in" style="width: 130px"></td>--%>
                <%--<td class="content-in" style="width: 130px"></td>--%>
                <%--<td class="content-in " style="width: 200px"></td>--%>
                <%--<td class="content-in" style="width: 200px"></td>--%>
                <%--<td class="content-in-on" style="width: 150px">--%>
                    <%--<a>编辑</a>--%>
                    <%--<a>删除</a>--%>
                <%--</td>--%>
            <%--</tr>--%>
        </table>

    </div>
    <div id="paginator-test"></div>
</div>

</body>
</html>
