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
    <title>资历证书查询</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcCertificate/mcCertificateList.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/mc/mcCertificate/mcCertificateList.js"></script>
</head>
<body>
<div id="content-in">
    <div id="center">
        <div id="query-button">
            <div class="query-top">
                <div class="top1">
                    <span>证书名称</span>
                    <input class="listName name"  name="name">
                </div>

                <div class="top2">
                    <span>证书类型</span>
                    <select style="width: 100px;height: 30px;margin-top: 5px" class="type" name="type">
                        <option value="">请选择</option>
                        <option>类型1</option>
                        <option>类型2</option>
                    </select>
                </div>
                <div class="top3">
                    <span>证书级别内容</span>
                    <select style="width: 100px;height: 30px;margin-top: 5px" class="content" name="content">
                        <option value="">请选择</option>
                        <option>类型1</option>
                        <option>类型2</option>
                    </select>
                </div>
            </div>
            <div class="query-in">
                <div class="in1">
                    <span>证书借用情况</span>
                    <input class="borrow" name="borrow">
                </div>
                <div class="in2">
                    <span>证书状态</span>
                    <select style="width: 100px;height: 30px;margin-top: 5px" class="state" name="state">
                        <option value="">请选择</option>
                        <option>类型1</option>
                        <option>类型2</option>
                    </select>
                </div>
                <div class="in3">
                    <span>年审时间</span>
                    <input type="text"   placeholder="请选择日期" id="test1" class="staretime" name="staretime">
                    <span style="width:25px ;">-</span>
                    <input type="text"   placeholder="请选择日期" id="test2" class="endtime" name="endtime">
                </div>
            </div>
            <div class="query-button">
                <a  href="/mc/qualification/add" class="add">新增</a>
                <input value="快速查询"  type="submit" class="query"/>

            </div>
        </div>
        <div class="paging">
            <table   style="text-align: center">
                <tr class="seal" style="height: 40px;background-color: #c4de83; ">
                    <td style="width: 60px ">序号</td>
                    <td style="width: 200px ">证书名称</td>
                    <td style="width: 100px ">证书类型</td>
                    <td style="width: 100px ">证书状态</td>
                    <td style="width: 100px ">级别内容</td>
                    <td style="width: 100px ">管理负责人</td>
                    <td style="width: 150px ">证书借用情况</td>
                    <td style="width: 100px ">年审时间</td>
                    <td style="width: 100px ">PDF导出次数</td>
                    <td style="width: 130px ">操作</td>
                </tr>
            </table>
            <table class="sea2"  style="text-align: center">

            </table>
        </div>
        <div id="paginator-test"></div>
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
