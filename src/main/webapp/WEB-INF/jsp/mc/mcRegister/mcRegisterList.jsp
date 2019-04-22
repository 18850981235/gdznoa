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
    <title>注册备案管理查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcRegister/mcRegisterList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/mc/mcRegister/mcRegisterList.js"></script>
</head>
<body>
<div id="left">
    <div id="imgs">
        <img src="<%=basePath%>/imgs/logo1.png" />
    </div>

    <div id="menu">
        <div class="list">
            <ul class="yiji" >
                <li style="display: none">
                    <a href="#" class="inactive"></a>
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
<div id="top" >

    <a>
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
        <p>名称</p>
        <P>公司</P>
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
<div id="page">
    <a class="page-left ">注册备案管理查询</a>
</div>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>申请部门</span>
                    <select class="department" style="width: 100px;height: 30px " name="deptid">
                        <option value="">
                            请选择
                        </option>
                    </select>
                </div>
                <div class="top2">
                    <span>注册备案类型</span>
                    <select class="recordsType"  style="height: 30px ;margin-top: 4px  " name="recordsType">
                        <option value="">请选择</option>
                        <option>入省备案</option>
                        <option>采购投标CA</option>
                        <option>工程投标CA</option>
                        <option>其他</option>
                    </select>
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>注册备案名称</span>
                    <input class="recordsName" name="recordsName">
                </div>
            </div>
            <div class="query-button">
                <input value="新增" type="submit" class="add">
                <input value="快速查询"  type="submit" class="query"/>
                <input value="重置"  type="submit" class="reset">
            </div>
        </div>
        <div class="paging">
            <table   style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 60px ">序号</td>
                    <td style="width: 350px ">注册备案名称</td>
                    <td style="width: 150px ">申请日期</td>
                    <td style="width: 150px ">申请部门</td>
                    <td style="width: 150px ">注册备案类型</td>
                    <td style="width: 150px ">注册备案状态</td>
                    <td style="width: 110px ">操作</td>
                </tr>
            </table>
            <table class="sea2" style="text-align: center">

            </table>

        </div>
        <div id="paginator-test"></div>
    </div>
</div>
</body>
</html>


