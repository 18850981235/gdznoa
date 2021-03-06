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
    <title>商务盖章申请</title>
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
</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <a class="page-left ">商务盖章申请</a>
</div>
<div id="content-in">
    <div id="center">
        <form action="/mc/stamp/add.html" method="post"  enctype="multipart/form-data">
            <table border="1" >
                <tr style="text-align: center;height: 45px ">
                    <td colspan="4" style="width: 900px;background-color: #efefef "><b>商务盖章申请</b></td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid">
                            <option value="">
                                请选择
                            </option>
                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">
                        <span>申请日期</span>
                    </td>
                    <td style="width:300px ;">
                        <input type="date" style="width:280px " name="createtime">
                    </td>
                </tr>
                <tr style="height: 45px ">

                    <td style="width:150px ;;background-color: #efefef">
                        <span>联系电话：</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:280px " name="phone">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">
                        <span>所需相关文件份数</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:280px "name="fileNum">
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>盖章类型说明</span>
                    </td>
                    <td  colspan="3" style="width:300px ;">
                        <input style="width:700px " name="stampType">
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>盖章用途说明</span>
                    </td>
                    <td colspan="3" >
                        <input style="width:700px "name="content">
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
                        <span>收件人</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:280px " name="consignee">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">
                        <span>联系电话</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:280px " name="consigneePhone">
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style=";background-color: #efefef">添加附件：</td>
                    <td colspan="3">
                        <input type="file" name="file">
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