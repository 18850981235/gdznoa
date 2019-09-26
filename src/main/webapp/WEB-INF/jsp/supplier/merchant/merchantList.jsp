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
    <title>供应商查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/supplier/merchant/merchantList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/projectName.js"></script>-->
    <script src="<%=basePath%>/js/public/brand.js"></script>
    <script src="<%=basePath%>/js/supplier/merchant/merchantList.js"></script>
</head>
<body>
<div id="choice7" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no7">
        <li style="display:block;">
            <a href="#" class="click"></a>
            <ul class="name7" style="display: block">
                <!--<li>-->
                <!--<a class="upload-noe" href="">-->
                <!--<span class="name-block7"></span>-->
                <!--<span class="name-none7" style="display: none"></span>-->
                <!--</a>-->
                <!--</li>-->
            </ul>
        </li>
    </ul>
    <div id="close7">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>供应商名称</span>
                    <input class="name" >
                </div>
                <div class="top2">
                    <span>供应商编号</span>
                    <input  class="code">
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>品牌</span>
                    <input style="height: 35px ;margin-top: 4px " class="traname ">
                </div>
            </div>
            <div class="query-button">
                <a href="/supplier/supplier2/addSupplierPage" class="add">新建</a>
                <input value="快速查询"  type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table style="text-align: center" >
                <tr class="seal" style="height: 40px;background-color: #c4de83; " >
                    <td style="width: 60px ">序号</td>
                    <td style="width: 250px ">供应商名称</td>
                    <td style="width: 100px ">供应商编号</td>
                    <td style="width: 100px ">电话</td>
                    <td style="width: 200px ">传真</td>
                    <td style="width: 100px ">品牌信息</td>
                    <td style="width: 130px ">电子邮件</td>
                    <td style="width: 110px ">记录员</td>
                    <td style="width: 130px ">操作</td>
                </tr>
            </table>
            <table class="sea2"  style="text-align: center">

            </table>
        </div>
        <div id="paginator-test" style="height: 60px "></div>
    </div>
</div>
<script type="text/javascript">
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test2', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });

</script>
</body>
</html>