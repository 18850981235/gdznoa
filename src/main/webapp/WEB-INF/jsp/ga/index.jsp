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
    <title>财务</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/index.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <script src="<%=basePath%>/js/finance/index.js"></script>

</head>
<body>
<div id="content-in">
        <div id="center">
        <form style="display: block">
            <table border="1" style="width: 1350px">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="6" style="text-align: center">
                        <b style="margin-left: 250px; ">财务管理页面</b>
                        <select class="project" style="width: 300px ;height: 30px;text-align: center;float: right">
                            <option>请先选择项目</option>
                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目名称</td>
                    <td colspan="5"  style="width:1200px ;">
                        <input style="width: 1000px " name="name" readonly>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目编号</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " type="text" name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目所属部门</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">收款账户号</td>
                    <td style="width:300px ;">
                        <input class="uiou" style="width: 240px " name="name" readonly>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">销售合同金额</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">验收结算金额</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">财审结算金额</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">合同增加金额</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">合同减少金额</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">合同增补金额</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">外管证</td>
                    <td style="width:300px ;">
                        <span style="display: none">外管证</span>
                        <a href="/ga/outerTube/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/outerTube/query" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">银行日记账流水</td>
                    <td style="width:300px ;">
                        <span style="display: none">银行日记账流水</span>
                        <a href="/ga/journal/Bank" class="herf" style="width: 70px " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">账目日记账流水</td>
                    <td style="width:300px ;">
                        <span style="display: none">账目日记账流水</span>
                        <a href="/ga/journal/Account" class="herf" style="width: 70px " >查看</a>
                    </td>
                </tr>
                <tr style="height: 40px ;background-color: #4aa5d1;border-bottom: 0px ">
                    <td colspan="6" style="text-align: center">
                        <b>应付财务项(支出)</b>
                        <span class="block-1" style="float: right;margin-right: 15px;cursor: pointer;color: #ff061c; ">下拉</span>
                        <span class="none-1" style="float: right ;display: none;margin-right: 15px;cursor: pointer;color: #ff061c">收起</span>
                    </td>
                </tr>
            </table>

            <table border="1" id="none-1" style="width: 1350px;display: none" >
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">采购付款</td>
                    <td style="width:300px ;">
                        <span style="display: none">采购付款</span>
                        <a href="/ga/payment/purchase/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/purchase/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">劳务费付款</td>
                    <td style="width:300px ;">
                        <span style="display: none">劳务费付款</span>
                        <a href="/ga/payment/purchase/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/purchase/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">中标服务费</td>
                    <td style="width:300px ;">
                        <span style="display: none">中标服务费</span>
                        <a href="/ga/payment/purchase/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/purchase/list"  class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">保函费用付款</td>
                    <td style="width:300px ;">
                        <span style="display: none">保函费用付款</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目管理费</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目管理费</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">服务费付款</td>
                    <td style="width:300px ;">
                        <span style="display: none">服务费付款</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目部工资</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目部工资</span>
                        <a href="/ga/payment/salary/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/salary/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目交通费</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目交通费</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目差旅费</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目差旅费</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">财务提现费</td>
                    <td style="width:300px ;">
                        <span style="display: none">财务提现费</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">其他付款</td>
                    <td style="width:300px ;">
                        <span style="display: none">其他付款</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>                    </td>
                    <td style="width:150px ;;background-color: #efefef">利润分配</td>
                    <td style="width:300px ;">
                        <span style="display: none">利润分配</span>
                        <a href="/ga/payment/common/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/payment/common/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>                    </td>
                </tr>
            </table>
            <table border="1"  style="width: 1350px " >
                <tr style="height: 40px ;background-color: #4aa5d1;border-bottom: 0px ">
                    <td colspan="6" style="text-align: center">
                        <b>实收财务项(收入)</b>
                        <span class="block-2" style="float: right;margin-right: 15px;cursor: pointer;color: #ff061c; ">下拉</span>
                        <span class="none-2" style="float: right ;display: none;margin-right: 15px;cursor: pointer;color: #ff061c">收起</span>
                    </td>
                </tr>
            </table>
            <table border="1" id="none-2" style="width: 1350px;display: none" >
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目预付款收入</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目预付款收入</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >开票</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目进度款收入</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目进度款收入</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >开票</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目竣工验收款收入</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目竣工验收款收入</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >开票</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">合同增补款收入</td>
                    <td style="width:300px ;">
                        <span style="display: none">合同增补款收入</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >开票</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目财审结算款收入</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目财审结算款收入</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >开票</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">项目维保款收入</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目维保款收入</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >开票</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                </tr>
            </table>
            <table border="1"  style="width: 1350px " >
                <tr style="height: 40px ;background-color: #4aa5d1;border-bottom: 0px ">
                    <td colspan="6" style="text-align: center">
                        <b>税收项（支出）</b>
                        <span class="block-3" style="float: right;margin-right: 15px;cursor: pointer;color: #ff061c; ">下拉</span>
                        <span class="none-3" style="float: right ;display: none;margin-right: 15px;cursor: pointer;color: #ff061c">收起</span>
                    </td>
                </tr>
            </table>

            <table border="1" id="none-3" style="width: 1350px;display: none" >
                <tr style="height:40px;">
                <td style="width:150px ;;background-color: #efefef">地方教育费附加</td>
                <td style="width:300px ;">
                    <input style="width: 240px " name="name" readonly>
                </td>
                <td style="width:150px ;;background-color: #efefef">城建税</td>
                <td style="width:300px ;">
                    <input style="width: 240px " name="name" readonly>
                </td>
                <td style="width:150px ;;background-color: #efefef">教育费附加税</td>
                <td style="width:300px ;">
                    <input style="width: 240px " name="name" readonly>
                </td>
            </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">印花税（购部分）</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">印花税（销部分）</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">江海堤防费</td>
                    <td style="width:300px ;">
                        <input style="width: 240px "  name="name" readonly>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">应付增值税</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">应付企业所得税</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">增值税计算器</td>
                    <td style="width:300px ;">
                        <input style="width: 110px " class="vat" >
                        <!--2%1.5%-->
                        <span>=</span>
                        <input style="width: 110px "  class="vat-on" >
                        <span class="count-1">点击计算</span>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">实付增值税</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">实付企业所得税</td>
                    <td style="width:300px ;">
                        <input style="width: 240px " name="name" readonly>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">企业所得税计算器</td>
                    <td style="width:300px ;">
                        <input style="width: 110px " class="corporate-income"  >
                        <!--1.5%-->

                        <span>=</span>
                        <input style="width: 110px " class="corporate-income-on" >
                        <span class="count-2">点击计算</span>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">设备销项专用发票管理</td>
                    <td style="width:300px ;">
                        <span style="display: none">设备销项专用发票管理</span>
                        <!--<a href="/ga/openTicket/add" class="herf" style="width: 70px " >申请</a>-->
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 0px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">建安销项专用发票管理</td>
                    <td style="width:300px ;">
                        <span style="display: none">建安销项专用发票管理</span>
                        <!--<a href="/ga/openTicket/add" class="herf" style="width: 70px " >申请</a>-->
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 0px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">服务销项专用发票管理</td>
                    <td style="width:300px ;">
                        <span style="display: none">服务销项专用发票管理</span>
                        <!--<a href="/ga/openTicket/add" class="herf" style="width: 70px " >申请</a>-->
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 0px  " >查看</a>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">设备进项专用发票管理</td>
                    <td style="width:300px ;">
                        <span style="display: none">设备进项专用发票管理</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">建安进项专用发票管理</td>
                    <td style="width:300px ;">
                        <span style="display: none">建安进项专用发票管理</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">服务进项专用发票管理</td>
                    <td style="width:300px ;">
                        <span style="display: none">服务进项专用发票管理</span>
                        <a href="/ga/openTicket/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/openTicket/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                </tr>
            </table>
            <table border="1"  style="width: 1350px " >
                <tr style="height: 40px ;background-color: #4aa5d1;border-bottom: 0px ">
                    <td colspan="6" style="text-align: center">
                        <b>往来款</b>
                        <span class="block-4" style="float: right;margin-right: 15px;cursor: pointer;color: #ff061c; ">下拉</span>
                        <span class="none-4" style="float: right ;display: none;margin-right: 15px;cursor: pointer;color: #ff061c">收起</span>
                    </td>
                </tr>
            </table>
            <table border="1" id="none-4" style="width: 1350px;display: none" >

                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">往来款-现金</td>
                    <td style="width:300px ;">
                        <span style="display: none">往来款现金</span>
                        <a href="/ga/comego/add" class="herf herf3" style="width: 70px " >收入</a>
                        <a href="/ga/comego/add" class="herf herf2" style="width: 70px;margin-left: 15px " >支出</a>
                        <a href="/ga/comego/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">往来款-银行</td>
                    <td style="width:300px ;">
                        <span style="display: none">往来款银行</span>
                        <a href="/ga/comego/add" class="herf herf3" style="width: 70px " >收入</a>
                        <a href="/ga/comego/add" class="herf herf2" style="width: 70px;margin-left: 15px " >支出</a>
                        <a href="/ga/comego/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">保证金</td>
                    <td style="width:300px ;">
                        <span style="display: none">保证金</span>
                        <a href="/ga/comego/add" class="herf herf3" style="width: 70px;float: left " >收入</a>
                        <a href="/ga/comego/add" class="herf herf2" style="width: 70px;margin-left: 15px;float: left" >支出</a>
                        <a href="/ga/comego/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                </tr>

                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">项目质保押金</td>
                    <td style="width:300px ;">
                        <span style="display: none">项目质保押金</span>
                        <a href="/ga/comego/add" class="herf herf3" style="width: 70px " >收入</a>
                        <a href="/ga/comego/add" class="herf herf2" style="width: 70px;margin-left: 15px " >支出</a>
                        <a href="/ga/comego/list" class="herf" style="width: 70px;margin-left: 15px  " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">合约管理服务费</td>
                    <td style="width:300px ;">
                        <span style="display: none">合约管理服务费</span>
                        <a href="/ga/contract/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/contract/list" class="herf" style="width: 70px;margin-left: 15px   " >查看</a>
                    </td>
                    <td style="width:150px ;;background-color: #efefef">合约企业所得税</td>
                    <td style="width:300px ;">
                        <span style="display: none">合约企业所得税</span>
                        <a href="/ga/contract/add" class="herf" style="width: 70px " >申请</a>
                        <a href="/ga/contract/list" class="herf" style="width: 70px;margin-left: 15px   " >查看</a>
                    </td>
                </tr>
            </table>
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
</script>
</body>
</html>