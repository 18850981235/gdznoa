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
    <title>工程维保人员新建</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/../layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/engineering/maintenance/personnel/personnelAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/../layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <!--<script src="<%=basePath%>/js/public/pipelineNumber.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/engineering/maintenance/personnel/personnelAdd.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form action="" method="post"  enctype="multipart/form-data">
            <table border="1" style="width: 1000px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>工程维保人员新建</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目名称</td>
                    <td colspan="3" style="width:300px ;">
                        <select class="" style="width:295px;height: 30px  ">
                            <option>请选择</option>
                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">人员名称</td>
                    <td style="width:300px ;">
                        <input style="width: 280px ">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">联系电话</td>
                    <td style="width:300px ;">
                        <input style="width: 280px ">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">身份证</td>
                    <td style="width:300px ;">
                        <input style="width: 200px;display: inline-block " type="file">
                        <a class="herf" onclick="clearMethod1()" >清空</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">身份证号码</td>
                    <td style="width:300px ;">
                        <input style="width: 280px ">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">照片</td>
                    <td style="width:300px ;">
                        <input style="width: 200px;display: inline-block " type="file">
                        <a class="herf" onclick="clearMethod2()" >清空</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">意外险购买</td>
                    <td style="width:300px ;">
                        <input style="width: 200px;display: inline-block " type="file">
                        <a class="herf" onclick="clearMethod3()" >清空</a>
                    </td>
                </tr>
            </table>

            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="personnelList.html" id="no"  >取消</a>
        </form>
    </div>
</div>
<script>
    function clearMethod1() {
        var objFile=document.getElementsByTagName('input')[2];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
    function clearMethod2() {
        var objFile=document.getElementsByTagName('input')[4];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
    function clearMethod3() {
        var objFile=document.getElementsByTagName('input')[5];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
</script>
</body>
</html>