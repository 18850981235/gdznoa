/**
 * Created by Administrator on 2019/7/19.
 */
$.ajax({
    type: "get",
    dataType: "json",
    url: "/sys/Process/getAllProcePage",
    success: function (data) {

        $.each(data,function (index,obj){
            var html="";
                html+='<li style="margin-left: 160px;margin-bottom: 5px  ">';
                html+='<a class="ouf">'+obj.name+'</a>';
                html+='<input style="display: none" value='+obj.id+'>';
                html+='</li>';

            $("#second").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });

    }

})
$(document).ready(function () {
    $("#second").on("click",".ouf",function () {
       var  no=$(this).siblings("input").val();
       var  ok=$(".second").children("span").text();

        $("#f").html(value="");
        $.ajax({
            type: "get",
            dataType: "json",
            url: "/sys/Process/getProcessByID",
            data:{"id":no},
            success: function (data) {
                var nameList=data.NameList;
                var userList=data.UserList;

                if(userList.name==null||userList.name==""){

                }

                var html="";
                html+='<input id="userid" style="display: none" value='+no+'>';
                $.each(nameList,function (index,obj){

                    html+='<li style="width: 300px ">';
                    html+='<span >'+obj.name+'</span>';

                    // $.each(userList,function (index1,obj1){
                        // value='+obj1.name+'  Eliminate+

                    // console.log(userList[index].name);
                    if(userList[index]==null){
                        html += '<input style="text-align: center" value="自动"/>';
                        html += '<input class="whole" style="text-align: center;display: none" value="0" >';
                    }else {
                        html += '<input class=' + "Eliminat" + (index + 1) + ' style="text-align: center" required readonly value=' + userList[index].name + ' >';
                        html += '<input id='+"Eliminate-no"+(index + 1)+' class="whole" style="display: none" value=' + userList[index].id + ' >';
                        html += '<a  class=' + "add-to" + (index + 1) + '>修改</a>';
                    }
                    html+='</li>';
                })
                $("#f").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            }
        })

    })

    //负责人
    //1
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            // var users=data.names.users;
            $.each(data,function (index,obj) {
                var html="";
                // html+='<ul class="yiji-no">';
                // 一级
                for(i=1;i<data.length+1;i++){
                    if(i==obj.id){

                        html+='<li class="co1">';
                        html+='<a class="click" >'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj2) {
                            html+='<ul class="name1" style="display: none" >';
                            html += '<li class="co1">';
                            html += '<a class="upload1"  >';
                            html += '<span class="name-block1" >'+obj2.name+'</span>';
                            html += '<span class="name-none1" style="display: none">'+obj2.id+'</span>';
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';
                    }
                }
                // html+='</ul>';
                $(".yiji-no1").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
    //2
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            // var users=data.names.users;
            $.each(data,function (index,obj) {
                var html="";
                // html+='<ul class="yiji-no">';
                // 一级
                for(i=1;i<data.length+1;i++){
                    if(i==obj.id){

                        html+='<li class="co1">';
                        html+='<a class="click" >'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj2) {
                            html+='<ul class="name2" style="display: none" >';
                            html += '<li class="co1">';
                            html += '<a class="upload2"  >';
                            html += '<span class="name-block2" >'+obj2.name+'</span>';
                            html += '<span class="name-none2" style="display: none">'+obj2.id+'</span>';
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';
                    }
                }
                // html+='</ul>';
                $(".yiji-no2").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
    //3
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            // var users=data.names.users;
            $.each(data,function (index,obj) {
                var html="";
                // html+='<ul class="yiji-no">';
                // 一级
                for(i=1;i<data.length+1;i++){
                    if(i==obj.id){

                        html+='<li class="co3">';
                        html+='<a class="click" >'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj2) {
                            html+='<ul class="name3" style="display: none" >';
                            html += '<li class="co3">';
                            html += '<a class="upload3"  >';
                            html += '<span class="name-block3" >'+obj2.name+'</span>';
                            html += '<span class="name-none3" style="display: none">'+obj2.id+'</span>';
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';
                    }
                }
                // html+='</ul>';
                $(".yiji-no3").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
    //4
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            // var users=data.names.users;
            $.each(data,function (index,obj) {
                var html="";
                // html+='<ul class="yiji-no">';
                // 一级
                for(i=1;i<data.length+1;i++){
                    if(i==obj.id){

                        html+='<li class="co4">';
                        html+='<a class="click" >'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj2) {
                            html+='<ul class="name4" style="display: none" >';
                            html += '<li class="co4">';
                            html += '<a class="upload4"  >';
                            html += '<span class="name-block4" >'+obj2.name+'</span>';
                            html += '<span class="name-none4" style="display: none">'+obj2.id+'</span>';
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';
                    }
                }
                // html+='</ul>';
                $(".yiji-no4").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
    //5
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            // var users=data.names.users;
            $.each(data,function (index,obj) {
                var html="";
                // html+='<ul class="yiji-no">';
                // 一级
                for(i=1;i<data.length+1;i++){
                    if(i==obj.id){
                    console.log(1)
                        html+='<li class="co5">';
                        html+='<a class="click" >'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj2) {
                            html+='<ul class="name5" style="display: none" >';
                            html += '<li class="co5">';
                            html += '<a class="upload5"  >';
                            html += '<span class="name-block5" >'+obj2.name+'</span>';
                            html += '<span class="name-none5" style="display: none">'+obj2.id+'</span>';
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';
                    }
                }
                // html+='</ul>';
                $(".yiji-no5").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
    //6
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            // var users=data.names.users;
            $.each(data,function (index,obj) {
                var html="";
                // html+='<ul class="yiji-no">';
                // 一级
                for(i=1;i<data.length+1;i++){
                    if(i==obj.id){

                        html+='<li class="co6">';
                        html+='<a class="click" >'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj2) {
                            html+='<ul class="name6" style="display: none" >';
                            html += '<li class="co6">';
                            html += '<a class="upload6"  >';
                            html += '<span class="name-block6" >'+obj2.name+'</span>';
                            html += '<span class="name-none6" style="display: none">'+obj2.id+'</span>';
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';
                    }
                }
                // html+='</ul>';
                $(".yiji-no6").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
    //点击显示隐藏  --选择负责人
    $(document).on('click','.click',function(){
        if($(this).siblings('ul').css('display')=='none'){
            $(this).siblings('ul').slideDown(10).children('li');
            //判断成功后隐藏
            if($(this).parents('li').children('ul').css('display')=='block'){
                $(this).parents('li').siblings('li').children('ul').slideUp(100);
            }
        }
    });
    //点击选人
    $(document).on("click",".close-in",function () {
        $("#choice").hide();
        $("#choice1").hide();
        $("#choice2").hide();
        $("#choice3").hide();
        $("#choice4").hide();
        $("#choice5").hide();
        $("#choice6").hide();
    });
    //1
    $(document).on("click",".add-to1",function () {
        $("#choice1").show();
    })
    $("#choice1").on("click",".upload1",function () {

        var name=$(this).find(".name-block1").text();
        var id=$(this).find(".name-none1").text();
        $("#choice1").hide();
        $(".Eliminat1").val(name);
        $("#Eliminate-no1").val(id);
    });
    $(document).on("click",".input1",function() {
        $('.Eliminat1').val("");
        $('#Eliminate-no1').val("");
    });
   //2
    $(document).on("click",".add-to2",function () {
        $("#choice2").show();
    })
    $(document).on("click",".upload2",function () {

        var name=$(this).find(".name-block2").text();
        var id=$(this).find(".name-none2").text();
        $("#choice2").hide();
        $(".Eliminat2").val(name);
        $("#Eliminate-no2").val(id);
    });
    $(document).on("click",".input2",function() {
        $('.Eliminat2').val("");
        $('#Eliminate-no2').val("");
    });
    //3
    $(document).on("click",".add-to3",function () {
        $("#choice3").show();
    })
    $(document).on("click",".upload3",function () {

        var name=$(this).find(".name-block3").text();
        var id=$(this).find(".name-none3").text();
        $("#choice3").hide();
        $(".Eliminat3").val(name);
        $("#Eliminate-no3").val(id);
    });
    $(document).on("click",".input3",function() {
        $('.Eliminat3').val("");
        $('#Eliminate-no3').val("");
    });
    //4
    $(document).on("click",".add-to4",function () {
        $("#choice4").show();
    })
    $(document).on("click",".upload4",function () {

        var name=$(this).find(".name-block4").text();
        var id=$(this).find(".name-none4").text();
        $("#choice4").hide();
        $(".Eliminat4").val(name);
        $("#Eliminate-no4").val(id);
    });
    $(document).on("click",".input4",function() {
        $('.Eliminat4').val("");
        $('#Eliminate-no4').val("");
    });
    //5
    $(document).on("click",".add-to5",function () {
        $("#choice5").show();
    })
    $(document).on("click",".upload5",function () {

        var name=$(this).find(".name-block5").text();
        var id=$(this).find(".name-none5").text();
        $("#choice5").hide();
        $(".Eliminat5").val(name);
        $("#Eliminate-no5").val(id);
    });
    $(document).on("click",".input5",function() {
        $('.Eliminat5').val("");
        $('#Eliminate-no5').val("");
    });
    //6
    $(document).on("click",".add-to6",function () {
        $("#choice6").show();
    })
    $(document).on("click",".upload6",function () {

        var name=$(this).find(".name-block6").text();
        var id=$(this).find(".name-none6").text();
        $("#choice6").hide();
        $(".Eliminat6").val(name);
        $("#Eliminate-no6").val(id);
    });
    $(document).on("click",".input6",function() {
        $('.Eliminat6').val("");
        $('#Eliminate-no6').val("");
    });

    //提交
    $(document).on("click","#submitted",function () {
        var usid=$("#userid").val()

        var wh=[];
        $(".whole").each(function () {
            // wh.push($(this).val());
            wh=wh+$(this).val()+","
        })
        console.log(wh)
        $.ajax({
            type: "post",
            dataType: "text",
            url: "/sys/Process/updateProcessByID",
            data:{"userid":wh,"id":usid},
            success: function (data) {
                console.log(data)
                if(data=="yes"){
                    alert("修改成功");
                }else {
                    alert("修改失败");
                }
            }
        })

    })
})