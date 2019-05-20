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
    <title>原件借用申请</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcStamp/mcStampAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <!--<script src="<%=basePath%>/js/mc/mcStamp/mcStampList.js"></script>-->
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
    <a class="page-left ">原件借用申请</a>
</div>
<div id="content-in">
    <div id="center">
        <form  action="/mc/borrow/add.html" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>文件借用申请</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门:</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid">
                            <option value="">
                                请选择
                            </option>
                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">申请日期:</td>
                    <td style="width:300px ;">
                        <input type="date" style="width:280px " name="createtime" >
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">项目负责人:</td>
                    <td >
                        <input class="Eliminate" readonly >
                        <input style="display: none" class="Eliminate-no" name="userid">
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">联系电话:</td>
                    <td style="width:300px ;">
                        <input style="width:280px " name="phone">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">原件名称</td>
                    <td colspan="3"><input style="width: 700px " name="name"></td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">原件借用用途</td>
                    <td  ><input style="width: 280px " name="purpose"></td>
                   <td style="width:150px ;background-color: #efefef;">数量</td>
                    <td ><input style="width: 280px " name="fileNum" ></td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">原件寄往地址</td>
                    <td  colspan="3" style="width:300px ;">
                        <input  style="width:280px " name="consigneeAddress">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">收件人</td>
                    <td style="width:300px ;">
                        <input  style="width:280px "name="consignee">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">联系电话</td>
                    <td style="width:300px ;">
                        <input  style="width:280px " name="consigneePhone">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">原件归还时间</td>
                    <td style="width:300px ;" colspan="3">
                        <input  style="width:280px "   type="date" name="returntime">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">附件</td>
                    <td colspan="3"><input type="file"  style="width: 700px " name="file"></td>
                </tr>
            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="#" id="no" style="color: #333">取消</a>
        </form>
    </div>
</div>
</body>
</html>