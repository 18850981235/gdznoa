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
    <title>注册备案管理申请</title>
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
    <a class="page-left ">注册备案管理申请</a>
</div>
<div id="content-in">
    <div id="center">
        <form  action="/mc/register/addImpl" method="post"  enctype="multipart/form-data">
        <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>注册备案管理申请</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">备案名称</td>
                    <td colspan="3"><input   style="width: 700px " name="recordsName"></td>
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
                        <input type="date" style="width:280px "  name="createtime">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">负责人:</td>
                    <td >
                        <input class="Eliminate" readonly >
                        <input style="display: none" class="Eliminate-no" name="principal">
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">注册备案类型:</td>
                    <td style="width:300px ;">
                        <select class="recordsType" style="height: 30px ;margin-top: 4px  " name="recordsState">
                            <option value="">请选择</option>
                            <option>入省备案</option>
                            <option>采购投标CA</option>
                            <option>工程投标CA</option>
                            <option>其他</option>
                        </select>

                    </td>
                </tr>
                <!--<tr style="height:40px;">-->
                <!--<td style="width:150px ;background-color: #efefef;">商务部按标准核定费用:</td>-->
                <!--<td ><input style="width: 300px "name="" ></td>-->
                <!--<td style="width:150px ;background-color: #efefef;">管理负责人审批金额:</td>-->
                <!--<td ><input style="width: 300px " name=""></td>-->
                <!--</tr>-->
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">注册备案状态</td>
                    <td colspan="3">
                        <select  style="width: 100px;height: 30px " name="recordsType">
                            <option value="">请选择</option>
                            <option >正常</option>
                            <option >年审</option>
                            <option >超期</option>
                        </select>
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


