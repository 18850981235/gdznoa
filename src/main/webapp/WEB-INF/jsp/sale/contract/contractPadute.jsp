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
    <title>销售合同修改</title>



    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/sale/contract/contractAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/region.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/yearPeople.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/company.js"></script>
    <script src="<%=basePath%>/js/sale/contract/contractPadute.js"></script>

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
<div id="choice6" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no6">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name" style="display: none">
                <li class="co6">
                    <a class="upload6" href="">
                        <span class="name-block6"></span>
                        <span class="name-none6" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close6">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="content-in">
    <div id="center">
        <form  action="/sd/SdSalesContract/updateContract" method="post"   enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>销售合同修改</b>
                        <input style="display:none;" name="id">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>项目名称</span>
                    </td>
                    <td  style="width:300px ;">
                        <select id="ap" style="height: 30px " name="projectid">
                            <option>请选择</option>
                        </select>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>客户名称</span>
                    </td>
                    <td  style="width:300px ;">
                        <input class="Eliminate-1" style="line-height: 40px ;float: left" readonly >
                        <input style="display: none" class="Eliminate-no-1" name="clientid">

                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目编号</td>
                    <td style="width:300px ;">
                        <input  id="number" style="width: 250px ;display: inline-block" name="projectcode" readonly>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">合同编号</td>
                    <td >
                        <input   style="width: 250px ;display: inline-block" name="code">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">所属机构</td>
                    <td style="width:300px ; ">
                        <select style="height: 30px " class="department" name="deptid">
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">业务负责人</td>
                    <td >
                        <input class="Eliminate" readonly>
                        <input style="display: none" class="Eliminate-no" name="principal">
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">分公司负责人</td>
                    <td style="width:300px ;">
                        <input class="Eliminate-6" readonly >
                        <input style="display: none" class="Eliminate-no-6" name="branchuser">
                        <a target="_blank " class="add-to6">添加</a>
                        <a class="clear-to6" >
                            <input value="清空" class="input6"  onClick="" type="button">
                        </a>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">区域负责人</td>
                    <td >
                        <input class="Eliminate-3" readonly required>
                        <input style="display: none" class="Eliminate-no-3" name="areaManager">
                        <a target="_blank "  class="add-to3">添加</a>
                        <a class="clear-to3" >
                            <input value="清空" class="input3"  onClick="" type="button">
                        </a>
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">税务发票类型</td>
                    <td style="width:300px ;">
                        <select class="invoiceType" style="height: 30px " name="invoiceType">
                            <option>请选择</option>
                            <option>普通发票</option>
                            <option>专业发票</option>
                        </select>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">合同金额</td>
                    <td >
                        <input   style="width: 170px ;display: inline-block" name="contractAmount">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">增加金额</td>
                    <td style="width:300px ;">
                        <input name="addAmount" value="0">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">增加清单</td>
                    <td>
                        <select class="addList" style="height: 30px " name="addList"></select>
                        <span class="refresh">刷新</span>
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">减少金额</td>
                    <td style="width:300px ;">
                        <input name="reductionAmount" value="0">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">减少清单</td>
                    <td >
                        <select class="reductionList" style="height:30px" name="reductionList"></select>
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">管理费费率</td>
                    <td style="width:300px ;">
                        <input name="managementRate">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">中标时间</td>
                    <td >
                        <input type="text"  placeholder="请选择日期" id="test1" name="bidiingTime">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">银行账号名称</td>
                    <td style="width:300px ;">
                        <input name="bank">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">账户</td>
                    <td >
                        <input   name="bankAccount">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">附件</td>
                    <td colspan="3" style="width:300px ;">
                        <input type="file" name="file" multiple>
                    </td>
                </tr>
            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/sd/sales/query" id="no" >取消</a>
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


