<%--
  Created by IntelliJ IDEA.
  User: lpy
  Date: 2019/1/9
  Time: 15:18
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
    <title>供应商新增</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/supplier/merchant/merchantAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <!--<script src="<%=basePath%>/js/public/department.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/responsible.js"></script>-->
    <!--<script src="<%=basePath%>/js/public/projectName.js"></script>-->
    <!--<script src="<%=basePath%>/js/mc/mcDispatch/mcDispatchAdd.js"></script>-->
    <script src="<%=basePath%>/js/public/pipelineNumber.js"></script>
    <script src="<%=basePath%>/js/public/brand.js"></script>
    <script src="<%=basePath%>/js/supplier/merchant/merchantAdd.js"></script>

</head>
<body>
<div id="choice7" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no7">
        <li style="display:block;">
            <a href="#" class="click"></a>
            <ul class="name7" style="display: block">
                <!--<li>-->
                <!--<a class="upload-noe" href="">-->
                <!--<span class="name-block7"></span>-->
                <!--<span class="name-none7" style="display: none"></span>-->
                <!--</a>-->
                <!--</li>-->
            </ul>
        </li>
    </ul>
    <div id="close7">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="content-in">
    <div id="center">
        <form action="/supplier/supplier2/addSupplier" method="post"  enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 40px ;background-color: #efefef">
                    <td colspan="4" style="text-align: center">
                        <b>供应商新增</b>
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;;background-color: #efefef">供应商名称</td>
                    <td  style="width:300px ;">
                        <input style="width: 280px " name="name">
                    </td>
                    <td style="width:150px ;;background-color: #efefef">供应商编号</td>
                    <td>
                        <input id="number" style="width: 280px " name="code">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>法定代表人</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="legalPerson">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>注册资本</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:270px ;" name="registeredCapital">
                    </td>
                </tr>
                <tr  style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">注册地址</td>
                    <td >
                        <input style="width: 280px " name="registeredAddress" >
                    </td>
                    <td style="width:150px ;background-color: #efefef;">成立时间</td>
                    <td >
                        <input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test1" name="establishTime">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>公司电话</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="phone">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>公司传真</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:270px ;" name="fax">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>公司邮箱</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="email">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>邮政编码</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:270px ;" name="postalCode">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>供应商类别</span>
                    </td>
                    <td style="width:300px ;">
                        <select style="width: 200px;height: 30px " name="type">
                            <option>产品制造商</option>
                            <option>代理商</option>
                            <option >系统集成商</option>
                            <option >工程商</option>
                            <option >技术服务商</option>
                        </select>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>供应商合作等级</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:280px" placeholder="非审核人员不可填" name="grade" >
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>品牌信息</span>
                    </td>
                    <td style="width:300px ;">

                        <input class="Eliminate-7" readonly style="width: 185px " >
                        <input style="display: none" class="Eliminate-no-7" name="trademark">
                        <a target="_blank " class="add-to7">添加</a>
                        <a class="clear-to7" >
                            <input value="清空" class="input7"  onClick="" type="button">
                        </a>
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>公司网址</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:270px ;" name="url">
                    </td>
                </tr>

                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>开户行</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="bankname">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>银行账号</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:270px ;" name="bankaccount">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>开户行地址</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width: 280px " name="bankaddress">
                    </td>
                    <td style="width:150px ;background-color: #efefef;">
                        <span>税号</span>
                    </td>
                    <td style="width:300px ;">
                        <input style="width:270px ;" name="tfn">
                    </td>
                </tr>
                <tr style="height:40px;">
                    <td style="width:150px ;background-color: #efefef;">
                        <span>企业证书</span>
                    </td>
                    <td colspan="3" style="width:300px ;">
                        <input type="file" style="width: 280px " name="file" multiple >
                    </td>
                </tr>
                <!--<tr style="height:40px;">-->
                <!--<td colspan="4" class="" style="text-align: center;background-color: #efefef;">-->
                <!--企业合作重大事件记录-->
                <!--<span class="block" style="float: right;margin-right: 15px;cursor: pointer;color: #ff061c; ">下拉</span>-->
                <!--<span class="none" style="float: right ;display: none;margin-right: 15px;cursor: pointer;color: #ff061c">收起</span>-->
                <!--</td>-->
                <!--</tr>-->
            </table>


            <div id="none" style="display: none">
                <table style="width: 900px ">
                    <tr style="height:40px;background-color: #efefef;text-align: center">
                        <td style="width:200px">时间</td>
                        <td colspan="3">记录</td>
                    </tr>
                </table>
                <table id="con" style="width: 900px ">
                    <tr style="height:40px;">
                        <td style="width:200px"><input style="width: 180px;text-align: center " placeholder="请输入时间" name=""></td>
                        <td colspan="3"> <input style="width:700px " placeholder="请输入" name=""></td>
                    </tr>
                </table>
                <div style="display: block;height: 30px ;text-align: center;padding-top: 6px ">
                    <span id="add" >添加</span>
                    <span id="remove" >删除</span>
                </div>
            </div>
            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/supplier/supplier2/query" id="no"  >取消</a>
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