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
    <title>合同支出查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/outerTube/outerTubeList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/../layui/lay/modules/laydate.js" type="text/javascript"></script>-->
    <!--<script src="../../../js/public/jump.js"></script>-->
    <!--<script src="../../../js/public/department.js"></script>-->
    <!--<script src="../../../js/public/projectName.js"></script>-->
    <script src="<%=basePath%>/js/finance/expenditure/sale/saleList.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div class="paging">
            <table   style="text-align: center" >
                <tr class="seal" style="height: 40px;background-color: #c4de83; " >
                    <td style="width: 100px ">序号</td>
                    <td style="width: 200px ">合同名称</td>
                    <td style="width: 100px ">申请日期</td>
                    <td style="width: 100px ">合同总额</td>
                    <td style="width: 100px ">应付金额</td>
                    <td style="width: 100px ">已付金额</td>
                    <td style="width: 100px ">未支付金额</td>
                    <td style="width: 100px ">已开发票金额</td>
                    <td style="width: 100px ">未开发票金额</td>
                    <td style="width: 100px ">状态</td>

                    <td style="width: 110px ">操作</td>
                </tr>
            </table>
            <table class="sea2"  style="text-align: center">

            </table>
        </div>
        <div id="paginator-test" style="height: 60px;margin-left: 600px;display: inline-block   ">

        </div>
        <div>
            <a href="/ga/show" class="add" style="height: 25px;margin-left: 600px  ">返回</a>

        </div>
    </div>
</div>
</body>
</html>