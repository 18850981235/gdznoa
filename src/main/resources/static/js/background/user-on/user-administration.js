(function () {
    function w() {
        var id = q("id");
        var url = "/user/useraction/queryUserbyId?id=" + id;
        var qId=$("#id").val();
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/user/useraction/getallMenuanduser?userid=" + id,
            success:function (data) {
                if(data.ListRequest==null){

                }else if(data.ListRequest==""){

                }else {
                    $("#Add").text(data.ListRequest.ermissions);
                }

            }
        });
        $.ajax({
            type:"post",
            url: url,
            dataType:"json",
            success:function (data) {
                var html = "";
                html+='<input style="display: none" value='+data.id+'  >';


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
                html +='<input style="width: 250px;border: 1px solid " name="bankaccount1" value='+data.bankaccount1+'>';
                html +='<span style="margin-right: 20px ;margin-left: 30px ">银行</span>';
                html +=' <select name="bank2" style="height:30px;width: 250px  ">';
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
            url: url,
            dataType:"json",
            success:function (data) {
                var di = q("id");
                var html="";
                $("#id").val(data.id);
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

                $("#di").val(data.id);
                console.log("id===>"+ data.id);
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
            url: url,
            dataType:"json",
            success:function (data) {

                var html = "";
                var pubtalking=data.PubTalking;
                html+='<div class="con5-in" >';
                $.each(pubtalking,function (index,obj) {


                    html+='<div>';
                    html+='<span class="co" >'+obj.oriuser.name+'</span>';
                    html+='<span class="co">'+obj.time+'</span>';
                    html+='</div>';
                    html+='<span>'+obj.content+'</span>';


                })
                html+='</div>';
                $(".con5-on").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            }
        })
        $.ajax({
            type:"post",
            url:"/user/useraction/getallMenuanduser?userid=" + id,
            dataType:"json",
            success: function (date) {

                var html = "";
                var sysmenu=date.ListAuthority.sysmenu;
                $.each(date.ListAuthority, function (i, qq) {

                    var  l=date.ListAuthority;
                    // for(we=0;w<l.length;we++){
                    //     $.each(date.ListAuthority.sysmenu, function (o, menu) {
                    html+='<ul class="yiji">';
                    if (qq.sysmenu.levels==1) {

                        html += "<li>   <input class='box' type='checkbox' value="+qq.sysmenu.id+"> "+ qq.sysmenu.name+"";
                        // "<a href='#' class='inactive'>" + menu.name + "</a>";
                        html += "<ul style='margin-left: 20px '>";
                        $.each(date.ListAuthority, function (i, menu2) {
                                if (menu2.sysmenu.levels == 2 && menu2.sysmenu.pcode == qq.sysmenu.code) {
                                    html +=   " <li>";
                                    html +=  "<input class='box2' type='checkbox' value="+menu2.sysmenu.id+"> "+ menu2.sysmenu.name+"";
                                    // html +=  "<a href='" + url2 + "' class='inactive'>" + menu2.name + "</a>";
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

//         $.ajax({
//             type:"post",
//             url: "/user/useraction/getallMenuanduser?userid="+id,
//             dataType:"json",
//             data:{userid:id},
//             success: function (date) {
// console.log(1)
//                 var html = "";
//                 var sysmenu=date.ListAuthority.sysmenu;
//                 $.each(date.ListAuthority, function (i, qq) {
//
//                     console.log(2)
//
//                     var  l=date.ListAuthority;
//                     // for(we=0;w<l.length;we++){
//                     //     $.each(date.ListAuthority.sysmenu, function (o, menu) {
//                     html+='<ul class="yiji">';
//                     if (qq.sysmenu.levels==1) {
//
//                         html += "<li>   <input class='box ob' type='checkbox' value="+qq.sysmenu.id+" > "+ qq.sysmenu.name+"";
//                         // "<a href='#' class='inactive'>" + menu.name + "</a>";
//                         html += "<ul style='margin-left: 20px '>";
//                         $.each(date.ListAuthority, function (i, menu2) {
//                                 if (menu2.sysmenu.levels == 2 && menu2.sysmenu.pcode == qq.sysmenu.code) {
//                                     html +=   " <li>";
//                                     html +=  "<input class='box2 ob' type='checkbox' value="+menu2.sysmenu.id+" > "+ menu2.sysmenu.name+"";
//                                     // html +=  "<a href='" + url2 + "' class='inactive'>" + menu2.name + "</a>";
//                                     html +=  "</li>" ;
//                                 }
//                             }
//                         )
//                         html +=  " </ul>";
//                         html += "</li>";
//                     }
//                     html+='</ul>';
//                     // })
//                     // }
//
//                 })
//                 $("#whole").append(html);
//             }
//         })
        $.ajax({
            type:"post",
            url: "/user/useraction/getallMenuanduser?userid="+id,
            dataType:"json",
            success:function (date) {
                var html = "";
                $.each(date.listMenu, function (i, menu) {

                        if (menu.levels == 1) {
                            html+='<ul class="yiji">';
                            html += "<li>   <input class='box' type='checkbox' value="+menu.id+"> "+ menu.name+"";
                            // "<a href='#' class='inactive'>" + menu.name + "</a>";
                            html += "<ul style='margin-left: 20px '>";
                            $.each(date.listMenu, function (i, menu2) {
                                    if (menu2.levels == 2 && menu2.pcode == menu.code) {
                                        html +=   " <li>";

                                        html +=  "<input class='box2' type='checkbox' value="+menu2.id+"> "+ menu2.name+"";
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
        $(document).on("click","#apply-in",function () {
            $.ajax({
                type:"post",
                dataType:"json",
                url: url,
                success:function (data) {

                    $(".name").val(data.name);
                    $(".id").val(data.id);
                }
            });
            $(".con-6").show()
        })
        //验证初始密码
        $("#initial-password").mouseleave(function () {
            var password=$("#initial-password").val();
            $.ajax({
                type: "post",
                url: url,
                data: {"password":password},
                dataType: "json",
                success: function (data){
                    if(data=="no"){
                        $("#password").css("display","block");
                        $(".ok").attr("disabled", "disabled");
                    }else if(data=="yes"){
                        $("#password").css("display","none");
                        $(".ok").removeAttr("disabled");
                    }
                }
            })
        })
        $("#password2").mouseleave(function () {
            var password1=$("#password1").val();
            var password2=$("#password2").val();
            if(password1==password2){
                $(".ok").removeAttr("disabled");
            }else {
                $(".ok").attr("disabled", "disabled");
                $("#password4").css("display","block");
            }
        })

    }
    function ioq() {
        input=ture;
    }
    $(document).ready(function () {
       w();


$(document).on("click","#con2",function () {
    var array=$("#array").val();
    var arra=$("#array").text();
    var arr=$("#array").html();
    var id=$("#di").val();
    $.ajax({
        type: "post",
        url: "/user/useraction/updateMenu",
        dataType: "text",
        data:{"array":array,"userid":id},
        success: function (data) {
            if(data=="yes"){
                alert("修改成功");
                // window.location.href="/user/user/updateUserPage?id="+di;
            }else{
                alert("修改失败");
                // window.location.href="/user/user/updateUserPage?id="+di;
            }

        },

    })
})

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
           var id2=$("#di").val()
            $("#di2").val(id2);
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
            $(".con-5").show();
            $("#con-5").addClass("dian");
            $(".con-5").siblings().hide();
            $("#con-5").siblings().removeClass("dian");
        })
        $(document).on("click","#apply",function () {
            $(".con-6").hide()
        })



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

$(document).on("click","#cn",function () {
    var chk_value =[];//定义一个数组
    $('input[name="arr"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数
        chk_value.push($(this).val());//将选中的值添加到数组chk_value中
    });
    $("#array").val(chk_value);
    $("#array").text(chk_value);
    var array=$("#array").val();
    var id=$("#di").val();
    $.ajax({
        type: "post",
        url: "/user/useraction/updateMenu",
        dataType: "text",
        data:{"array":array,"userid":id},
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
})


    })
})()
//点击提交获取已经勾选的权限
function getInfo(){
    //jquery获取复选框值
    var chk_value =[];//定义一个数组
    $('input[name="arr"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数
        chk_value.push($(this).val());//将选中的值添加到数组chk_value中
    });
    $("#array").val(chk_value);
    $("#array").text(chk_value);

}
function q(name){
    var search = document.location.search;
    var pattern = new RegExp("[?&]"+name+"\=([^&]+)", "g");
    var matcher = pattern.exec(search);
    var items = null;
    if(null != matcher){
        try{
            items = decodeURIComponent(decodeURIComponent(matcher[1]));
        }catch(e){
            try{
                items = decodeURIComponent(matcher[1]);
            }catch(e){
                items = matcher[1];
            }
        }
    }
    return items;
};
// function con1() {
//     var account=$(".con-1 .account").val();
//     var name=$(".con-1 .name").val();
//     // var sex=$(".sex option").eq(0).val();
//     var sex=$(".sex").val();
//     var workphone=$(".con-1 .workphone").val();
//     var IDnumber=$(".con-1 .IDnumber").val();
//     var QQ=$(".con-1 .QQ").val();
//     var phone=$(".con-1 .phone").val();
//     var weChat=$(".con-1 .weChat").val();
//     var certificate=$(".con-1 .certificate").val();
//     var britherday=$(".con-1 .britherday").val();
//     // var deptid=$(".deptid option").eq(0).val();
//     var deptid=$(".deptid").val();
//     var address=$(".con-1 .address").val();
//     var roleid=$(".con-1 .roleid").val();
//     var ermissions=$(".con-1 .ermissions").val();
//     var id=$("#id").val
//     $.ajax({
//         type: "post",
//         url: "/user/useraction/updateUser",
//         dataType: "json",
//         data:{"account":account,"name":name,"sex":sex,"workphone":workphone,"IDnumber":IDnumber,"QQ":QQ,"phone":phone,"weChat":weChat,"certificate":certificate,"britherday":britherday,"deptid":deptid,"address":address,"roleid":roleid,"ermissions":ermissions,"id":id},
//         success: function (date) {
//
//             console.log(2)
//         },
//         error:function (data) {
//             console.log(2)
//         }
//     })
// }