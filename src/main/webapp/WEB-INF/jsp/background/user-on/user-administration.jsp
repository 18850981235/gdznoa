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
    <title>后台模块</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/background/user-on/user.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/background/user-on/user-administration.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/position.js"></script>
    <!--<script src="<%=basePath%>/js/public/responsible.js"></script>-->
</head>
<body>
<div id="content-in">
    <div id="center">
        <!--<form  action="/mc/qualification/addImpl" method="post"  enctype="multipart/form-data">-->
        <div id="content">
            <div class="content-top">
                <div class="content-b">
                    <div id="con-1" class="label-b dian">
                        <span>个人信息</span>
                    </div>
                    <div id="con-2" class="label-b">
                        <span>权限信息</span>
                    </div>
                    <div id="con-3"  class="label-b">
                        <span>财务信息</span>
                    </div>
                    <div id="con-4"  class="label-b">
                        <span>账户与安全</span>
                    </div>
                    <div id="con-5"  class="label-b">
                        <span>私信</span>
                    </div>
                </div>
            </div>
            <div>

                    <div  id="form" class=" con con-1 " style="display: block"  >

                        <table class="con1" style="border: 1px solid;text-align: center">
                            <tr style="height: 40px ">
                                <td class="row">账号</td>
                                <td  class="row-1"><input class="row-i account" id="account" name="account"></td>
                                <td class="row">姓名</td>
                                <td class="row-1"><input class="row-i name" id="name" name="name"></td>
                            </tr>
                            <tr style="height: 40px ">
                                <td class="row">性别</td>
                                <td>
                                    <select class="sex" style="width: 100px;height: 30px " name="sex" id="sex">
                                        <option value="">请选择</option>
                                        <option value="1">男</option>
                                        <option value="0">女</option>
                                    </select>
                                </td>
                                <td class="row">工作电话</td>
                                <td>
                                    <input class="row-i workphone" id="workphone" name="workphone">
                                </td>
                            </tr>
                            <tr style="height: 40px ">
                                <td class="row">身份证号</td>
                                <td><input class="row-i IDnumber" name="IDnumber"></td>
                                <td class="row">QQ</td>
                                <td><input class="row-i QQ" name="QQ"></td>
                            </tr>
                            <tr style="height: 40px ">
                                <td class="row">手机</td>
                                <td><input class="row-i phone" name="phone"></td>
                                <td class="row">微信</td>
                                <td><input class="row-i weChat" name="weChat"></td>
                            </tr>
                            <tr style="height: 40px ">
                                <td class="row">专业证书</td>
                                <td><input class="row-i certificate" name="certificate"></td>
                                <td class="row">邮箱</td>
                                <td><input class="row-i email" id="email" name="email"></td>
                            </tr>
                            <tr style="height: 40px ">
                                <td class="row">生日</td>
                                <td><input style="text-align: center" type="text" class="britherday"   placeholder="请选择日期" id="test1" name="britherday"></td>
                                <td class="row">部门</td>
                                <td>
                                    <select class="department row-i deptid" style="width: 100px;height: 30px " name="deptid">
                                        <option value="">请选择</option>
                                    </select>
                                </td>
                            </tr>
                            <tr style="height: 40px ">
                                <td class="row">地址</td>
                                <td><input class="row-i address" name="address"></td>
                                <td class="row">职位</td>
                                <td>
                                    <input style="display: none" id="di" name="id">
                                    <select id="position" class="position row-i roleid" name="roleid">

                                    </select>
                                    <%--<input class="row-i " >--%>
                                    <%--<input style="display: none" class="roleid" name="roleid">--%>
                                </td>
                            </tr>
                        </table>
                        <input class="ok" type="submit" value="确定"  onclick="con1()" >
                        <a href="/sys/user/query" class="no" >返回</a>
                    </div>
                    <%--action="/user/useraction/updateMenu"--%>
                <div   class="con-2 con"  style="display:none;" >
                    <div class="" style=" display:inline-flex; justify-content: space-around;width: 100%">
                        <div class="con2-0" >
                            <span class="con2-1" >已拥有权限</span>
                            <div id="power" class="con2-2" >

                            </div>
                        </div>
                        <div style="width: 150px ;height: 200px ;text-align: center">
                            <span style="font-size: 15px ">申请权限</span>
                            <textarea id="Add" readonly style="height: 100px ;"></textarea>
                        </div>
                        <div id="wholee" class="con2-0" >
                            <span class="con2-1" >所有权限</span>
                            <div id="whole" class="con2-2"  >

                            </div>
                        </div>
                    </div>
                    <input id="array" style="display: none" name="array">
                    <input id="di2" name="userid" style="display: none">
                    <input  class="ok" id="cn" type="submit" style="margin-left: 520px " value="确定" >
                    <%--<a id="but" class="no"  >取消</a>--%>
                    <a href="/sys/user/query" class="no" >返回</a>
                </div>


                <form class="con-3 con" style="display: none" >
                    <div class="con3-on" style="padding-top: 40px;height: 400px  ">

                    </div>
                    <input class="ok"  type="submit" value="保存">
                    <a href="/sys/user/query" class="no" >返回</a>
                </form>
                <form class="con-4 con" style="display: none">
                    <div style="padding-top: 40px ;height: 400px ">

                        <div class="con4">
                            <span>设置新密码</span>
                            <input type="password" id="password1">
                        </div>
                        <div class="con4">
                            <span>确认新密码</span>
                            <input type="password" id="password2" name="password">
                            <span id="password4" style="display: none;font-size: 14px;color: #ff061c ">* 密码不一致</span>
                        </div>
                    </div>
                    <input class="ok"   type="submit" value="保存" onclick="con2()">
                    <a href="/sys/user/query" class="no" >返回</a>
                </form>
                <form class="con-5 con" style="display: none">
                    <div class="con5-on" >
                        <%--<div class="con5-in" >--%>
                            <%--<div>--%>
                                <%--<span class="co" ></span>--%>
                                <%--<span class="co"></span>--%>
                            <%--</div>--%>
                            <%--<span></span>--%>
                        <%--</div>--%>
                    </div>
                    <div class="con5-bu" >
                        <span  style="display: block;margin-bottom: 5px ">发送私信</span>
                        <textarea  name="content"></textarea>
                        <input  type="submit"  value="发送">
                    </div>

                </form>
                <form class="con-6" style="display: none">
                    <table  style="width:100%;border: 1px solid;margin-bottom: 20px ">
                        <tr class="con6" style="background-color: #efefef;">
                            <td colspan="4" style="width: 100%">权限申请</td>
                        </tr>
                        <tr class="con6" >
                            <td>申请人</td>
                            <%--<td><input class="name"><input class="id" style="display: none" name="userid"></td>--%>
                            <td>申请日期</td>
                            <td><input id="test2" type="text" placeholder="请选择时间" name="time" ></td>
                        </tr>
                        <tr class="con6">
                            <td>证明材料材料</td>
                            <td><input type="file" name="evidence"></td>
                            <td>证明人</td>
                            <td><input name="evidencePeople"></td>
                        </tr>
                        <tr class="con6">
                            <td>证明人联系方式</td>
                            <td><input style="width: 200px " name="evidencePhone"></td>
                            <td>联系电话</td>
                            <td><input style="width:150px ;" name="phone"></td>
                        </tr>
                        <tr class="con6">
                            <td>申请所需权限</td>
                            <td colspan="3"><input style="width: 400px " name="ermissions"></td>
                        </tr>
                    </table>
                    <input class="ok" style="margin-left: 240px;" type="submit" value="提交">
                    <a class="no" id="apply">取消</a>
                </form>
            </div>

        </div>


        <!--</form>-->
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
    function con1() {
        var email=$("#email").val();
        var account=$(".con-1 .account").val();
        var name=$(".con-1 .name").val();
        // var sex=$(".sex option").eq(0).val();
        var sex=$(".sex").val();
        var workphone=$(".con-1 .workphone").val();
        var IDnumber=$(".con-1 .IDnumber").val();
        var QQ=$(".con-1 .QQ").val();
        var phone=$(".con-1 .phone").val();
        var weChat=$(".con-1 .weChat").val();
        var certificate=$(".con-1 .certificate").val();

        var britherday=$(".con-1 .britherday").val();
        // var deptid=$(".deptid option").eq(0).val();
        var deptid=$(".deptid").val();
        var address=$(".con-1 .address").val();
        var roleid=$(".con-1 .roleid").val();
        var ermissions=$(".con-1 .ermissions").val();
        var di=$("#di").val();

        $.ajax({
            type: "post",
            url: "/user/useraction/adminUpdateUser",
            dataType: "text",
            data:{"account":account,"name":name,"sex":sex,"workphone":workphone,"IDnumber":IDnumber,"QQ":QQ,"phone":phone,"weChat":weChat,"certificate":certificate,"email":email,"britherday":britherday,"deptid":deptid,"address":address,"roleid":roleid,"ermissions":ermissions,"id":di},
            success: function (data) {
                if(data=="yes"){
                    alert("修改成功");
                    window.location.href="/user/user/updateUserPage?id="+id;
                }else{
                    alert("修改失败");
                    window.location.href="/user/user/updateUserPage?id="+id;
                }

            },
            // error:function (data) {
            //
            // }
        })
    }
    function con2() {
        var array=$("#array").val();
        var id=$("#di").val();
        $.ajax({
            type: "post",
            url: "/user/useraction/updateMenu",
            dataType: "text",
            data:{"array":array,"id":id},
            success: function (data) {
                if(data=="yes"){
                    alert("修改成功");
                    window.location.href="/user/user/updateUserPage?id="+id;
                }else{
                    alert("修改失败");
                    window.location.href="/user/user/updateUserPage?id="+id;
                }

            },
            // error:function (data) {
            //
            // }
        })
    }
</script>
</body>
</html>