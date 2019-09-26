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
    <title>供应商品牌新增</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/supplier/brand/brandAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/supplier/brand/brandAdd.js"></script>

</head>
<body>
<div id="content-in">
    <div id="center">
        <form action="/supplier/trademark/add" method="post"  enctype="multipart/form-data">
            <table border="1" style="width: 800px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>供应商品牌新增</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">系统名称</td>
                    <td   style="width:250px ;">
                        <select class="contacts" style="width: 240px;height: 30px  " name="systemName">

                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">主要产品及设备</td>
                    <td   style="width:250px ;">
                        <input style="width: 240px " name="product">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">品牌</td>
                    <td   style="width:250px ;">
                        <input style="width: 240px " name="name">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">英文</td>
                    <td   style="width:250px ;">
                        <input style="width: 240px " name="englishName">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">企业名称</td>
                    <td   style="width:250px ;">
                        <input style="width: 240px " name="enterpriseName">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">原产地</td>
                    <td   style="width:250px ;">
                        <input style="width: 240px " name="originPlace">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">厂家网址</td>
                    <td colspan="3"  style="width:650px ;">
                        <input style="width: 600px " name="url">
                    </td>

                </tr>
                <!--<tr style="height:40px;">-->
                <!--<td style="width:150px ;background-color: #efefef">品牌证书</td>-->
                <!--<td colspan="3"  style="width:650px ;">-->
                <!--<input style="width: 600px " type="file" name="file">-->
                <!--</td>-->

                <!--</tr>附加项-->

            </table>

            <input id="ok"  type="submit" value="确定" style="margin-left:320px ">
            <a href="/supplier/trademark/query" id="no"  >取消</a>
        </form>
    </div>
</div>
</body>
</html>