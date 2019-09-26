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
    <script src="<%=basePath%>/js/background/user-on/user.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/position.js"></script>
    <!--<script src="<%=basePath%>js/public/responsible.js"></script>-->
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

                <form  id="form" class=" con con-1 " style="display: block"  >
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
                            <td><input class="row-i email" name="email"></td>
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
                                <select id="position" class="position row-i roleid" name="roleid">

                                </select>
                                <%--<input class="row-i " >--%>
                                <%--<input style="display: none" class="roleid" name="roleid">--%>
                            </td>
                        </tr>
                    </table>
                    <input class="ok" type="submit" value="确定" onclick="con1()" >
                    <a href="#" class="no" >取消</a>
                </form>

                <form class="con-2 con" style="display:none;" >
                    <div class="" style=" display:inline-flex; justify-content: space-around;width: 100%">
                        <div class="con2-0" >
                            <span class="con2-1" >已拥有权限</span>
                            <div id="power" class="con2-2" >

                            </div>
                        </div>
                        <div class="con2-0" >
                            <span class="con2-1" >全部权限</span>
                            <div id="whole" class="con2-2"  >

                            </div>
                        </div>
                    </div>
                    <!--<input class="ok"  type="submit" style="margin-left: 460px " value="确定" >-->
                    <a class="no" style="margin-left: 570px " id="apply-in">申请权限</a>
                    <!--<a href="#" class="no" >取消</a>-->
                </form>

                <form class="con-3 con" style="display: none" >
                    <div class="con3-on" style="padding-top: 40px;height: 400px  ">

                    </div>
                    <input class="ok" type="submit" type="submit" value="保存">
                    <a href="#" class="no" >取消</a>
                </form>
                <div class="con-4 con" style="display: none">
                    <div style="padding-top: 40px ;height: 400px ">
                        <div class="con4" >
                            <span>初始密码</span>
                            <input type="password" id="initial-password" >
                            <span id="password" style="display: none;font-size: 14px;color: #ff061c ">* 密码错误</span>
                        </div>
                        <div class="con4">
                            <span>设置新密码</span>
                            <input type="password" id="password1">
                        </div>
                        <div class="con4">
                            <span>确认新密码</span>
                            <input type="password" id="password2" name="password">
                            <span  id="password4" style="display: none;font-size: 14px;color: #ff061c ">* 密码不一致</span>
                        </div>
                    </div>
                    <input class="ok" type="submit"   value="保存" onclick="con4()">
                    <a href="#" class="no" >取消</a>
                </div>

                <form  href="/Talking/Talking/sentTalking" class="con-5 con" style="display: none">
                    <div class="con5-on" >

                    </div>
                    <div class="con5-bu" >
                        <span  style="display: block;margin-bottom: 5px ">发送私信</span>
                        <textarea class="content"  name="content"></textarea>
                        <input class="contentId" style="display: none">
                        <input id="con5" type="submit"  value="发送" >
                    </div>

                </form>
                <div class="con-6" style="display: none">
                    <table  style="width:100%;border: 1px solid;margin-bottom: 20px ">
                        <tr class="con6" style="background-color: #efefef;">
                            <td colspan="4" style="width: 100%">权限申请</td>
                        </tr>
                        <tr class="con6" >
                            <td>申请人</td>
                            <td><input class="name"><input id="userid" class="id userid" style="display: none" name="userid"></td>
                            <td>申请日期</td>
                            <td><input id="test2" class="time" type="text" placeholder="请选择时间" name="time" ></td>
                        </tr>
                        <tr class="con6">
                            <td>证明材料材料</td>
                            <td><input type="file" id="evidence" class="evidence" name="evidence"></td>
                            <td>证明人</td>
                            <td><input id="evidencePeople" class="evidencePeople" name="evidencePeople"></td>
                        </tr>
                        <tr class="con6">
                            <td>证明人联系方式</td>
                            <td><input style="width: 200px " id="evidencePhone" class="evidencePhone" name="evidencePhone"></td>
                            <td>申请人联系电话</td>
                            <td><input style="width:150px ;" id="phone" class="phone" name="phone"></td>
                        </tr>
                        <tr class="con6">
                            <td>申请所需权限</td>
                            <td colspan="3"><input style="width: 400px " id="ermissions" class="ermissions" name="ermissions"></td>
                        </tr>
                    </table>
                    <input id="con6" class="ok" style="margin-left: 240px;" type="submit"  value="提交" onclick="con6()">
                    <a class="no" id="apply">取消</a>
                </div>
                <div class="con-7 con"  style="display: none" >
                    <h3>未查看信息</h3>
                    <ul id="no-viewed">
                        <!--<li>-->
                        <!--<span style="font-size: 16px ">谁谁谁</span>-->
                        <!--<input class="viewed" style="display: none" value="">-->
                        <!--<input  type="submit" class="ok in-viewed" style="float: right;margin: 0px 350px 0px 0px" value="查看">-->
                        <!--</li>-->
                    </ul>
                </div>
            </div>

        </div>


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
        var email=$(".con-1 .email").val();
        $.ajax({
            type: "post",
            url: "/user/useraction/updateUser",
            dataType: "text",
            data:{"account":account,"name":name,"sex":sex,"workphone":workphone,"IDnumber":IDnumber,"QQ":QQ,"phone":phone,"weChat":weChat,"certificate":certificate,"email":email,"britherday":britherday,"deptid":deptid,"address":address,"roleid":roleid,"ermissions":ermissions},
            success: function (data) {
                if(data=="yes"){
                    alert("修改成功！")
                     window.location.reload()
                }else {
                    alert("修改失败！")
                    window.location.reload()
                }
            },
            // error:function (data) {
            //     alert("加载失败！请关闭后重试！")
            //     window.location.reload()
            // }
        })
    }


    function con6() {
        var ermissions=$("#ermissions").val();
        var userid=$("#userid").val();
        var time=$("#test2").val();
        var evidence=$("#evidence").val();
        var evidencePeople=$("#evidencePeople").val();
        var evidencePhone=$("#evidencePhone").val();
        var phone=$("#phone").val();
        console.log(userid);
        console.log(time);
        console.log(evidencePeople);
        console.log(evidencePhone);
        console.log(phone);
        $.ajax({
            type: "post",
            url: "/user/useraction/queryRequestspbymyselef",
            dataType: "text",
            data:{"userid":userid,"time":time,"evidence":evidence,"evidencePeople":evidencePeople,"evidencePhone":evidencePhone,"phone":phone,"ermissions":ermissions},
            success: function (data) {
                if(data=="已有"){
                    alert("你已经提交过申请，请等待管理员处理！")
                    window.location.href="/user/user/updateself";
                }else if(data=="成功"){
                    alert("申请成功")
                    window.location.href="/user/user/updateself";
                }else if(data=="失败"){
                    alert("申请失败")

                }

            },

        })
    }
</script>
</body>
</html>