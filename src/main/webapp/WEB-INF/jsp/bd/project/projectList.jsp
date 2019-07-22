<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/27
  Time: 16:02
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
    <title>项目立项</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/project/projectList.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/responsible.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/see.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/company.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/region.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/department.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/bd/project/projectList.js"></script>
</head>
<body>
<!--<jsp:include page="../../in-topleft.jsp"/>-->

<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name" style="display: none">
                <li class="co">
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
<div id="choice3" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="name3" >
        <li class="co3">
            <a class="upload3" href="">
                <span class="name-block3"></span>
                <span class="name-none3" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close3">
        <a class="close-in" >返回</a >
    </div>
</div>
<!---->
<div id="content-in" >
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>项目简称：	</span>
                    <input class="projectName">
                </div>
                <div class="top2">
                    <span>所属机构：	</span>
                    <select class="deptid department" style="height: 25px " required>
                        <option value="">请选择</option>
                    </select>
                </div>
                <div class="top3">
                    <span>项目阶段</span>
                    <select style="height: 25px " class="stage" required>
                        <option value="">请选择</option>
                        <option >前期业务阶段</option>
                        <option >签约施工阶段</option>
                        <option >售后服务阶段</option>
                        <option>合约完成结束</option>
                        <option >未中标终止</option>
                    </select>
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>项目负责人：	</span>
                    <input class=" principalName" readonly>


                </div>
                <div class="in2">
                    <span>区域负责人：	</span>
                    <input class="Eliminate-3" readonly>
                    <input style="display: none" class="Eliminate-no-3 areaManager" >
                    <a target="_blank " class="add-to3" style="margin-top: 10px ;position: relative ;float: left  "><span style="width: 30px ;height:20px ;position: absolute;top: -10px;left: 16px  ">添加</span></a>
                    <a class="clear-to3" style="position: relative ;float: left;margin-left: 25px ;margin-top: 10px ">
                        <input style="width: 30px ;height:30px ;position: absolute;top: -10px;left: 16px  " value="清空" class="input3"  onClick="" type="button">
                    </a>
                </div>
                <div class="in3">
                    <span>项目立项时间：</span>
                    <!--<input type="date" class="time-x">-->
                    <input  type="text" style="background-color: #ffffff" class="demo-input start" placeholder="请选择日期" id="test1"  >
                    <span style="width: 40px ">-</span>
                    <input  type="text" style="text-align: center" class="demo-input end" placeholder="请选择日期" id="test2"  >
                    <!--<input type="date" class="time-d">-->
                    <!--<input  style="display:none;" class="time-z">-->
                </div>
            </div>
            <div class="query-button" >

                <a href="/bd/project/add"  style="text-align: center;line-height: 25px " class="add">新增</a>
                <input value="快速查询"  type="submit" class="query"/>


            </div>
        </div>
        <div class="paging">
            <table >
                <tr style="height: 40px" class="start">
                    <td style="width: 200px"><b>项目名称</b></td>
                    <td style="width: 150px"><b>项目简称</b></td>
                    <td style="width: 150px"><b>所属机构</b></td>
                    <td style="width: 100px"><b>项目招标方式</b></td>
                    <td style="width: 100px"><b>项目阶段</b></td>
                    <td style="width: 100px"><b>业务负责人</b></td>
                    <td style="width: 100px"><b>区域负责人</b></td>
                    <td style="width: 150px"><b>项目立项时间</b></td>
                    <td style="width: 100px"><b>项目预算</b></td>
                    <td style="width: 100px"><b>操作</b></td>
                </tr>

            </table>
        </div>
        <div id="paginator-test"></div>
    </div>
</div>
<!---->
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