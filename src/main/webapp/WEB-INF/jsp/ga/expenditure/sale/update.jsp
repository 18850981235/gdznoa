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
    <title>合同支出修改</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/outerTube/outerTubeAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/finance/expenditure/sale/salePadute.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form action="/ga/payment/update.html" method="post"  enctype="multipart/form-data">
            <table border="1" style="width: 1000px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>支出项修改</b>
                        <input style="display: none" name="id">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">合同名称</td>
                    <td   style="width:300px ;">
                        <select id="ap" style="width:270px ;height: 35px  " >
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">事由</td>
                    <td   style="width:300px ;">
                        <input id="ferf" style="width: 270px " name="matter" readonly>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">合同金额</td>
                    <td  style="width:300px ;">
                        <input  style="width: 270px " readonly name="contractMoney">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">付款方式</td>
                    <td  style="width:300px ;">
                        <select class="type" style="width: 200px;height: 35px  " name="type">
                            <option value="">请选择</option>
                            <option>现金付款</option>
                            <option>转账付款</option>
                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">申请时间</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " type="text" id="test1" placeholder="请选择时间" name="createtime">
                    </td>
                    <td style="width:150px ;background-color: #efefef">申请人 </td>
                    <td style="width:300px ;">
                        <input style="width: 270px " >
                        <input style="width: 270px ;display: none " name="userid">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">应付金额</td>
                    <td  colspan="3" style="width:300px ;">
                        <input style="width: 270px " name="paymentMoney">
                    </td>
                    <!--<td style="width:150px ;background-color: #efefef">供应商名称</td>-->
                    <!--<td style="width:300px ;">-->
                    <!--<input style="width: 270px " name="">-->
                    <!--</td>-->
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">已付金额</td>
                    <td  style="width:300px ;">
                        <input id="yf" style="width: 270px " name="paid">
                    </td>
                    <td style="width:150px ;background-color: #efefef">未支付金额</td>
                    <td style="width:300px ;">
                        <input style="width: 270px " name="">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">已开发票金额</td>
                    <td  style="width:300px ;">
                        <input id="yk" style="width: 270px " name="ticket">
                    </td>
                    <td style="width:150px ;background-color: #efefef">未开发票金额</td>
                    <td style="width:300px ;">
                        <input style="width: 270px " name="">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">领款单位</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " name="unit">
                    </td>
                    <td style="width:150px ;background-color: #efefef">摘要</td>
                    <td style="width:300px ;">
                        <input style="width: 270px " name="digest">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">开户行</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " name="bankname">
                    </td>
                    <td style="width:150px ;background-color: #efefef">开户账户</td>
                    <td style="width:300px ;">
                        <input style="width: 270px " name="bankaccount">
                    </td>
                </tr>
            </table>
            <input style="display: none" id="projectid" name="projectid">

            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/ga/show" id="no"  >取消</a>
        </form>
    </div>
</div>
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
    laydate.render({
        elem: '#test3', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
</script>
</body>
</html>