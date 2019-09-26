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
    <title>销售合同查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/sale/contract/contractList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/region.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/company.js"></script>
    <script src="<%=basePath%>/js/sale/contract/contractList.js"></script>

</head>
<body>
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
<div id="choice1" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="name1" >
        <li class="co1">
            <a class="upload1" href="">
                <span class="name-block1"></span>
                <span class="name-none1" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close1">
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
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>项目名</span>
                    <select id="ap" ><option value="">请选择 </option></select>
                </div>
                <div class="top2">
                    <span>客户名称</span>
                    <input class="Eliminate-1" style="line-height: 40px ;float: left" readonly required>
                    <input style="display: none" class="Eliminate-no-1" name="clientid">
                    <a target="_blank " style="margin-top: 15px;line-height: 40px;width: 40px;display: inline-block   "  class="add-to1"><span style="float: right;height: 16px;line-height: 16px  ">添加</span></a>
                    <a class="clear-to1" >
                        <input value="清空" class="input1" style="height: 16px ;line-height: 16px ;width: 25px;float: right " onClick="" type="button">
                    </a>
                </div>
                <div class="top3">
                    <span>所属机构</span>
                    <select class="department" style="width: 150px ;height: 30px "><option value="">请选择</option></select>
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>中标时间 </span>
                    <input type="text" placeholder="请选择时间" id="test1" >
                </div>
                <div class="in2">
                    <span>区域负责人</span>
                    <input class="Eliminate-3" style="line-height: 40px ;float: left" readonly required>
                    <input style="display: none" class="Eliminate-no-3" name="areaManager">
                    <a target="_blank " style="margin-top: 15px;line-height: 40px;width: 40px;display: inline-block   "  class="add-to3"><span style="float: right;height: 16px;line-height: 16px  ">添加</span></a>
                    <a class="clear-to3" style=" " >
                        <input value="清空" class="input3" style="height: 16px ;line-height: 16px ;width: 25px;float: right " type="button">
                    </a>
                </div>
                <div class="in3">
                    <span>业务负责人</span>
                    <input class="Eliminate" style="line-height: 40px ;float: left" readonly>
                    <input style="display: none" class="Eliminate-no" name="principal">
                    <a target="_blank " style="margin-top: 15px;line-height: 40px;width: 40px;display: inline-block   " class="add-to"><span style="float: right;height: 16px;line-height: 16px  ">添加</span></a>
                    <a class="clear-to" >
                        <input value="清空" class="input" style="height: 16px ;line-height: 16px ;width: 25px;float: right " onClick="" type="button">
                    </a>
                    <input>
                </div>
            </div>
            <div class="query-button">
                <a href="/sd/SdSalesContract/AddProjectPage" class="add">新增</a>
                <input value="快速查询" type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 40px ">序号</td>
                    <td style="width: 200px ">项目名称</td>
                    <td style="width: 120px ">项目编号</td>
                    <td style="width: 80px ">客户名称</td>
                    <td style="width: 100px ">中标时间</td>
                    <td style="width: 100px ">管理费费率</td>
                    <td style="width: 100px ">总金额</td>
                    <td style="width: 80px ">增加金额</td>
                    <td style="width: 80px ">减少金额</td>
                    <td style="width: 100px ">发票类型</td>
                    <td style="width: 140px ">操作</td>
                </tr>
            </table>
            <table class="sea2" style="text-align: center">

            </table>
        </div>
        <div id="paginator-test"></div>
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