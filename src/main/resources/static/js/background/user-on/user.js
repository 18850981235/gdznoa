(function () {


        // $.getJSON("http://192.168.1.236:8080/user/useraction/getallMenuanduser?quesid=2&userid=15",
        // function (date) {
        //
        //     var sysmenu=date.ListAuthority.sysmenu;
        //         $.each(date.ListAuthority, function (i, qq) {
        //
        //             var  l=date.ListAuthority;
        //             // for(we=0;w<l.length;we++){
        //             //     $.each(date.ListAuthority.sysmenu, function (o, menu) {
        //                     html+='<ul class="yiji">';
        //                     if (qq.sysmenu.levels==1) {
        //                         console.log(1)
        //                         console.log(qq.sysmenu.name)
        //                         html += "<li>   <input class='box' type='checkbox' value="+qq.sysmenu.name+"> "+ qq.sysmenu.name+"";
        //                         // "<a href='#' class='inactive'>" + menu.name + "</a>";
        //                         html += "<input style='display: none' value="+qq.sysmenu.id+">";
        //                         html += "<ul style='margin-left: 20px '>";
        //                         $.each(date.ListAuthority, function (i, menu2) {
        //                             console.log(2)
        //                             console.log(menu2.sysmenu.name)
        //                                 if (menu2.sysmenu.levels == 2 && menu2.sysmenu.pcode == qq.sysmenu.code) {
        //                                     html +=   " <li>";
        //                                     html +=  "<input class='box2' type='checkbox' value="+menu2.sysmenu.name+"> "+ menu2.sysmenu.name+"";
        //                                     // html +=  "<a href='" + url2 + "' class='inactive'>" + menu2.name + "</a>";
        //                                     html += "<input style='display: none' value="+menu2.sysmenu.id+">";
        //                                     html +=  "</li>" ;
        //                                 }
        //                             }
        //                         )
        //                         html +=  " </ul>";
        //                         html += "</li>";
        //                     }
        //                     html+='</ul>';
        //                 // })
        //             // }
        //
        //         })
        //         $("#power").prepend();//prepend//append
        //     })
        // $.getJSON("/user/useraction/getallMenuanduser?quesid=3&userid=16",
        // function (date) {
        //             $.each(date.listMenu, function (i, menu) {
        //                     if (menu.levels == 1) {
        //                         html+='<ul class="yiji">';
        //                         html += "<li>   <input class='box' type='checkbox' value="+menu.name+"> "+ menu.name+"";
        //                         // "<a href='#' class='inactive'>" + menu.name + "</a>";
        //                         html += "<ul style='margin-left: 20px '>";
        //                         $.each(date.listMenu, function (i, menu2) {
        //                                 if (menu2.levels == 2 && menu2.pcode == menu.code) {
        //                                     var url2 = "";
        //                                     var flge = true;
        //                                     $.each(date.authority, function (i, auth) {
        //                                         if (menu2.id == auth.menu) {
        //                                             url2 = menu2.url;
        //                                             flge = false;
        //                                             return false;
        //                                         }
        //                                     })
        //                                     if (flge) {
        //                                         url2 = "javascript:void(0);";
        //                                     }
        //                                     if (menu2.url == "" || menu2.url == null) {
        //                                         url2 = "javascript:void(0);";
        //                                     }
        //
        //                                     html +=   " <li>";
        //
        //                                     html +=  "<input class='box2' type='checkbox' value="+menu2.name+"> "+ menu2.name+"";
        //                                     // html +=  "<a href='" + url2 + "' class='inactive'>" + menu2.name + "</a>";
        //                                     html +=  "</li>" ;
        //                                 }
        //                             }
        //                         )
        //                         html +=  " </ul>";
        //                         html += "</li>";
        //                         html+='</ul>';
        //                     }
        //                 }
        //             )
        //             $("#whole").append(html);
        //         })


    function ioq() {
        input=ture;
    }
    $(document).ready(function () {

        $.ajax({
            type:"post",
            url:"/user/useraction/queryUserbySelf",
            dataType:"json",
            success:function (data) {
                var html = "";
                html +='<div class="con3" >';
                html +='<span style="margin-right: 30px ">账户余额:</span>';
                html +='<span style="">'+data.balance+'</span>';
                html +='<span>人民币</span>';
                html +='<a >充值</a>';
                html +='<a class="con3no-a">账单</a>';
                html +='</div>';
                html +='<div  class="con3no"  style="display: none;">';
                html +='<table class="ta"  style="text-align: center;">';
                html +='<tr style="height: 30px ">';
                html +='<td style="width: 120px ">时间</td>';
                html +='<td style="width: 120px">交易对象</td>';
                html +='<td style="width: 120px">类型</td>';
                html +='<td style="width: 120px">金额</td>';
                html +='</tr>';
                $.ajax({
                    type:"post",
                    url:"/user/useraction/queryUserBillbyId",
                    dataType:"json",
                    success:function (data) {
                        var html = "";
                        var sys=data.SysUserBill;
                        $.each(sys,function (index,obj) {
                            html +='<tr style="height: 30px ">';
                            html +='<td>'+obj.tradeDate+'</td>';
                            html +='<td>'+obj.reciprocal+'</td>';
                            html +='<td>'+obj.type+'</td>';
                            html +='<td>'+obj.amount+'</td>';
                            html +='</tr>';

                        })
                        $(".ta").append(html);//append() 方法在被选元素的结尾插入指定内容。
                        // prepend()方法在被选元素的开头插入指定内容
                    }
                })


                html +='</table>';
                html +='<span class="con3no-b" >关闭</span>';
                html +='</div>';
                html +='<div class="con3" >';
                html +='<span style="margin-right: 30px ">关联卡号</span>';
                html +='<input style="width: 250px;border: 1px solid " name="bankaccount1" value='+data.bankaccount1+' >';
                html +='<span style="margin-right: 20px ;margin-left: 30px ">银行</span>';
                html +=' <select name="bank2" style="height:30px;width: 250px ">';
                html +='<option>'+data.bank1+'</option>';
                html +='<option>中国银行</option>';
                html +=' <option>厦门银行</option>';
                html +=' <option>华夏银行</option>';
                html +=' <option>工商银行</option>';
                html +='<option>建设银行</option>';
                html +='</select>';
                html +='</div>';

                    $(".con3-on").prepend(html);//append() 方法在被选元素的结尾插入指定内容。
                // prepend()方法在被选元素的开头插入指定内容


            }
        })
        $.ajax({
            type:"post",
            url:"/user/useraction/queryUserbySelf",
            dataType:"json",
            success:function (data) {
                var html="";
                $(".con1 input").eq(0).val(data.account);
                $(".con1 input").eq(1).val(data.name);
                $(".con1 input").eq(2).val(data.workphone);
                $(".con1 input").eq(3).val(data.iDnumber);
                $(".con1 input").eq(4).val(data.qQ);
                $(".con1 input").eq(5).val(data.phone);
                $(".con1 input").eq(6).val(data.weChat);
                $(".con1 input").eq(7).val(data.certificate);

                $(".con1 input").eq(8).val(data.email);
                $(".con1 input").eq(9).val(data.britherday);
                $(".department option").eq(0).val(data.dept.id);
                $(".department option").eq(0).text(data.dept.name);

                $(".con1 input").eq(10).val(data.address);
                // $(".con1 input").eq(11).val(data.role.name);
                // $(".con1 input").eq(12).val(data.role.id);
                $("#position option").eq(0).val(data.role.id);
                $("#position option").eq(0).text(data.role.name);

                // $(".con1 select").eq(0).$("option").eq(0).text(data.sex);
                if(data.sex==1){
                    $(".sex option").eq(0).val(data.sex);
                    $(".sex option").eq(0).text("男");
                }else {
                    $(".sex option").eq(0).val(data.sex);
                    $(".sex option").eq(0).text("女");
                }

            }
        })


        $.ajax({
            type:"post",
            url:"/Talking/Talking/enterTalking",
            dataType:"json",
            success:function (data) {

                var html = "";
                var pubtalking=data.PubTalking;
                html+='<div class="con5-in" >';
                $.each(data.PubTalking,function (index,obj) {
                    html+=' <div>';
                    html+='  <span class="co" >'+obj.oriuser.name+'</span>';
                    html+='  <span class="co">'+obj.time+'</span>';
                    html+=' </div>';
                    html+='  <span>'+obj.content+'</span>';

                })
                html+=' </div>';
                $(".con5-on").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

            }
        })

        $.ajax({
            type:"post",
            url:"/user/useraction/queryAllMunebymyselef",
            dataType:"json",
            success:function (date) {

                var html = "";
                var sysmenu=date.ListAuthority.sysmenu;
                $.each(date.ListAuthority, function (i, qq) {

                    // for(we=0;w<l.length;we++){
                    //     $.each(date.ListAuthority.sysmenu, function (o, menu) {
                    html+='<ul class="yiji">';
                    if (qq.sysmenu.levels==1) {

                        html += "<li>   <input class='box' type='checkbox' value="+qq.sysmenu.id+"> "+ qq.sysmenu.name+"";
                        // "< a href=' ' class='inactive'>" + menu.name + "</ a>";
                        html += "<ul style='margin-left: 20px '>";
                        $.each(date.ListAuthority, function (i, menu2) {
                                if (menu2.sysmenu.levels == 2 && menu2.sysmenu.pcode == qq.sysmenu.code) {
                                    html +=   " <li>";
                                    html +=  "<input class='box2' type='checkbox' value="+menu2.sysmenu.id+"> "+ menu2.sysmenu.name+"";
                                    // html +=  "< a href='" + url2 + "' class='inactive'>" + menu2.name + "</ a>";
                                    html +=  "</li>" ;
                                }
                            }
                        )
                        html +=  " </ul>";
                        html += "</li>";
                    }
                    html+='</ul>';
                    // })
                    // }

                })
                $("#power").append(html);
            }
        })

        $.ajax({
            type:"post",
            url:"/user/useraction/queryAllMunebymyselef",
            dataType:"json",
            success:function (date) {
                var html = "";
                $.each(date.listMenu, function (i, menu) {

                        if (menu.levels == 1) {
                            html+='<ul class="yiji">';
                            html += "<li>   <input class='box' type='checkbox' value="+menu.name+"> "+ menu.name+"";
                            // "<a href='#' class='inactive'>" + menu.name + "</a>";
                            html += "<ul style='margin-left: 20px '>";
                            $.each(date.listMenu, function (i, menu2) {
                                    if (menu2.levels == 2 && menu2.pcode == menu.code) {
                                        var url2 = "";
                                        var flge = true;
                                        $.each(date.authority, function (i, auth) {
                                            if (menu2.id == auth.menu) {
                                                url2 = menu2.url;
                                                flge = false;
                                                return false;
                                            }
                                        })
                                        if (flge) {
                                            url2 = "javascript:void(0);";
                                        }
                                        if (menu2.url == "" || menu2.url == null) {
                                            url2 = "javascript:void(0);";
                                        }

                                        html +=   " <li>";

                                        html +=  "<input class='box2' type='checkbox' value="+menu2.name+"> "+ menu2.name+"";
                                        // html +=  "<a href='" + url2 + "' class='inactive'>" + menu2.name + "</a>";
                                        html +=  "</li>" ;
                                    }
                                }
                            )
                            html +=  " </ul>";
                            html += "</li>";
                            html+='</ul>';
                        }
                    }
                )
                $("#whole").append(html);
            }
        })
        // w();


        $(document).on("click","#con-1",function () {
            $(".con-1").show();
            $("#con-1").addClass("dian");
            $(".con-1").siblings().hide();
            $("#con-1").siblings().removeClass("dian");
        })
        $(document).on("click","#con-2",function () {
            $(".con-2").show();
            $("#con-2").addClass("dian");
            $(".con-2").siblings().hide();
            $("#con-2").siblings().removeClass("dian");
        })
        $(document).on("click","#con-3",function () {
            $(".con-3").show();
            $("#con-3").addClass("dian");
            $(".con-3").siblings().hide();
            $("#con-3").siblings().removeClass("dian");
        })
        $(document).on("click","#con-4",function () {
            $(".con-4").show();
            $("#con-4").addClass("dian");
            $(".con-4").siblings().hide();
            $("#con-4").siblings().removeClass("dian");
        })

        $(document).on("click","#con-5",function () {
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/user/useraction/queryUserbySelf",

                success:function (data) {

                    if(data.id=="1"){
                        $(".con-7").show();
                        $("#con-5").addClass("dian");
                        $(".con-7").siblings().hide();
                        $("#con-5").siblings().removeClass("dian");
                        $("#no-viewed").html(value="");
                        $("#con5").removeClass("con5");
                        $("#con5").addClass("con10");
                        $.ajax({
                            type:"post",
                            dataType:"json",
                            url:"/Talking/Talking/getNewContent",
                            success:function (data){
                                var html = "";
                                $.each(data, function (index, obj) {
                                    html += '<li>';
                                    html += '<span style="font-size: 16px ">'+obj.oriuser.name+'</span>';
                                    html += ' <input class="viewed" style="display: none" value='+obj.oriuser.id+'>';
                                    html += ' <input  type="submit" class="ok in-viewed" style="float: right;margin: 0px 350px 0px 0px" value="查看">';
                                    html += '</li>';
                                })
                                $("#no-viewed").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

                            }
                        })
                    }else {
                        $(".con-5").show();
                        $("#con-5").addClass("dian");
                        $(".con-5").siblings().hide();
                        $("#con-5").siblings().removeClass("dian");
                        $("#con5").removeClass(".con10");
                        $("#con5").addClass(".con5");
                    }
                }
            });
        });
        $(document).on("click",".in-viewed",function () {
            var viewed=$(this).siblings(".viewed").val();

            $(".con-5").show();
            $(".con-7").hide();
            $(".con5-on").html(value="");
            $(".contentId").val(viewed)
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/Talking/Talking/enterTalkingwhih",
                data:{"userId":viewed},
                success:function (data) {

                    var html = "";
                    var pubtalking = data.PubTalking;
                    $.each(pubtalking, function (index, obj) {

                        html += '<div class="con5-in" >';
                        html += '<div>';
                        html += '<span class="co" >' + obj.oriuser.name + '</span>';
                        html += '<span class="co">' + obj.time+ '</span>';
                        html += '</div>';
                        html += '<span>' + obj.content + '</span>';
                        html += '</div>';
                        $(".con5-on").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

                    })
                }
            })

        });

        $(document).on("click","#apply",function () {
            $(".con-6").hide()
        })
        $(document).on("click","#apply-in",function () {
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/user/useraction/getLoginUser",
                success:function (data) {

                    $(".name").val(data.name);
                    $(".id").val(data.id);
                }
            });
            $(".con-6").show()
            var cha=[];
            $('input[name="arr"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数
                cha.push($(this).val());//将选中的值添加到数组chk_value中
            });
            $(".ermissions").val(cha);
        })

        $(document).on("click",".con5",function () {
            var content=$(".con-5 .content").val();
            $.ajax({
                type: "post",
                url: "/user/useraction/updateUser",
                dataType: "json",
                data:{"content":content},
                success: function (date) {


                },
                error:function (data) {
                    alert(data);
                }
            })
        });
        $(document).on("click",".con10",function () {
            var id=$(".contentId" ).val();
            var content=$(".con-5 .content").val();
            $.ajax({
                type: "post",
                url: "/Talking/Talking/adminSentTalking",
                dataType: "text",
                data:{"receive":id,"content":content},
                success: function(data) {
                    if(data=="1"){
                        alert("发送成功")

                    }else {
                        alert("发送失败")

                    }

                },
                error:function (data) {
                    alert(data);
                }
            })
        });

        $(document).on("click",".box",function () {
            var box=$(this).is(':checked')
            var box2=$(this).siblings('ul').children('li').children('input').is(':checked');
            var box4=$(this).siblings('ul').children('li').children('input');
            $(this).siblings('ul').children('li').children('input').attr("checked",true);
            // alert($(this).siblings('ul').children('li').children('input').is(':checked'))
            if(box==false){
                $(this).siblings('ul').children('li').children('input').attr("checked",false);
                $(this).attr("name","ar");
            }else if(box==true){
                $(this).attr("name","arr");
            }
            if($(this).siblings('ul').children('li').children('input').is(':checked')==true){
                $(this).siblings('ul').children('li').children('input').attr("name","arr");
            }else {
                $(this).siblings('ul').children('li').children('input').attr("name","ar");
            }
        })
        $(document).on("click",".box2",function () {
            var box=$('.box').is(':checked')
            var box2=$(this).is(':checked')
            var box4=$(this)
            $(this).parent('li').parent('ul').siblings('input').attr("checked",true);
            if(box2==true){
                box4.attr("name","arr");
                $(this).parent('li').parent('ul').siblings('input').attr("name","arr");
            }else if(box2==false){
                $(".box2[type='checkbox']").attr("name","ar");
            }
            if(box2==false&&box4.parent('li').siblings){
                $(this).siblings('input').attr("name","arr");
                $(".box[type='checkbox']").children('li');
                $(".box2:checkbox").attr("name","arr");
            }
            // if(box==false){
            //     $(".box[type='checkbox']").attr("name","arr");
            // }else if(box==true){
            //     $(".box[type='checkbox']").attr("name","ar");
            // }
        })
        $(document).on("click",".con3no-a",function () {
            $(".con3no").show();
        })
        $(document).on("click",".con3no-b",function () {
            $(".con3no").hide();
        })



        //验证初始密码
        $("#initial-password").mouseleave(function () {
            var password=$("#initial-password").val();

            $.ajax({
                type: "post",
                url: "/user/useraction/checkpassword",
                data: {"password":password},
                dataType: "json",
                success: function (data){

                    if(data=="no"){
                        $("#password").css("display","block");
                        $(".ok").attr("disabled", "disabled");
                        $(".con-4 .ok").css("display","none")
                    }else if(data=="yes"){
                        $("#password").css("display","none");
                        $(".ok").removeAttr("disabled");
                        $(".con-4 .ok").css("display","block")
                    }
                }
            })
        })
        $("#password2").mouseleave(function () {
            var password1=$("#password1").val();
            var password2=$("#password2").val();
            if(password1==password2){
                $(".ok").removeAttr("disabled");
                $("#password4").css("display","none");
                $(".con-4 .ok").css("display","block")
            }else {
                $(".ok").attr("disabled", "disabled");
                $("#password4").css("display","block");
                $(".con-4 .ok").css("display","none")
            }
        })
        // $(document).on("click","#con6",function () {
        //     $.ajax({
        //         type: "post",
        //         url: "/user/useraction/queryRequestspbymyselef",
        //         dataType: "text",
        //         success:function (data) {
        //             if(data=="已有"){
        //                 alert("已申请记录");
        //             }else if(data=="成功"){
        //                 alert("申请成功");
        //             }else if(data=="失败"){
        //                 alert("申请失败");
        //             }
        //         }
        //     })
        // })
    })
})()
function con4() {
    var password=$(".con-4 #password2").val();

    $.ajax({
        type: "post",
        url: "/user/useraction/updatepassword",
        dataType: "text",
        data:{"password":password},
        success: function (data) {
            console.log(data)
            if(data=="yes"){
                alert("修改成功！")
                window.location.reload()
            } else if(data=="uncheck"){
                alert("初始密码不匹配！")
                window.location.reload()
            }else {
                alert("修改失败！")
            }

        },
        error:function (data) {

        }
    })
}