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
    <title>项目部工资查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/purchase/contract/contractList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>-->
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/finance/expenditure/wages/wagesList.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>名称</span>
                    <input  >
                </div>
                <div class="top2">
                    <span>付款方式</span>
                    <select style="height: 30px ;width: 200px;margin-top: 4px  ">
                        <option value="">请选择</option>
                        <option>现金付款</option>
                        <option>转账付款</option>
                    </select>
                </div>
                <div class="top3">
                    <span>收款单位</span>
                    <input type="text" style="float: left"  class="serialnumber">
                </div>
            </div>
            <!--<div class="query-in">-->
                <!--<div class="in1">-->
                    <!--<span>供应商</span>-->

                    <!--<select class="contacts" style="width: 200px ;height: 35px ">-->
                        <!--<option value="">请选择</option>-->
                    <!--</select>-->

                <!--</div>-->
                <!--<div class="in2">-->
                    <!--<span>合同编号</span>-->
                    <!--<input type="text" class="code"  >-->
                <!--</div>-->

            <!--</div>-->
            <div class="query-button">
                <a href="" class="add">新增</a>
                <input value="快速查询" type="submit" class="query"/>
            </div>
        </div>
        <div class="paging">
            <table style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 100px ">序号</td>
                    <td style="width: 330px ">名称</td>
                    <td style="width: 330px ">收款单位</td>
                    <td style="width: 330px ">付款方式</td>
                    <td style="width: 120px ">操作</td>
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