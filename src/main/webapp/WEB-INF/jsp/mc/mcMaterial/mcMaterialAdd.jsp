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
    <title>商务材料申请</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcMaterial/mcMaterialAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/projectName.js"></script>
    <script src="<%=basePath%>/js/mc/mcMaterial/mcMaterialAdd.js"></script>

</head>
<body>

<div id="content-in">
    <div id="center">
        <form action="/mc/materials/add.html" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="text-align: center;height: 45px ">
                    <td colspan="4" style="width: 900px;background-color: #efefef "><b>商务材料申请</b></td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请部门</span>
                        <input style="display: none">
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid" required>
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">
                        <span>申请日期</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test1"name="createtime">

                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>申请人</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:200px ;">
                        <input style="display: none" name="userid" required>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">
                        <span>联系电话</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:200px ;" name="phone">

                    </td>
                </tr>
                <tr  style="height: 45px ">

                    <td style="width:150px ;background-color: #efefef;">
                        <span>项目名称</span>
                    </td>
                    <td colspan="3"   style="width:300px ;">
                        <select class="projectname" style="width:500px;height: 30px " name="projectid" required>

                        </select>
                    </td>
                </tr>
                <tr  style="height: 45px ">

                    <td style="width:150px ;background-color: #efefef;">
                        <span>非盖章申请内容</span>
                    </td>
                    <td colspan="3"   style="width:300px ;">
                        <textarea style="width: 700px " name="content"></textarea>
                    </td>
                </tr>
                <tr  style="height: 45px ">

                    <td style="width:150px ;background-color: #efefef;">
                        <span>用途说明</span>
                    </td>
                    <td colspan="3"   style="width:300px ;">
                        <textarea style="width: 700px " name="purpose"></textarea>
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>附件</span>
                    </td>
                    <td colspan="3" >
                        <input type="file"   style="width:700px "name="file">
                    </td>
                </tr>
            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/mcmaterials/query" id="no"  >取消</a>
        </form>
    </div>
</div>
<script type="text/javascript">
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });

</script>
</body>
</html>