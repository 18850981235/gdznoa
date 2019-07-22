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
    <title>原件借用申请</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcStamp/mcStampAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/projectName.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/mc/mcBorrow/mcBorrowAdd.js"></script>

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
<div id="choice4" style="display: none" >
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <div class="search">
        <input class="search-1" style="border: 1px solid">
        <input class="search-2"  type="button" value="搜索">
        <input class="search-3" type="button" value="返回">
    </div>
    <div class="choice4-con" style="display: none">
        <a class="noe">
            <p>资历证书</p>
        </a>
        <a class="tow">
            <p>业绩证书</p>
        </a>
    </div>
    <div class="noe-no" style="display: none">

    </div>
    <div class="tow-no">

    </div>
    <div class="on" style="text-align: center"></div>
    <div id="close4">
        <a class="close-in" >关闭</a >
    </div>
</div>
<div id="content-in">
    <div id="center">
        <form  action="/mc/borrow/add.html" method="post"  enctype="multipart/form-data">
            <table border="1">

                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>文件借用申请</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td  class="Color" style="width:150px  " required>
                        <span>项目名称</span>
                    </td>
                    <td colspan="3" style="width:300px ;">
                        <select class="projectname" style="height: 30px ; " name="projectid" required >
                            <option value="">
                                请选择
                            </option>
                        </select>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color" style="width:150px ">
                        <span>申请部门:</span>
                    </td>
                    <td style="width:300px ;">
                        <select class="department" style="width: 100px;height: 30px " name="deptid" required >
                            <option value="">
                                请选择
                            </option>
                        </select>
                    </td>
                    <td class="Color" style="width:150px ">申请日期:</td>
                    <td style="width:300px ;">
                        <input type="text" class="demo-input" placeholder="请选择日期" id="test1" style="width:280px " name="createtime" require  >
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td  class="Color"  style="width:150px  ">申请人</td>
                    <td >
                        <input class="" readonly  >
                        <input class="" style="display: none"  name="userid" required>
                    </td>
                    <td class="Color" style="width:150px  ">联系电话 </td>
                    <td style="width:300px ;">
                        <input style="width:280px " name="phone" required>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color" style="width:150px  ">申请原件内容</td>
                    <td colspan="3">
                        <textarea style="width: 700px ;height: 30px " name="content"></textarea>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color" style="width:150px  ">原件借用用途</td>
                    <td colspan="3">
                        <textarea style="width: 700px ;height: 40px " name="purpose"></textarea>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color"  style="width:150px  " >收件人</td>
                    <td  ><input style="width: 280px " name="consignee"></td>
                    <td class="Color" style="width:150px  ">收件人电话</td>
                    <td ><input style="width: 280px " name="consigneePhone" ></td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color" style="width:150px  ">原件寄往地址</td>
                    <td colspan="3">
                        <input style="width: 700px " name="sendAddress">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color"  style="width:150px  ">快递公司（归还）</td>
                    <td  ><input style="width: 280px " name="returnExpressageName"></td>
                    <td class="Color" style="width:150px  ">快递单号（归还）</td>
                    <td ><input style="width: 280px " name="returnExpressageWaybill" ></td>
                </tr>
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <span>(以下非申请人填写)</span>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color" style="width:150px  ">原件名称</td>
                    <td colspan="3">
                        <textarea class="Eliminate4" style="width: 600px ;height: 30px " name="name"></textarea>
                        <a target="_blank " class="add-to4">添加</a>
                        <a class="clear-to4" >
                            <input value="清空" class="input44"  onClick="" type="button">
                        </a>
                        <!--<input style="width: 700px " name="name">-->
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color"  style="width:150px  ">快递公司（寄出）</td>
                    <td  ><input style="width: 280px " name="sendExpressageName"></td>
                    <td class="Color" style="width:150px  ">快递单号（寄出）</td>
                    <td ><input style="width: 280px " name="sendExpressageWaybill" ></td>
                </tr>
                <tr style="height:40px;">
                    <td class="Color"  style="width:150px  ">原件寄出时间</td>
                    <td colspan="3" >
                        <input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test2"name="sendtime">
                    </td>
                </tr>

                <tr style="height:40px;">
                    <td class="Color" style="width:150px  ">原件归还时间</td>
                    <td style="width:300px ;" colspan="3">
                        <input  style="width:280px "   type="text" class="demo-input" placeholder="请选择日期" id="test3" name="returntime">
                    </td>
                </tr>

            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/borrow/query" id="no" >取消</a>
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