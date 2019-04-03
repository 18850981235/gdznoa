<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/27
  Time: 16:02
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
    <title>项目立项</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-project-approval.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/jump.js"></script>
    <script src="<%=basePath%>/js/jump-no.js"></script>
    <script src="<%=basePath%>/js/jump-project-approval.js"></script>
</head>
<body>

<jsp:include page="../../in-topleft.jsp"/>


<div id="page">

    <!---->
    <a class="page-left ">项目立项</a>
</div>
<!---->
<div id="content-in" >
    <table border="1">
        <tr style="height:46px ">
            <td style="width: 109px  ">
                <span>项目立项时间：</span>
            </td>
            <td colspan="2" style="width: 250px ">
                <input type="date" class="time-x">
                <span>至</span>
                <input type="date" class="time-d">
                <%--<input  style="display:none;" class="time-z">--%>
            </td>
            <td style="width:200px ;">
                <span>项目类型：</span>
            </td>
            <td colspan="2"style="width:248px ;" >
                <select class="name1" style="height: 25px ">
                    <option value="">请选择</option>
                    <option value="政府公建项目">政府公建项目</option>
                    <option value="国有企业项目" >国有企业项目</option>
                    <option value="民营企业项目">民营企业项目</option>
                    <option value="地产类项">地产类项目</option>
                    <option value="政府BT型项目">政府BT型项目</option>
                    <option value="国企BT型项目">国企BT型项目</option>
                    <option value="其他类型项目">其他类型项目</option>
                </select>
            </td>
        </tr>
        <tr style="height:46px">
            <td style="">
                <span>项目编号：</span>
            </td>
            <td style="width: 251px ">
                <input class="name2">
            </td>
            <td  style="width: 200px ">
                <span>项目名称：	</span>
            </td>
            <td >
                <input class="name3">
            </td>
            <td>
                <span>状态</span>
            </td>
            <td>
                <select class="name4" style="height: 25px ">
                    <option value="">请选择</option>
                    <option value="进行中">进行中</option>
                    <option value="已结束">已结束</option>
                    <option value="不通过">不通过</option>
                </select>
            </td>
        </tr>
        <tr style="height:46px  ">
            <td colspan="6" style="width: 1210px ">
                <input value="筛选"  type="submit" class="query"/>
                <input value="项目立项"  type="button" class="reset">
            </td>
        </tr>
    </table>
    <div class="paging">
        <table >
            <tr style="height: 40px" class="start">
                <td style="width: 80px"><b>选择</b></td>
                <td style="width: 300px"><b>项目编号</b></td>
                <td style="width: 300px"><b>项目名称</b></td>
                <td style="width: 100px"><b>项目负责人</b></td>
                <td style="width: 150px"><b>项目合作方式</b></td>
                <td style="width: 150px"><b>项目成立时间</b></td>
                <td style="width: 100px"><b>状态</b></td>
                <td style="width: 150px"><b>操作</b></td>
            </tr>
            <tr style="height:45px;display: none" class="content" >
                <td class="checklist" style="display: none"><input  type="checkbox"></td>
                <td class="content-in" style="display: none"></td>
                <td class="content-in" style="display: none"></td>
                <td class="content-in" style="display: none"></td>
                <td class="content-in " style="display: none"></td>
                <td class="content-in" style="display: none"></td>
                <td class="content-in" style="display: none"></td>
                <td class="content-in-on" style="display: none">
                    <a>项目变更</a>
                </td>
            </tr>
        </table>
    </div>
    <div id="paginator-test"></div>
</div>

</body>
</html>