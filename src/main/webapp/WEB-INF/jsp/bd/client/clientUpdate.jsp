<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22
  Time: 17:01
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
    <link rel="stylesheet" href="<%=basePath%>/css/customer-new.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/jump.js"></script>
    <script src="<%=basePath%>/js/jump-no.js"></script>
</head>

<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <a class="page-right">修改客户</a>
</div>
<!--新建客户-->
<div id="new">
    <form method="get" action="/bd/client/update.html">
        <input name="id" value="${client.id}" hidden="hidden">
        <table border="1">
            <tr style="height: 50px ">
                <td colspan="4" style="width: 650px;background-color: #c4de83">
                    <b>基本信息：</b>
                </td>
            </tr>
            <tr style="height: 46px ">
                <td style="width: 120px">客户名称：</td>
                <td colspan="3">
                    <input style="width: 500px " name="name" value="${client.name}">
                </td>
            </tr>
            <tr style="height: 46px ">
                <td style="width: 120px">客户编号：</td>
                <td>
                    <input style="width: 200px " name="code" value="${client.code}">
                </td>
                <td style="width: 85px">所属部门：</td>
                <td>
                    <select style="height: 30px " name="deptid" id="select">
                        <c:if test="${client.deptid!=null}">
                            <option value="${client.dept.id}">${client.dept.name}</option>
                        </c:if>
                </select>
                </td>
            </tr>
            <tr style="height: 46px ">
                <td style="width: 120px">单位类型：</td>
                <td>
                    <select style="height: 30px " name="unitType">
                        <option>请选择</option>
                        <option value="政府" <c:if test="${client.unitType=='政府'}"> selected="selected"</c:if> >政府</option>
                        <option value="国有企业" <c:if test="${client.unitType=='国有企业'}"> selected="selected"</c:if>>国有企业</option>
                        <option value="事业单位" <c:if test="${client.unitType=='事业单位'}"> selected="selected"</c:if>>事业单位</option>
                        <option value="外资企业" <c:if test="${client.unitType=='外资企业'}"> selected="selected"</c:if>>外资企业</option>
                        <option value="民营企业" <c:if test="${client.unitType=='民营企业'}"> selected="selected"</c:if>>民营企业</option>
                    </select>
                </td>
                <td style="width: 85px">业务负责人：</td>
                <td>
                    <textarea class="Eliminate" >${client.user.name}</textarea>
                    <input class="Eliminate-no" style="display: none" name="userid" value="${client.user.id}">
                    <a class="add-to">添加</a>
                    <a class="clear-to">
                        <input value="清空" onClick="" type="reset">
                    </a>
                </td>
            </tr>
            <tr style="height: 46px ">
                <td style="width: 120px">电话：</td>
                <td>
                    <input style="width: 200px " name="phone" value="${client.phone}">
                </td>
                <td style="width: 85px">传真：</td>
                <td>
                    <input style="width: 200px " name="fax" value="${client.fax}">
                </td>
            </tr>
            <tr style="height: 46px ">
                <td style="width: 120px">所在地区：</td>
                <td colspan="3">
                    <input style="width: 200px " name="address" value="${client.address}">
                </td>

            </tr>
            <tr style="height: 55px ">
                <td style="width: 120px">客户业务内容：</td>
                <td colspan="3">
                    <textarea cols="70" rows="3" name="content">${client.content}</textarea>
                </td>
            </tr>
            <tr style="height: 46px ">
                <td colspan="4" style="width: 650px;background-color: #c4de83">
                    财务信息：
                </td>
            </tr>
            <tr style="height: 46px ">
                <td style="width: 120px">税号：</td>
                <td>
                    <input style="width: 200px " name="tfn" value="${client.tfn}">
                </td>
                <td style="width: 85px">开户行：</td>
                <td>
                    <input style="width: 200px " name="bankname" value="${client.bankname}">
                </td>
            </tr>
            <tr style="height: 46px ">
                <td style="width: 120px">对公帐号：</td>
                <td>
                    <input style="width: 200px " name="bankaccount" value="${client.bankaccount}">
                </td>
                <td style="width: 85px">开户地址：</td>
                <td>
                    <input style="width: 200px " name="bankaddress" value="${client.bankaddress}">
                </td>
            </tr>
        </table>
        <input id="ok" type="submit" value="确定">
        <a href="#" id="no" style="color: #333">取消</a>

    </form>
</div>
</body>
</html>
<script type="text/javascript">
    $(function () {
            $.ajax(
                {
                    type: "get",
                    url: "/sys/dept/query.json",
                    dataType: "json",
                    success: function (data) {
                        var html = "<option value=''>请选择</option>";
                        for (var i = 0; i < data.length; i++) {
                            html += "<option value=" + data[i].id + ">" + data[i].name + "</option>";
                        }
                        $("#select").append(html);
                    }
                }
            )
        }
    )

</script>