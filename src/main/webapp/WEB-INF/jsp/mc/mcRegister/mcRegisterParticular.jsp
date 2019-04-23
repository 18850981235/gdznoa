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
    <title>注册备案管理详情</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcRegister/mcRegisterAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/mc/mcRegister/mcRegisterParticular.js"></script>

</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        福建省广电智能系统集成工贸有限公司
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
<div id="page">
    <a class="page-left ">注册备案管理详情</a>
</div>
<div id="content-in">
    <div id="center">
        <%--<form>--%>
            <%--<!--<table border="1">-->--%>
            <%--<!--<tr style="height: 40px ;background-color: #efefef">-->--%>
            <%--<!--<td colspan="4" style="text-align: center">-->--%>
            <%--<!--<b>注册备案管理详情</b>-->--%>
            <%--<!--</td>-->--%>
            <%--<!--</tr>-->--%>
            <%--<!--<tr style="height:40px;">-->--%>
            <%--<!--<td style="width:150px ;background-color: #efefef;">备案名称</td>-->--%>
            <%--<!--<td colspan="3"></td>-->--%>
            <%--<!--</tr>-->--%>
            <%--<!--<tr style="height:40px;">-->--%>
            <%--<!--<td style="width:150px ;background-color: #efefef;">-->--%>
            <%--<!--<span>申请部门:</span>-->--%>
            <%--<!--</td>-->--%>
            <%--<!--<td style="width:300px ;">-->--%>
            <%--<!--</td>-->--%>
            <%--<!--<td style="width:150px ;;background-color: #efefef">申请日期:</td>-->--%>
            <%--<!--<td style="width:300px ;">-->--%>

            <%--<!--</td>-->--%>
            <%--<!--</tr>-->--%>
            <%--<!--<tr  style="height:40px;">-->--%>
            <%--<!--<td style="width:150px ;background-color: #efefef;">负责人:</td>-->--%>
            <%--<!--<td >-->--%>

            <%--<!--</td>-->--%>
            <%--<!--<td style="width:150px ;background-color: #efefef;">注册备案类型:</td>-->--%>
            <%--<!--<td style="width:300px ;">-->--%>

            <%--<!--</td>-->--%>
            <%--<!--</tr>-->--%>
            <%--<!--&lt;!&ndash;<tr style="height:40px;">&ndash;&gt;-->--%>
            <%--<!--&lt;!&ndash;<td style="width:150px ;background-color: #efefef;">商务部按标准核定费用:</td>&ndash;&gt;-->--%>
            <%--<!--&lt;!&ndash;<td ><input style="width: 300px "name="" ></td>&ndash;&gt;-->--%>
            <%--<!--&lt;!&ndash;<td style="width:150px ;background-color: #efefef;">管理负责人审批金额:</td>&ndash;&gt;-->--%>
            <%--<!--&lt;!&ndash;<td ><input style="width: 300px " name=""></td>&ndash;&gt;-->--%>
            <%--<!--&lt;!&ndash;</tr>&ndash;&gt;-->--%>
            <%--<!--<tr style="height:40px;">-->--%>
            <%--<!--<td style="width:150px ;background-color: #efefef;">注册备案状态</td>-->--%>
            <%--<!--<td colspan="3">-->--%>

            <%--<!--</td>-->--%>
            <%--<!--</tr>-->--%>
            <%--<!--<tr style="height:40px;">-->--%>
            <%--<!--<td style="width:150px ;background-color: #efefef;">附件</td>-->--%>
            <%--<!--<td colspan="3"><input type="file"  style="width: 700px " name="accessory"></td>-->--%>
            <%--<!--</tr>-->--%>

            <%--<!--</table>-->--%>

            <%--<a href="#" id="no" style="color: #333;margin-left: 450px ">返回</a>--%>
        <%--</form>--%>
    </div>
</div>
</body>
</html>


