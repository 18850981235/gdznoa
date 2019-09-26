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
    <title>项目部工资详情</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/../layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/outerTube/outerTubeAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/finance/expenditure/wages/wagesParticular.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form action="/ga/payment/addPaymentSalary" method="post"  enctype="multipart/form-data">
            <table border="1" style="width: 1000px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>项目部工资详情</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目</td>
                    <td colspan="3" style="width:300px ;">
                        <input style="width: 270px;" readonly>
                        <input style="display: none" name="projectid">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">名称</td>
                    <td style="width:300px ;">
                        <input style="width: 270px;" name="name">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">收款单位</td>
                    <td style="width:300px ;">
                        <input style="width: 270px;" name="unit">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">申请人</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " >
                        <input style="display: none" name="userid">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">付款方式</td>
                    <td  style="width:300px ;">
                        <select class="type" style="width: 200px;height: 35px  " name="type">
                            <option></option>

                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">开户行</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " name="bankname" >
                    </td>
                    <td style="width:150px ;background-color: #efefef">账户</td>
                    <td style="width:300px ;">
                        <input style="width: 270px " name="bankaccount">

                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">摘要</td>
                    <td  colspan="3"  style="width:300px ;">
                        <input style="width: 600px "  name="digest">
                        <input style="display: none" name="id">
                    </td>
                </tr>
            </table>
            <table  style="width: 1000px ;background-color:#c4de83;text-align: center ">
                <tr style="height: 35px ">
                    <td style="width:100px;">姓名</td>
                    <td style="width:100px;">岗位</td>
                    <td style="width:100px;">考勤</td>
                    <td style="width:100px;">应发金额</td>
                    <td style="width:100px;">时间(年月)</td>
                    <td style="width:100px;">扣(社保)</td>
                    <td style="width:100px;">扣(请假)</td>
                    <td style="width:100px;">扣(保险)</td>
                    <td style="width:100px;">扣(其他)</td>
                    <td style="width:100px;">实发金额</td>
                </tr>
            </table>
            <table border="1" id="con"  style="width: 1000px ">
                <tr style="height: 35px ;display:none;">
                    <td style="width:100px;">id</td>
                    <td style="width:100px;">name</td>
                    <td style="width:100px;">post</td>
                    <td style="width:100px;">clockinIn</td>
                    <td style="width:100px;">salary</td>
                    <td style="width:100px;">time</td>
                    <td style="width:100px;">socialSecurity</td>
                    <td style="width:100px;">leave</td>
                    <td style="width:100px;">insurance</td>
                    <td style="width:100px;">rests</td>
                    <td style="width:100px;">netPay</td>
                </tr>
            </table>

            <table class="he" border="1" style="width:1000px ;">
                <tr style="height: 35px ">
                    <td style="width:150px  ;background-color: #efefef">总计(元)</td>
                    <td>
                        <input style="width: 800px ">

                    </td>
                </tr>
            </table>


            <a  id="no"  >取消</a>
        </form>
    </div>
</div>
</body>
</html>