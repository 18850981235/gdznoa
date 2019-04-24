<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>


<div id="left">
    <div id="imgs">
        <img src="<%=basePath%>/imgs/logo1.png" />
    </div>

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

    <a href="/page/sign">
        <img src="<%=basePath%>/imgs/icon1.png" height="25" width="25"/>
        <p><b>首页</b></p>
    </a>
    <a href="/showMyWork">
        <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
        <p><b>我的工作</b></p>
    </a>
    <a>
        <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
        <p><b>解决方案</b></p>
    </a>
    <a>
        <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
        <p><b>流程与规定</b></p>
    </a>
    <a>
        <img src="<%=basePath%>/imgs/20160602111914531.png" height="25" width="25"/>
        <p><b>信息发布</b></p>
    </a>
    <a class="top-right">
        <img src="<%=basePath%>/imgs/20160602111922932.png" height="25" width="25"/>
        <p>用户管理</p>
    </a>
    <div  id="tc" style="float: right;width: 120px ">
        <p><a style="color: #FFFFFF ;margin-right: 5px ">机构名称</a><a style="color: #FFFFFF">姓名</a></p>
        <p style="margin-top: 25% "><a style="color: #FFFFFF ;margin-left: 56px ;margin-top: 50px ">退出</a></p>
    </div>
    <div class="day-time">
        <input id="day">
        <input id="daytime">
    </div>
    <input id="time">
    <div id="weather">
        <p>${user.dept}</p>
        <span>${user.name}</span>
        <p class="comment"></p>
    </div>
</div>