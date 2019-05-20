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
    <title>商务材料修改</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcMaterial/mcMaterialAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/projectName.js"></script>
    <script src="<%=basePath%>/js/mc/mcMaterial/mcMaterialPadute.js"></script>

</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <a class="page-left ">商务材料修改</a>
</div>
<div id="content-in">
    <div id="center">
        <form action="/mc/materials/update.html" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="text-align: center;height: 45px ">
                    <td colspan="4" style="width: 900px;background-color: #efefef "><b>商务材料修改</b><input style="display: none" name="id"></td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid">

                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">
                        <span>申请日期</span>
                    </td>
                    <td style="width:300px ;">
                        <input type="date" style="width:280px " name="createtime">
                    </td>
                </tr>
                <tr  style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>提供方式</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department1"  style="width: 100px;height: 30px " name="offerTpye">
                            <option >方式1</option>
                            <option >提供方式</option>
                            <option >方式2</option>
                        </select>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>项目名</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="projectname" style="width:200px;height: 30px " name="projectid">

                        </select>
                    </td>


                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>收件人电话</span>
                    </td>
                    <td  >
                        <input style="width:280px "name="consigneePhone">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>收件人</span>
                    </td>
                    <td style="width:300px ;">
                        <input  style="width:280px " name="consignee" >
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>收件地址</span>
                    </td>
                    <td colspan="3" >
                        <input style="width:700px "name="consigneeAddress">
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请商务资料的内容及要求</span>
                    </td>
                    <td colspan="3" >
                        <input style="width:700px "name="content">
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>资料用途说明</span>
                    </td>
                    <td colspan="3" >
                        <input style="width:700px "name="purpose">
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>附件</span>
                    </td>
                    <td colspan="3" >
                        <input type="file" style="width:700px "name="file">
                    </td>
                </tr>

            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="#" id="no" style="color: #333">取消</a>
        </form>
    </div>
</div>
</body>
</html>