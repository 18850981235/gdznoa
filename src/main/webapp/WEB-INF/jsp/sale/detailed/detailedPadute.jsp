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
    <title>销售合同清单修改</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <!--<link rel="stylesheet" href="<%=basePath%>/../layui/css/modules/laydate/default/laydate.css">-->
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/sale/detailed/detailedAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/../layui/lay/modules/laydate.js" type="text/javascript"></script>-->
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <script src="<%=basePath%>/js/sale/detailed/detailedPadute.js"></script>
    <base Target="_blank" />
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
<div id="content-in">
    <div id="center">
        <form  action="/mc/qualification/addImpl" method="post"  enctype="multipart/form-data">

            <table border="1">
                <tr style="height: 40px  ;background-color: #efefef">
                    <td colspan="4" style="text-align: center;width: 1200px">
                        <b>销售合同清单修改</b>
                        <input style="display:none;">
                    </td>
                </tr>

            </table>
            <div id="on">
                <div  >
                    <span>项目名称</span>
                    <select id="ap" style="height: 30px;width: 250px  " name="projectId">
                        <option value="">请选择</option>
                    </select>
                </div>
                <div  >
                    <span>分部名称</span>
                    <input style="width: 250px;height: 30px;border: 1px solid  " name="branchName">
                </div>
                <div  >
                    <span>系统名称</span>
                    <select class="systemId"   style="height: 30px;width: 120px  " name="systemId">
                        <option>请选择</option>
                    </select>

                    <span>分项名称</span>
                    <select  class="subitemId" style="height: 30px;width: 120px  " name="subitemId">
                        <option>请选择</option>
                    </select>
                </div>
                <div style="float: right;margin-top: 10px ">
                    <span>合计</span>
                    <input style="width: 250px;height: 30px;border: 1px solid  " name="total">
                </div>
            </div>
            <table  style="text-align: center">
                <tr style="height: 40px ;background-color:#c4de83 ">
                    <td style="width: 150px ">设备编码</td>
                    <td style="width: 150px ">名称</td>
                    <td style="width: 100px ">规格型号</td>
                    <td style="width: 100px ">参数</td>
                    <td style="width: 150px ">品牌</td>
                    <td style="width: 100px ">单位</td>
                    <td style="width: 100px ">数量</td>
                    <td style="width: 100px ">单价</td>
                    <td style="width: 100px ">小计</td>
                    <td style="width: 150px ">备注</td>
                </tr>
            </table>
            <table id="con" style="border: 1px solid">
                <tr style="height: 40px; ">
                    <td style="width: 150px; "><input style="width: 140px " name="code"></td>
                    <td style="width: 151px;"><input style="width: 143px " name="name"></td>
                    <td style="width: 100px; "><input style="width: 95px " name="model"></td>
                    <td style="width: 100px; "><input  style="width: 95px " name="parameter"></td>
                    <td style="width: 150px; ;padding: 3px "><select style="width: 140px ;height: 30px;margin-right: auto;margin-left: auto  " id="trademarkid" name="trademark"><option value="">请选择</option></select></td>
                    <td style="width: 100px; "><input style="width: 95px " name="unit"> </td>
                    <td style="width: 100px "><input style="width: 95px " name="num"></td>
                    <td style="width: 100px; "><input style="width: 95px " name="unitCost"></td>
                    <td style="width: 100px; "><input style="width: 95px " name="subtotal"></td>
                    <td style="width: 150px; "><input style="width: 140px " name="remarks"></td>
                </tr>
                <!--<tr style="height: 40px; "><td style="width: 150px; "><input style="width: 140px " name="code"></td><td style="width: 151px;"><input style="width: 143px " name="name"></td><td style="width: 100px; "><input style="width: 95px " name="model"></td><td style="width: 100px; "><input  style="width: 95px " name="parameter"></td><td style="width: 150px; ;padding: 3px "><select style="width: 140px ;height: 30px;margin-right: auto;margin-left: auto  " id="trademarkid" name="trademark"><option value="">请选择</option></select></td><td style="width: 100px; "><input style="width: 95px " name="unit"> </td><td style="width: 100px "><input style="width: 95px " name="num"></td><td style="width: 100px; "><input style="width: 95px " name="unitCost"></td><td style="width: 100px; "><input style="width: 95px " name="subtotal"></td><td style="width: 150px; "><input style="width: 140px " name="remarks"></td></tr>-->
            </table>
            <div style="display: block;height: 30px ;text-align: center;padding-top: 6px ">
                <span id="add">添加</span>
                <span id="remove">删除</span>
            </div>
            <input id="ok"  type="submit" value="确定" style="margin-left:520px ">
            <a href="#" id="no" >取消</a>
        </form>
    </div>
</div>
<!--<script type="text/javascript">-->
<!--laydate.render({-->
<!--elem: '#test1', //指定元素-->
<!--event: 'click',-->
<!--format: 'yyyy-MM-dd'-->
<!--});-->

<!--</script>-->
</body>
</html>