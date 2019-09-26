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
    <title>工程量增补详情</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/engineering/supplement/supplementAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <!--<script src="<%=basePath%>/js/public/pipelineNumber.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <script src="<%=basePath%>/js/engineering/supplement/supplementParticular.js"></script>
    <style>
        #center{
            display: inline-block;
            position: inherit;
            top: 10px ;
            left: calc(50% - 600px);
        }
    </style>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div >
            <table border="1">
                <tr style="height: 40px  ;background-color: #efefef">
                    <td colspan="4" style="text-align: center;width: 1200px">
                        <b>工程量增补清单详情</b>
                    </td>
                </tr>

            </table>
            <form id="on" style="height: 60px "   enctype="multipart/form-data">
                <span>项目名称</span>
                <!--<select id="ap" style="height: 30px;width: 250px  " name="projectId">-->
                <!--<option value="">请选择</option>-->
                <!--</select>-->

                <input id="ap" style="border: 1px solid ;width: 240px;height: 35px  " readonly>
                <%--<input id="api" style="display:none;  " >--%>
                <span>状态</span>
                <%--<input class="type" style="width: 200px ;height:35px">--%>
                <%--<select class="type" style="width: 200px ;height:35px " name="type">--%>
                    <%--<option value="新建清单">新增清单</option>--%>
                    <%--<option value="新建清单">减少清单</option>--%>
                <%--</select>--%>
                <input class="type" style="border: 1px solid ;width: 240px;height: 35px  " readonly>
                <span>系统名称</span>
                <%--<input class="systemId" style="width: 200px ;height:35px">--%>
                <%--<select class="systemId"  style="height: 30px;width: 200px  " name="system">--%>
                    <%--<option>请选择</option>--%>
                <%--</select>--%>
                <input class="systemId" style="border: 1px solid ;width: 240px;height: 35px  " readonly>

                <!--<input value="快速查询" type="submit" class="query"/>-->
                <!--<form id="uploadForm" enctype="multipart/form-data">-->
                <!--<input class="File" type="file" style="float: left;margin-top: 50px " name="file">-->
                <!--</form>-->
                <!--<input class="File" type="file" style="float: left;margin-top: 50px " name="file">-->
                <!--<input class="File-in" style="float: left; cursor: pointer;margin-top: 45px "  type="submit">-->
            </form>
            <!--<button id="upfile">上传文件</button>-->
            <!--<a onclick="clearMethod3()">清空</a>-->

            <table  style="text-align: center">
                <tr style="height: 40px ;background-color:#c4de83 ">
                    <td style="width: 40px; ">序号</td>
                    <td style="width: 130px ">设备编码</td>
                    <td style="width: 130px ">名称</td>
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
            <table border="1" id="con" style="height: 400px ;overflow: auto">
                <!--<tr class="huo" style="height: 40px;display:none; ">-->
                <!--<td style="width: 40px; ">serialnum</td>-->
                <!--<td style="width: 130px; ">code</td>-->
                <!--<td style="width: 131px;">name</td>-->
                <!--<td style="width: 100px; ">model</td>-->
                <!--<td style="width: 100px; ">parameter</td>-->
                <!--<td style="width: 150px;padding: 3px ">trademark</td>-->
                <!--<td style="width: 100px; ">unit</td>-->
                <!--<td style="width: 100px ">num</td>-->
                <!--<td style="width: 100px; ">unitCost</td>-->
                <!--<td style="width: 100px; ">subtotal</td>-->
                <!--<td style="width: 150px; ">remarks</td>-->
                <!--</tr>-->

                <!--<tr style="height: 40px; "><td style="width: 150px; "><input style="width: 140px " name="code"></td><td style="width: 151px;"><input style="width: 143px " name="name"></td><td style="width: 100px; "><input style="width: 95px " name="model"></td><td style="width: 100px; "><input  style="width: 95px " name="parameter"></td><td style="width: 150px; ;padding: 3px "><select style="width: 140px ;height: 30px;margin-right: auto;margin-left: auto  " id="trademarkid" name="trademark"><option value="">请选择</option></select></td><td style="width: 100px; "><input style="width: 95px " name="unit"> </td><td style="width: 100px "><input style="width: 95px " name="num"></td><td style="width: 100px; "><input style="width: 95px " name="unitCost"></td><td style="width: 100px; "><input style="width: 95px " name="subtotal"></td><td style="width: 150px; "><input style="width: 140px " name="remarks"></td></tr>-->
            </table>
            <!--<div style="float: right;margin-top: 10px ">-->
            <!--<span>合计</span>-->
            <!--<input class="he"  style="width: 250px;height: 30px;border: 1px solid  " readonly >-->

            <!--</div>-->
            <div style="float: right;margin-top: 10px ">
            <span id="dian" style="color: #ff061c">点击计算</span>
            <span>合计</span>
            <input id="heji"  class="he" style="width: 250px;height: 30px;border: 1px solid  "  >
            </div>



            <a href="/ed/quantity_manage/query"  id="no" style="margin-left: 600px ">取消</a>
        </div>
    </div>
</div>
</body>
</html>