<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lpy
  Date: 2019/1/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>忘记密码</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <!--<link rel="stylesheet" href="<%=basePath%>/css/sign-in.css">-->
    <link rel="stylesheet" href="<%=basePath%>/css/register.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <!--<script src="<%=basePath%>/js/sign-in.js"></script>-->
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            height: 100%;
            width: 100%;
            background:url("<%=basePath%>/imgs/ob.jpg")no-repeat center ;
            z-index: 0;
            background-size: 100% 100%;
            position: relative;
        }

        #github-iframe {
            position: fixed;
            left: 32px;
            top: 32px;
        }

        #area-render {
            position: fixed;
            width: 320px;
            height: 160px;
            right: 4px;
            bottom: 4px;
            border: dashed 1px #ccc;
        }
        #logo{
            position: absolute;
            left: 70px  ;
            top:70px ;

        }
        #logo img{
            width: 170px ;
            height: 140px ;
        }

    </style>
</head>
<body>
<div id="github-iframe"></div>
<div id="top">

    <div id="logo"><img src="<%=basePath%>/imgs/logo.png"></div>


    <div id="on">

        <div class="in">
            <h3>互联网+运营管理系统</h3>
            <form >
                <!--<div class="conduct">-->
                <!--<div class="back-img">-->
                <!--<span>用户名</span>-->
                <!--</div>-->
                <!--<input placeholder="请输入用户名"   name="name">-->
                <!--<span class="co"> * 账号不存在</span>-->
                <!--</div>-->
                <div class="conduct div-phone" style="margin-bottom: 70px;margin-top: 40px;display:block;  ">
                    <div class="back-img">
                        <p>手机号</p>
                    </div>
                    <input type="text" id="phone" class="infos" placeholder="请输入手机" name="mobile" />
                </div>
                <div class="conduct div-phone div-phone1" style="margin-bottom: 100px;display:block; ">
                    <div class="back-img">
                        <p>验证码</p>
                    </div>
                    <input placeholder="请输入验证码"  id="ranks" style="width:120px ;"  name="verifyCode">
                    <a href="javascript:;" class="send1" onclick="ok()" >发送验证码</a>
                </div>
                <div class="conduct di" style="display: none;margin-bottom: 60px;margin-top: 40px">
                    <div class="back-img" style="text-align: center">
                        <span>密码</span>
                    </div>
                    <input placeholder="请输入新密码" class="password1"   type="password" >
                </div>
                <div class="conduct di" style="display:none;margin-bottom: 70px;  ">
                    <div class="back-img" style="text-align: center">
                        <span>密码</span>
                    </div>
                    <input placeholder="请再次输入密码" class="password2" type="password" >
                </div>
                <h5 class="password" style="margin-top: 45px;display: none;text-align: center;margin-bottom: 30px ;color: #ff061c ">* 请输入相同的密码</h5>
                <input value="修改"  type="button"  id="ok"  style="background-color:#0067b8 ;display: none">
                <input value="找回"  type="button" class="ok"  style="background-color:#0067b8;">
            </form>
            <div class="jump">
                <a href="/page/index">登录</a>
                <a class="retrieve">忘记密码</a>
            </div>
        </div>
        <!--<p class="bottom">福建省广电智能系统集成工贸有限公司@版权所有</p>-->
    </div>


</div>
<script type="text/javascript" color="255,255,255" pointColor="255,255,255" opacity='40' zIndex="-2" count="1" src="<%=basePath%>/canvas-nest.js-master/dist/canvas-nest.js"></script>
<script type="text/javascript" src="<%=basePath%>/canvas-nest.js-master/dist/canvas-nest.umd.js"></script>
<script>


        $("#phone").mouseleave(function () {
            var phone=$("#phone").val();
            $.ajax({
                type:"get",
                dataType:"text",
                url:"/page/isAccount.html",
                data:{"mobile":phone},
                success:function (data) {
                   if(data==1){
                       alert("没有该账号！")
                   }
                }
            });
        })

    $(".ok").click(function () {

        var mobile=$("input").eq(0).val();
        var name=$("input").eq(1).val();

        $.ajax({
            type:"get",
            dataType:"text",
            url:"/page/checkcode",
            data:{"name":name,"mobile":mobile},
            success:function (data) {
                if(data=="success"){
                 $(".conduct").hide();
                    $(".ok").hide();

                 $(".di").show();
                    $("#ok").show();
                }else if (data=="erreo") {
                    alert("验证码错误！")
                }else {
                    alert("失败，请重试！")
                }

            }
        });
    })
    $("#ok").click(function () {

        var mobile=$("input").eq(0).val();

        var password=$("input").eq(3).val();
        $.ajax({
            type:"get",
            dataType:"text",
            url:"/page/resetPassword",
            data:{"mobile":mobile,"password":password},
            success:function (data) {
                if(data=="erreo"){
                    alert("账号错误!");
                }else if(data=="success"){
                    alert("修改成功！")
                }else if(date=="failed"){
                    alert("修改失败！");
                }else{
                    alert("失败，请重试！")
                }


            }
        });
    })
    var cn = new CanvasNest(document.getElementById('area-render'), {
        color: '255,0,255',
        count: 5
    });
    //    $("body").on("click",".send1",function () {
    //        console.log(2);
    //    })
    //    $("send1").click(function () {
    //        console.log(1);
    //        sends.send();
    //    })
    function ok() {
        var phone=$(".conduct input").eq(0).val();
        $.ajax({
            type:"get",
            dataType:"text",
            url:"/page/sendSms.json",
            data:{"mobile":phone},
            success:function (data) {
                var html="";

                if(data=="success"){
                    send();
                }else if(data=="fail"){
                    alert("短信发送失败，请校验手机号！");
                }
            }
        });
    }
    var sends = {
        checked:1,

    }
    function send(){
        var numbers = /^1\d{10}$/;
        var val = $('#phone').val().replace(/\s+/g,""); //获取输入手机号码
        if($('.div-phone').find('span').length == 0 && $('.div-phone a').attr('class') == 'send1'){
            if(!numbers.test(val) || val.length ==0){
                $('.div-phone1').append('<span class="error">手机格式错误</span>');
                return false;
            }
        }
        if(numbers.test(val)){
            var time = 60;
            $('.div-phone span').remove();
            function timeCountDown(){
                if(time==0){
                    clearInterval(timer);
                    $('.div-phone a').addClass('send1').removeClass('send0').html("发送验证码");
                    sends.checked = 1;
                    return true;
                }
                $('.div-phone a').html(time+"S后再次发送");
                time--;
                return false;
                sends.checked = 0;
            }
            $('.div-phone a').addClass('send0').removeClass('send1');
            timeCountDown();
            var timer = setInterval(timeCountDown,1000);
        }
    }

    $(document).ready(function () {
        //判断密码是否相同
        $(".password2").mouseleave(function () {
            var password1=$(".password1").val();
            var password2=$(".password2").val();
            if(password1==password2){
                $("#ok").removeAttr("disabled");
                $("#password").css("display","none");
            }else {
                $("#ok").attr("disabled", "disabled");
                $("#password").css("display","block");
            }
        });
    })
</script>

</body>
</html>