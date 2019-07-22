<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 14:09
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
    <title>客户管理系统</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/customerInfo/customerInfoList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/bd/client/clientList.js"></script>
</head>
<body>


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
        <a class="close-in" >返回</a >
    </div>
</div>
<!--客户-->
<div id="content-in" >
    <div id="center">
        <div id="query-button">
            <div class="query-top" >
                <div class="top1" >
                    <span>业务负责人：</span>
                    <input class="Eliminate"  readonly>
                    <input style="display: none" class="Eliminate-no" >
                </div>
                <a  class="add-to">添加</a>
                <div class="clear-to" >
                    <input value="清空" class="input" onClick="" type="reset">
                </div>
                <div class="top2">
                    <span>单位类型：	</span>
                    <select class="name2" style="height: 25px ">
                        <option value="">请选择</option>
                        <option value="政府">政府</option>
                        <option value="国有企业" >国有企业</option>
                        <option value="事业单位">事业单位</option>
                        <option value="外资企业">外资企业</option>
                        <option value="民营企业">民营企业</option>
                    </select>
                </div>
                <div class="top3">
                    <span>所在地区：	</span>
                    <select class="name1" style="height: 25px ">
                    </select>
                </div>
            </div>
            <div class="query-in" >
                <div class="in1" >
                    <span>客户名称	</span>
                    <input class="clientName" >
                </div>
            </div>
            <div class="query-button" >
                <a  href="/bd/client/add"  class="add">新增</a>
                <input value="快速查询"  type="submit" class="query"/>
            </div>
        </div>

        <div class="paging">
            <table>
                <tr style="height: 40px" class="start">
                    <td style="width: 100px"><b>序号</b></td>
                    <td style="width: 300px"><b>客户名称</b></td>
                    <td style="width: 130px"><b>单位类型</b></td>
                    <td style="width: 130px"><b>所在地区</b></td>
                    <td style="width: 200px"><b>所属部门</b></td>
                    <td style="width: 200px"><b>业务负责人</b></td>
                    <td style="width: 150px"><b>操作</b></td>
                </tr>
            </table>

            <table class="paging-in"></table>
        </div>
        <div id="paginator-test"></div>
    </div>

</div>
</body>
</html>
