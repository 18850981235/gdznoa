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
    <title>支出付款申请</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/outerTube/outerTubeAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/finance/expenditure/index.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form action="/ga/payment/addPayment" method="post"  enctype="multipart/form-data">
            <table border="1" style="width: 1000px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>支出付款申请</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目名称</td>
                    <td    style="width:300px ;">
                        <input id="project" style="width: 270px  "  readonly >
                        <input id="projectid" style="width: 270px ;display: none" name="projectid"  >
                    </td>
                    <td style="width:150px ;;background-color: #efefef">事由</td>
                    <td  style="width:300px ;">
                        <input id="ferf" style="width: 270px " class="type" name="matter" readonly >
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">领款单位</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " class="type" name="unit" >
                    </td>
                    <td style="width:150px ;;background-color: #efefef">申请人</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " readonly>
                        <input style="display: none" name="userid" >
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">金额</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " name="paymentMoney">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">付款方式</td>
                    <td  style="width:300px ;">
                        <select style="width: 200px;height: 35px  " name="type">
                            <option value="">请选择</option>
                            <option>现金</option>
                            <option>对公</option>
                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px;background-color: #efefef">摘要</td>
                    <td colspan="3"  style="width:300px ;">
                        <input style="width: 800px " class="type"  name="digest">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">开户行</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " class="type"  name="bankname">
                    </td>
                    <td style="width:150px ;background-color: #efefef">账户 </td>
                    <td style="width:300px ;">
                        <input style="width: 270px " name="bankaccount">
                    </td>
                </tr>
            </table>
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