<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<div id="left">
    <img src="<%=basePath%>/imgs/logo1.png" />
    <div id="menu">
        <div class="list">
            <ul class="yiji" >
                <li style="display: none" >
                    <a href="#" class="inactive" ></a>
                    <ul style="display: none">
                        <li>
                            <a href="#" class="inactive active"></a>
                            <ul>
                                <li><a href="#"></a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="top">

    <a href="">
        <img src="<%=basePath%>/imgs/icon1.png" height="25" width="25"/>
        <p>首页</p>
    </a>
    <a>
        <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
        <p>我的工作</p>
    </a>

    <a class="top-right">
        <img src="<%=basePath%>/imgs/20160602111922932.png" height="25" width="25"/>
        <p>用户管理</p>
    </a>
    <a style="float: right">
        <p>${user.name}</p>
        <P>${user.company}</P>
    </a>
    <div class="day-time">
        <input id="day">
        <input id="daytime">
    </div>
    <input id="time">
    <div id="weather">
        <p></p>
        <span></span>
        <p class="comment"></p>
    </div>
</div>
