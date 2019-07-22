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
    <title>客户详情</title>
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

<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
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

<div id="new"  >
    <div id="center">
        <form action="/bd/client/update.html" method="post">
            <table border="1">
                <tr style="height: 50px ">
                    <td colspan="4" style="width: 650px;background-color: #efefef" >
                        <b>基本信息：</b>
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">客户名称：</td>
                    <td colspan="3">
                        ${client.name}
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">客户编号：</td>
                    <td>
                        ${client.code}
                    </td>
                    <td style="width: 85px;background-color: #efefef">所属部门：</td>
                    <td>
                        ${client.dept.name}
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">单位类型：</td>
                    <td>
                        ${client.unitType}
                    </td>
                    <td style="width: 85px;background-color: #efefef">业务负责人：</td>

                    <td  >
                        ${client.user.name}
                    </td>

                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">电话：</td>
                    <td>
                        ${client.phone}
                    </td>
                    <td style="width: 85px;background-color: #efefef">传真：</td>
                    <td>
                        ${client.fax}
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">所在地区：</td>
                    <td colspan="3">
                        ${client.address}
                    </td>

                </tr>
                <tr style="height: 55px ">
                    <td style="width: 120px;background-color: #efefef">客户业务内容：</td>
                    <td colspan="3">
                        ${client.content}
                        <%--<textarea cols="70" rows="3" style="border: 0px "  name="content"> ${client.content}</textarea>--%>
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
                        ${client.tfn}
                    </td>
                    <td style="width: 120px;background-color: #efefef">开户行：</td>
                    <td>
                        ${client.bankname}
                    </td>
                </tr>
                <tr style="height: 46px ">
                    <td style="width: 120px;background-color: #efefef">对公帐号：</td>
                    <td>
                        ${client.bankaccount}
                    </td>
                    <td style="width: 120px;background-color: #efefef">开户地址：</td>
                    <td>
                        ${client.bankaddress}
                    </td>
                </tr>
            </table>
            <a href="/bd/client/query" id="no" style="color: #333">取消</a>

        </form>
    </div>

</div>
</body>
</html>