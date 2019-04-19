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
    <title>项目详细</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/project/projectParticular.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/Approval.js"></script>
    <script src="<%=basePath%>/js/mc/top/myProject.js"></script>

</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <!---->
    <div id="choice" style="display: none">
        <p class="title">
            <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
            福建省广电智能系统集成工贸有限公司
        </p>
        <ul class="yiji-no">
            <li style="display:none;">
                <a href="#" class="click"></a>
                <ul class="name" style="display: none">
                    <li>
                        <a class="upload" href="">
                            <span class="name-block"></span>
                            <span class="name-none" style="display: none"></span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <div id="close">
            <a class="close-in" href="">返回</a>
        </div>
    </div>

    <a class="page-left ">项目详细</a>
</div>
<!---->
<div id="content-in">
    <div id="center">
        <!--<table border="1" >-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td colspan="4" style="text-align: center">&ndash;&gt;-->
        <!--&lt;!&ndash;<b>项目详细</b>&ndash;&gt;-->
        <!--&lt;!&ndash;</td>&ndash;&gt;-->

        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td style="width:150px ">项目编号：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td style="width:300px "></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td style="width:150px ">项目简称：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td style="width:300px "></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目名称：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td colspan="3"></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目负责人：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目地点：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目类别：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目立项时间：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目阶段：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目预算金额：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目招标方式：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>预计项目投标时间：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目单位名称：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目合作方式：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>合作单位：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>合作伙伴姓名：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>职务：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>联系方式：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目查看者：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td colspan="3"></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>批注领导：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td colspan="3"></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>项目描述：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td colspan="3"></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>附件文档：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td colspan="3"></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<tr >&ndash;&gt;-->
        <!--&lt;!&ndash;<td>审批结果：</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td colspan="3">&ndash;&gt;-->
        <!--&lt;!&ndash;<span></span>&ndash;&gt;-->
        <!--&lt;!&ndash;<span></span>&ndash;&gt;-->
        <!--&lt;!&ndash;<span></span>&ndash;&gt;-->
        <!--&lt;!&ndash;<span></span>&ndash;&gt;-->
        <!--&lt;!&ndash;</td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->

        <!--</table>-->
        <!--<table class="approval " >-->
        <!--<tr style="height: 40px " >-->
        <!--<td colspan="4" style="text-align: center;width: 900px ">-->
        <!--<b>审批流程</b>-->
        <!--</td>-->
        <!--</tr>-->
        <!--<tr style="text-align: center;background-color: #0099ff">-->
        <!--<td style="width: 250px  ">名称</td>-->
        <!--<td style="width: 250px  ">时间</td>-->
        <!--<td style="width: 200px  ">审批意见</td>-->
        <!--<td style="width: 200px  ">审核状态</td>-->
        <!--</tr>-->

        <!--</table>-->
        <form id="Approval">

        </form>
        <input id="ok" type="submit" value="保存" style="margin-left: 350px ">
        <a href="" id="no" style="margin-left: 15px ">返回</a>
    </div>

</div>
</body>
</html>