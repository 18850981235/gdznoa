/**
 * Created by Administrator on 2019/3/25.
 */
(function () {
    //ajax  --选择负责人
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            // var users=data.names.users;
            $.each(data,function (index,obj) {
                var html="";
                // 一级
                for(i=1;i<data.length+1;i++){
                    if(i==obj.id){

                        html+='<li>';
                        html+='<a class="click">'+obj.name+'</a>';

                        // 二级
                        $.each(obj.users,function (index1,obj1) {
                            html+='<ul class="name" style="display: none" >';
                            html += '<li>';
                            html += '<a class="upload" >';
                            html += '<span class="name-block" >'+obj1.name+'</span>';
                            html += '<span class="name-none" style="display: none">'+obj1.id+'</span>';
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';

                    }

                }
                $(".yiji-no").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容


            });
            $.each(data,function (index,obj) {
                var html1="";
                // 一级
                for(i=1;i<data.length+1;i++){

                    if(i==obj.id){

                        html1+='<li>';
                        html1+='<a class="click">'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj1) {
                            html1+='<ul class="name" style="display: none" >';
                            html1 += '<li>';
                            html1 += '<a class="upload-noe" >';
                            html1 += '<span class="name-block" >'+obj1.name+'</span>';
                            html1 += '<span class="name-none" style="display: none">'+obj1.id+'</span>';
                            // console.log(obj1.id);
                            html1 += '</a>';
                            html1 += '</li>';
                            html1+='</ul>';
                        });
                        html1+='<li>';
                    }
                }
                $(".yiji-no2").prepend(html1);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    })



    $.ajax({
        type:"post",
        dataType:"json",
        url:"/bd/client/query.html",
        success:function (data) {
            var names=data.list;
            $.each(names,function (index,obj) {
                var html="";
                // html+='<ul class="name" >';
                html += '<li>';
                html += '<a class="upload1" >';
                html += '<span class="name-block" >'+obj.name+'</span>';
                html += '<span class="name-none" style="display: none">'+obj.id+'</span>';
                console.log(obj.name);
                html += '</a>';
                html += '</li>';
                // html+='</ul>';
                $(".name1").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    })
   /* $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getDeptUsers",
        success:function (data) {
            var names=data.names;
            // var users=data.names.users;
            $.each(names,function (index,obj) {
                var html="";
                // 一级
                for(i=1;i<names.length+1;i++){

                    if(i==obj.id){

                        html+='<li>';
                        html+='<a class="click">'+obj.name+'</a>';
                        // 二级
                        $.each(obj.users,function (index1,obj1) {
                            html+='<ul class="name" style="display: none" >';
                            html += '<li>';
                            html += '<a class="upload-noe" >';
                            html += '<span class="name-block" >'+obj1.name+'</span>';
                            html += '<span class="name-none" style="display: none">'+obj1.id+'</span>';
                            // console.log(obj1.id);
                            html += '</a>';
                            html += '</li>';
                            html+='</ul>';
                        });
                        html+='<li>';
                    }
                }
                $(".yiji-no2").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    })*/
    //
    $(document).ready(function () {
        $("#content-in .add-to").click(function () {
            $(this).children('a').attr("href","javascript");
        })
    })
    // 清空点击效果
    $(document).ready(function(){
        $(function(){
            $('#new .clear-to input').click(function(){
                $('.Eliminate').val("");
            });
        });
    });
    $(document).ready(function(){

        $('.clear-to .input').click(function(){
            console.log(1);
            $('.Eliminate').val("");
            $('.Eliminate-no').val("");
        });
        $('.clear-to1 .input1').click(function(){
            console.log(2);
            $('.Eliminate-1').val("");
            $('.Eliminate-no-1').val("");
        });
        $('.clear-to2 .input2').click(function(){
            console.log(3);
            $('.eliminate-2').val("");
            $('.eliminate-no-2').val("");
        });

    });
    //点击显示隐藏  --选择负责人
    $(document).ready(function() {
        $('body').on('click','.click',function(){
            if($(this).siblings('ul').css('display')=='none'){
                $(this).siblings('ul').slideDown(100).children('li');
                //判断成功后隐藏
                if($(this).parents('li').children('ul').css('display')=='block'){
                    $(this).parents('li').siblings('li').children('ul').slideUp(100);
                }
            }
        })
    });

    //负责人点击事件
    // $(document).ready(function () {
    //
    // })
    $(document).ready(function () {

        $(".close-in").click(function () {
            $("#choice").hide();
            $("#choice1").hide();
            $("#choice2").hide();
        });
        $(".add-to").click(function () {
            $("#choice").show();
        });
        $(".add-to1").click(function () {
            $("#choice1").show();
        });
        $(".add-to2").click(function () {

            $("#choice2").show();
        });

        $(".upload").click(function () {
            console.log(8);
            var name=$(this).find(".name-block").text();
            var id=$(this).find(".name-none").text();
            $("#choice").hide();
            $(".Eliminate").val(name);
            $(".Eliminate-no").val(id);
        });
        $("body").on("click"," .upload1",function () {
            console.log(9);
            var name1=$(this).find(".name-block").text();
            var id1=$(this).find(".name-none").text();
            $("#choice1").hide();
            $(".Eliminate-1").val(name1);
            $(".Eliminate-no-1").val(id1);
        });

        $("body").on("click"," .upload-noe",function () {
            var c2,f2,d2,d1;
            var name2=$(this).find(".name-block").text();
            var id2=$(this).find(".name-none").text();
            d2=$(".eliminate-2").val();
            d1=$(".eliminate-no-2").val();

            if(d2==""){
                $(".eliminate-2").val(name2);
                $(".eliminate-no-2").val(id2);
                console.log(1);
                console.log(name2);
                console.log(id2);
            }else {
                c2= d2+","+name2;
                f2= d1+","+id2;
                $(".eliminate-2").val(c2);
                $(".eliminate-no-2").val(f2);
                console.log(2);
                // console.log(c2);
                console.log(c2);
                console.log(name2);
                // console.log(id2);
                // console.log(f2);
            }

        })
    })

})()