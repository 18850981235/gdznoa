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
    <title>新建客户</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/customerInfo/customerInfoAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/bd/client/clientAdd.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        福建省广电智能系统集成工贸有限公司
    </p>
    <ul class="yiji-no">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name" style="display: none">
                <li>
                    <a class="upload" href="">
                        <span class="name-block"></span>
                        <span class="name-none" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close">
        <a class="close-in" href="">返回</a>
    </div>
</div>


<div id="page">

    <a class="page-right" >新建客户</a>
</div>
<!--新建客户-->
<div id="new"  >
    <div id="center">
        <form method="post" action="/bd/client/add.html" >
            <table border="1">
                <tr style="height: 50px ">
                    <td colspan="4" style="width: 650px;background-color: #efefef" >
                        <b>基本信息：</b>
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">客户名称：</td>
                    <td colspan="3">
                        <input style="width: 500px " required  name="name">
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">客户编号：</td>
                    <td>
                        <input id="Atanisi" style="width: 200px " name="code">
                    </td>
                    <td style="width: 85px;background-color: #efefef">所属部门：</td>
                    <td>
                        <select style="height: 30px" required name="deptid"  class="department">

                        </select>
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">单位类型：</td>
                    <td>
                        <select style="height: 30px ;width:185px ;" required name="unitType">
                            <option value="">请选择</option>
                            <option>政府</option>
                            <option>国有企业</option>
                            <option>事业单位</option>
                            <option>外资企业</option>
                            <option>民营企业</option>
                        </select>
                    </td>
                    <td style="width: 85px;background-color: #efefef">业务负责人：</td>

                    <td  >
                        <input class="Eliminate" name="aaa" required readonly >
                        <input class="Eliminate-no" style="display: none" name="userid" >
                        <a  class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空"  onClick="" type="reset">
                        </a>
                    </td>

                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">电话：</td>
                    <td>
                        <input style="width: 200px " name="phone">
                    </td>
                    <td style="width: 85px;background-color: #efefef">传真：</td>
                    <td>
                        <input style="width: 200px " name="fax" >
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">所在地区：</td>
                    <td colspan="3">
                        <input style="width: 400px " name="address" >
                    </td>

                </tr>
                <tr style="height: 55px ">
                    <td style="width: 120px;background-color: #efefef">客户业务内容：</td>
                    <td colspan="3">
                        <textarea cols="70" rows="3" style="border: 0px" name="content"></textarea>
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td colspan="4" style="width: 650px;background-color: #efefef">
                        财务信息：
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">税号：</td>
                    <td>
                        <input style="width: 200px " name="tfn">
                    </td>
                    <td style="width: 120px;background-color: #efefef">开户行：</td>
                    <td>
                        <input style="width: 220px " name="bankname">
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">对公帐号：</td>
                    <td>
                        <input style="width: 200px " name="bankaccount">
                    </td>
                    <td style="width: 120px;background-color: #efefef">开户地址：</td>
                    <td>
                        <input style="width: 220px "  name="bankaddress">
                    </td>
                </tr>
            </table>
            <input id="ok"  type="submit" value="确定" style="margin-left: 250px ">
            <a href="#" id="no" style="color: #333">取消</a>
        </form>
    </div>

</div>
</body>
</html>