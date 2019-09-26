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
    <title>合约项新建</title>
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
    <script src="<%=basePath%>/js/finance/contract/indexAdd.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <form action="/ga/harvestTicket/addHarvestTicket" method="post"  enctype="multipart/form-data">
            <table border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse" >
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center;background-color: #efefef">
                        <b>税收项新建</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef">项目名称</td>
                    <td   style="width:300px ;">
                        <input id="project" style="width: 270px  "  readonly >
                        <input id="projectid" style="width: 270px ;display: none" name="projectid"  >
                    </td>
                    <td style="width:150px ;;background-color: #efefef">类型</td>
                    <td  style="width:300px ;">
                        <select style="width: 200px ;height: 35px " name="companyName">
                            <option>请选择</option>
                            <option value="采购付款">采购付款</option>
                            <option value="劳务费付款">劳务费付款</option>
                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">事由</td>
                    <td  colspan="3" style="width:300px ;">
                        <input id="ferf" style="width: 270px " class="type" name="type" readonly >
                    </td>
                    <!--<td style="width:150px ;;background-color: #efefef">合同名称</td>-->
                    <!--<td    style="width:300px ;">-->
                    <!--<select id="ap" style="width:270px ;height: 35px  ">-->
                    <!--<option value="">请选择</option>-->
                    <!--</select>-->
                    <!--</td>-->
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">开票名称</td>
                    <td    style="width:300px ;">
                        <input  style="width: 270px  "  name="name" >
                    </td>
                    <td style="width:150px ;;background-color: #efefef">开票时间</td>
                    <td  style="width:300px ;">
                        <input  style="width: 270px " type="text" id="test1" placeholder="请点击选择" name="createtime">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">领款单位</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " class="type" name="accountname" >
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
                        <input style="width: 270px " name="cost">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">电话</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " name="phone">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">纳税人识别号</td>
                    <td  colspan="3" style="width:300px ;">
                        <input style="width: 270px " name="identifyNumber">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px;background-color: #efefef">开票说明</td>
                    <td colspan="3"  style="width:300px ;">
                        <input style="width: 800px " class="type"  name="content">
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
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">支付账户</td>
                    <td  style="width:300px ;">
                        <input style="width: 270px " class="type"  name="payaccount">
                    </td>
                    <td style="width:150px ;background-color: #efefef">收款账户信息</td>
                    <td style="width:300px ;">
                        <input style="width: 270px " name="proceedsaccount">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">发票上传</td>

                    <td colspan="3" style="width:300px ;">
                        <input style="width: 270px;display: inline-block " type="file"  name="file">
                        <a class="herf" onclick="clearMethod1()">清空</a>
                        <input style="display: none" name="inorout" value="开票">
                    </td>
                </tr>

            </table>



            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/ga/show" id="no"  >取消</a>
        </form>
    </div>
</div>
<script>
    //清空历史文件（上传文件）
    function clearMethod1() {
        var objFile=document.getElementsByTagName('input')[10];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
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