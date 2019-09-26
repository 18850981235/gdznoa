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
    <title>工程维保信息新建</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/../layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/engineering/maintenance/news/newsAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/../layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <!--<script src="<%=basePath%>/js/public/pipelineNumber.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/engineering/maintenance/news/newsAdd.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form action="" method="post"  enctype="multipart/form-data">
            <table border="1" style="width: 1000px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>工程维保信息新建</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目名称</td>
                    <td style="width:300px ;">
                        <select class="" style="width:295px;height: 30px  ">
                            <option>请选择</option>
                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">维保期限</td>
                    <td style="width:300px ;">
                        <input style="width: 280px ">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">维保要求</td>
                    <td colspan="3" style="width:300px ;">
                        <input style="width:600px "   name="">
                    </td>

                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">维修记录</td>
                    <td colspan="3" style="width:300px ;">
                        <input style="width:600px "   name="">
                    </td>

                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">维修结果</td>
                    <td style="width:300px ;">
                        <input style="width:280px "   name="">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">维修费用</td>
                    <td style="width:300px ;">
                        <input style="width: 280px ">
                    </td>
                </tr>

            </table>

            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="newsList.html" id="no"  >取消</a>
        </form>
    </div>
</div>
</body>
</html>