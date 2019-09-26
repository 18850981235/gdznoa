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
    <title>部门管理</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/background/user/department.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <script src="<%=basePath%>/js/public/department.js"></script>
    <!--<script src="<%=basePath%>/js/background/user/userList.js"></script>-->
</head>
<body>
<div id="content-in">
    <div id="center">
        <table border="1">
            <tr style="height: 40px ;background-color: #efefef">
                <td colspan="4" style="text-align: center;width: 800px ">
                    <b>部门管理</b>
                </td>
            </tr>
        </table>
        <div style="display: flex">
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">已有的部门</span>
                <ul id="dept">

                </ul>
            </div>
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">新增部门</span>
                <input id="Add" style="border: 1px solid;width: 150px ;height: 25px;display: block ;margin-left: auto;margin-right: auto" placeholder="增加部门名称" >
                <input id="Add-in" class="ok" style="margin-left: 70px;margin-top: 15px " type="submit" value="添加">
            </div>
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">修改部门</span>
                <select id="change" class="department" style="display: block;width: 150px ;height: 25px;margin-left: auto;margin-right: auto">

                </select>
                <input id="change-on" style="border: 1px solid;width: 150px ;height: 25px;display: block ;margin-left: auto;margin-right: auto;margin-top: 10px " placeholder="修改部门名称" >
                <input id="change-in" class="ok" style="margin-left: 70px;margin-top: 15px " type="submit" value="修改">
            </div>
            <div style="width:200px;text-align: center ;display: inline-block ; ">
                <span style="font-size: 18px ">删除部门</span>
                <select id="delete" class="department" style="display: block;width: 150px ;height: 25px;margin-left: auto;margin-right: auto">

                </select>
                <!--<input id="delete" style="border: 1px solid;width: 150px ;height: 25px;display: block;margin-left: auto;margin-right: auto ">-->
                <input id="delete-in" class="ok" style="margin-left: 70px;margin-top: 15px " type="submit" value="删除">
            </div>
        </div>


    </div>
</div>
<script>
    $(document).ready(function () {
        //所有部门
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/sys/dept/query.json",
            success:function (data) {
                var names=data;

                $.each(names,function (index,obj) {
                    var html="";
                    html+='<li>'+obj.name+'</li>';
                    $("#dept").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                });
            }
        });

        //点击增加
        $(document).on("click","#Add-in",function () {
            var Add=$("#Add").val();
            $.ajax({
                type: "post",
                url: "/sys/dept/addDept",
                dataType: "text",
                data:{"name":Add},
                success: function (data) {
                    if(data=="yes"){
                        alert("增加成功")
                        window.location.href="/sys/dept/query";
                    }else if(data=="nothing"){
                        alert("请输入数据！")
                        window.location.href="/sys/dept/query";
                    }
                    else {
                        alert("增加失败");
                        window.location.href="/sys/dept/query";
                    }
                },
                error:function (data) {

                }
            })
        })
        //点击修改
        $(document).on("click","#change-in",function () {
            var Change=$("#change").val();
            var Changeno=$("#change-on").val();

            $.ajax({
                type: "post",
                url: "/sys/dept/updateDept",
                dataType: "text",
                data:{"id":Change,"name":Changeno},
                success: function (data) {
                    if(data=="yes"){
                        alert("修改成功")
                        window.location.href="/sys/dept/query";
                    }else if(data=="nothing"){
                        alert("请输入数据！")
                        window.location.href="/sys/dept/query";
                    }else {
                        alert("修改失败")
                        window.location.href="/sys/dept/query";
                    }
                },
                error:function (data) {

                }
            })
        })
        //点击删除
        $(document).on("click","#delete-in",function () {
            var Delete=$("#delete").val();
//          var delete=$("#delete").val();
            $.ajax({
                type: "post",
                url: "/sys/dept/deleteDept",
                dataType: "text",
                data:{"id":Delete},
                success: function (data) {
                    if(data=="yes"){
                        alert("删除成功")
                        window.location.href="/sys/dept/query";
                    }else if(data="no"){
                        alert("删除失败")
                        window.location.href="/sys/dept/query";
                    }else{
                        alert("删除失败,该分支下有人，不可删除！")
                        window.location.href="/sys/role/query";
                    }
                },
                error:function (data) {

                }
            })
        })
    })
</script>
</body>
</html>