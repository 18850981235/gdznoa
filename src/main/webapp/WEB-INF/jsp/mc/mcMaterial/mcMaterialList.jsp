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
    <title>商务材料查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcMaterial/mcMaterialList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/mc/mcMaterial/mcMaterialList.js"></script>

</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <a class="page-left ">商务盖章查询</a>
</div>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>申请部门</span>
                    <select class="department" style="width: 100px;height: 30px ">
                        <option value="">请选择</option>
                    </select>
                </div>
                <div class="top2">
                    <span>申请日期</span>
                    <input type="date" class="start">至  <input type="date" class="end">
                </div>
                <div class="top3">
                    <span>提供方式</span>
                    <select  class="offerTpye" style="width: 100px;height: 30px;margin-top: 4px  ">
                        <option value="">请选择</option>
                        <option >提供方式</option>
                        <option >方式2</option>
                        <option >方式3</option>
                    </select>
                </div>
            </div>

            <div class="query-button">
                <input value="新增" type="submit" class="add">
                <input value="快速查询"  type="submit" class="query"/>
                <input value="重置"  type="submit" class="reset">
            </div>
        </div>
        <div class="paging">
            <table  style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 60px ">序号</td>
                    <td style="width: 100px ">申请部门</td>
                    <td style="width: 100px ">申请日期</td>
                    <td style="width: 350px ">申请商务资料的内容及要求</td>
                    <td style="width: 250px ">资料用途说明</td>
                    <td style="width: 150px ">提供方式</td>
                    <td style="width: 110px ">操作</td>
                </tr>
            </table>

        </div>
        <div id="paginator-test"></div>
    </div>
</div>
</body>
</html>