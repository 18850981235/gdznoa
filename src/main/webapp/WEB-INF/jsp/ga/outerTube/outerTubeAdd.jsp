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
    <title>外经证新增</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/finance/outerTube/outerTubeAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/js/jquery.cookie.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <%--<script src="<%=basePath%>/js/public/department.js"></script>--%>
    <script src="<%=basePath%>/js/finance/outerTube/outerTubeAdd.js"></script>
</head>
<body>

<div id="content-in">
    <div id="center">
        <form action="/ga/outerTube/addouterTube" method="post"  enctype="multipart/form-data">
            <table border="1" style="width: 1000px ">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>外经证新增</b>
                        <input id="projectid" value="" style="display: none" name="projectid">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">申请人</td>
                    <td  style="width:300px ;">
                        <input style="width: 280px "   readonly>
                        <input style="width: 280px;display: none " name="userid"  value="1" >
                    </td>
                    <td style="width:150px ;background-color: #efefef">部门</td>
                    <td style="width:300px ;">
                        <select style="width: 200px ;height: 25px " class="department" name="deptid">
                            <option></option>
                        </select>
                       <input id="ferf" style="display: none;width: 200px " value="外经证申请" readonly>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">日期</td>
                    <td  style="width:300px ;">
                        <input style="width: 280px " type="text"   placeholder="请选择日期" id="test1" name="createtime">

                    </td>
                    <td style="width:150px ;;background-color: #efefef">要求及所需相关文件名称</td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="relevantDocument"  >
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">要求办理完成时间</td>
                    <td  style="width:300px ;">
                        <input style="width: 280px " type="text"   placeholder="请选择日期" id="test2" name="accomplishTime">

                    </td>
                    <td style="width:150px ;;background-color: #efefef">有效期 截止时间</td>
                    <td style="width:300px ;">
                        <input style="width: 280px " type="text"   placeholder="请选择日期" id="test3" name="validTime">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">收件人</td>
                    <td  style="width:300px ;">
                        <input style="width: 280px " name="consignee"  >
                    </td>
                    <td style="width:150px ;;background-color: #efefef">收件人电话</td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="consigneePhone"  >
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">收件人地址</td>
                    <td  style="width:300px ;">
                        <input style="width: 280px " name="consigneeAddress"  >
                    </td>
                    <td style="width:150px ;;background-color: #efefef">备注</td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="remark"  >
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">申请内容</td>
                    <td colspan="3"  style="width:300px ;">
                     <textarea style="width: 800px ;height: 45px " name="content"></textarea>
                    </td>

                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">附件内容</td>
                    <td colspan="3"  style="width:300px ;">
                        <input style="width: 280px;display: inline-block " type="file" name="file"  >
                        <a class="herf" onclick="clearMethod1()">清空</a>
                    </td>

                </tr>
            </table>


            <!--<div id="none" style="display: none">-->
                <!--<table style="width: 900px ">-->
                    <!--<tr style="height:40px;background-color: #efefef;text-align: center">-->
                        <!--<td style="width:200px">时间</td>-->
                        <!--<td colspan="3">记录</td>-->
                    <!--</tr>-->
                <!--</table>-->
                <!--<table id="con" style="width: 900px ">-->
                    <!--<tr style="height:40px;">-->
                        <!--<td style="width:200px"><input style="width: 180px;text-align: center " placeholder="请输入时间" name=""></td>-->
                        <!--<td colspan="3"> <input style="width:700px " placeholder="请输入" name=""></td>-->
                    <!--</tr>-->
                <!--</table>-->
                <!--<div style="display: block;height: 30px ;text-align: center;padding-top: 6px ">-->
                    <!--<span id="add" >添加</span>-->
                    <!--<span id="remove" >删除</span>-->
                <!--</div>-->
            <!--</div>-->

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
    //清空历史文件（上传文件）
    function clearMethod1() {
        var objFile=document.getElementsByTagName('input')[12];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
</script>
</body>
</html>