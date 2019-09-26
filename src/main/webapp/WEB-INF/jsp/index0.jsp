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
<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>广电建设集团</title>

    <link rel="stylesheet" href="<%=basePath%>/css/font.css">
    <link rel="stylesheet" href="<%=basePath%>/css/xadmin.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
    <script src="<%=basePath%>/layuiAdmin.std-v1.0.0/src/layuiadmin/layui/layui.js" charset="utf-8"></script>
    <script src="<%=basePath%>/js/jquery-3.3.1.js" ></script>
    <script type="text/javascript" src="<%=basePath%>/js/xadmin.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/public/jump.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/index.js"></script>
    <![endif]-->
    <script>
        // 是否开启刷新记忆tab功能
        // var is_remember = false;
    </script>
</head>
<body class="index">
<!-- 顶部开始 -->
<!--<div class="container">-->
<!---->
<div class="container">
    <div id="imgs">
        <img src="<%=basePath%>/imgs/logo1.png" style="width: 110px ;height: 80px;margin-left:5px ;margin-top: 5px  "/>
    </div>
    <div id="top">

        <a href="/page/sign">
            <img src="<%=basePath%>/imgs/icon1.png" height="25" width="25"/>
            <p><b>首页</b></p>
        </a>
        <%--<a href="/showMyWork">--%>
            <a  onclick="+xadmin.add_tab('我的工作','<%=basePath%>/showMyWork')">
            <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>

            <p><b>我的工作</b></p>
        </a>
        <a  onclick="+xadmin.add_tab('解决方案','<%=basePath%>/ ')">
            <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
            <p><b>解决方案</b></p>
        </a>
        <a  onclick="+xadmin.add_tab('流程与规定','http://localhost:8088/upload/2019-07-11_180487_新建文本文档.txt')">
            <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
            <p><b>流程与规定</b></p>
        </a>
        <a  onclick="+xadmin.add_tab('信息发布','http://localhost:8088/upload/2019-07-24_763585_test.pdf ')">
            <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
            <p><b>信息发布</b></p>
        </a>
        <a class="top-right"   onclick="+xadmin.add_tab('用户管理','<%=basePath%>/user/user/updateself ')">
            <img src="<%=basePath%>/imgs/20160602111922932.png" height="25" width="25"/>
            <p>用户管理</p>
        </a>
        <div  id="tc" style="float: right;width: 120px ">
            <p><a class="name" style="color: #FFFFFF ;margin-right: 5px "></a><a class="userName" style="color: #FFFFFF"></a></p>
            <p style="margin-top: 25% "><a  style="color: #FFFFFF ;margin-left: 56px ;margin-top: 50px " href="/page/quit">退出</a></p>
        </div>
        <div class="day-time">
            <input id="day">
            <input id="daytime">
        </div>
        <input id="time">
        <div id="weather">
            <p></p>
            <!--${user.company}-->
            <span></span>
            <!--${user.name}-->
            <p class="comment"></p>
        </div>
    </div>
</div>
<!--</div>-->
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">

        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home">
                <i class="layui-icon">&#xe68e;</i>
            </li>
        </ul>
        <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
            <dl>
                <dd data-type="this">关闭当前</dd>
                <dd data-type="other">关闭其它</dd>
                <dd data-type="all">关闭全部</dd></dl>
        </div>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>
</div>
<!--<div class="page-content-bg"></div>-->
<!--<style id="theme_style"></style>-->
<!-- 右侧主体结束 -->
<!-- 中部结束 -->

</body>

<script>

</script>


</html>
