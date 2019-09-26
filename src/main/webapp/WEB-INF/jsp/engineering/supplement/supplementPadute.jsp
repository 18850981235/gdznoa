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
    <title>工程量增补修改</title>
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
    <script src="<%=basePath%>/js/engineering/supplement/supplementPadute.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div >
            <table border="1" style="width: 1000px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>工程量增补修改</b>
                    </td>
                </tr>

            </table>
            <form id="on"  style="display: inline-block;height: 75px "  enctype="multipart/form-data">
                <span>项目名称</span>
                <select id="ap" style="height: 30px;width: 250px  " name="projectId">
                    <option value="">请选择</option>
                </select>
                <span>状态</span>
                <select class="type" style="width: 200px ;height:35px " name="type">
                    <option value="">请选择</option>
                    <option value="增加清单">增加清单</option>
                    <option value="减少清单">减少清单</option>
                    <option value="减少清单">项外增补清单</option>
                </select>
                <span>系统名称</span>
                <select class="systemId"  style="height: 30px;width: 120px  " name="system">
                    <option value="">请选择</option>
                </select>
                <!--<form id="uploadForm" enctype="multipart/form-data">-->
                <input class="File" type="file" style="float: left;margin-top: 50px " name="file">
                <!--</form>-->
                <!--<input class="File" type="file" style="float: left;margin-top: 50px " name="file">-->
                <!--<input class="File-in" style="float: left; cursor: pointer;margin-top: 45px "  type="submit">-->
            </form>
            <div>
                <input id="id" style="display: none">
                <button id="upfile">上传文件</button>
                <a onclick="clearMethod1()">清空</a>
            </div>
            <table border="0" style="width: 1000px;text-align: center;background-color:#c4de83 ">
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
            <table id="con" border="1" style="width: 1000px;text-align: center; ">
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
            </table>

            <div style="float: right;margin-top: 10px ">
                <span id="dian" style="color: #ff061c">点击计算</span>
                <span>合计</span>
                <input id="heji"  style="width: 250px;height: 30px;border: 1px solid  "  >

            </div>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="#" id="no"  >取消</a>
        </div>
    </div>
</div>
<script>
    //清空历史文件（上传文件）
    function clearMethod1() {
        var objFile=document.getElementsByTagName('input')[0];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
    function clearMethod2() {
        var objFile=document.getElementsByTagName('input')[6];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
    function clearMethod3() {
        var objFile=document.getElementsByTagName('input')[7];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
    function clearMethod4() {
        var objFile=document.getElementsByTagName('input')[8];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
</script>
</body>
</html>