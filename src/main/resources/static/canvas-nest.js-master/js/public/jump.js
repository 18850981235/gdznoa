
/**
 * Created by Administrator on 2019/3/11.
 */
(function () {
    $(function(){
//定时器每秒调用一次
        setInterval(function(){
            var date=new Date();
            var year=date.getFullYear(); //年
            var mon=date.getMonth()+1;	//月
            var day=date.getDate();		//日
            var hh=date.getHours();		//时
            var mm=date.getMinutes();	//分
            var ss=date.getSeconds();	//秒
            var today=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
            var xq=today[date.getDay()];
            var daytime;
            var day;
            daytime=year +"/"+mon+"/"+day;
            day=xq;
            var time;
            if(mm<10 ){
                mm="0"+mm;
            }
            if(ss<10){
                ss="0"+ss;
            }
            time= hh+":"+ mm ;
            $("#daytime").val(daytime);
            $("#day").val(day);
            $("#time").val(time);//$("span").text(time)这是span标签写的方式
        });
    },1000);
//三级点击菜单

        $(document).ready(function() {
            $('body').on('click','.inactive',function(){
                if($(this).siblings('ul').css('display')=='none'){
                    $(this).parent('li').siblings('li').removeClass('inactives');
                     $(this).addClass('inactives');
                    $(this).siblings('ul').slideDown(100).children('li');
                    //判断成功后隐藏
                    if($(this).parents('li').children('ul').css('display')=='block'){
                        $(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
                        $(this).parents('li').siblings('li').children('ul').slideUp(100);
                    }
                }
                else{
                    //控制自身变成+号
                    $(this).removeClass('inactives');
                    //控制自身菜单下子菜单隐藏
                    $(this).siblings('ul').slideUp(100);
                    //控制自身子菜单变成+号
                    $(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
                    //控制自身菜单下子菜单隐藏
                    $(this).siblings('ul').children('li').children('ul').slideUp(100);
                    //控制同级菜单只保持一个是展开的（-号显示）
                    $(this).siblings('ul').children('li').children('a').removeClass('inactives');
                }
            })
        });
    //  三级
    $(document).ready(function () {
        var html = "";

        $.ajaxSettings.async = false;
        $.getJSON("../../../json/menu.json",
            function (date) {
                $.each(date.menuList, function (i, menu) {
                        if (menu.levels == 1) {
                            html+='<ul class="yiji">';
                            html += "<li><a href='#' class='inactive'>" + menu.name + "</a>";

                            $.each(date.menuList, function (i, menu2) {
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
                                        html += "<ul style=\"display: none\">";
                                        html +=   " <li>";
                                        html +=  "<a href='" + url2 + "' class='inactive'>" + menu2.name + "</a>";
                                        html +=   "<ul>";
                                        $.each(date.menuList, function (i, menu3) {
                                            if (menu3.levels == 3 && menu3.pcode == menu2.code) {
                                                var url3 = "";
                                                var flge2 = true;
                                                $.each(date.authority, function (i, auth) {
                                                    if (menu3.id == auth.menu) {

                                                        url3 = menu3.url;
                                                        flge2 = false;
                                                        return false;
                                                    }
                                                })
                                                if (flge2) {
                                                    url3 = "javascript:void(0);";
                                                }
                                                html += "<li><a href='" + url3 + "'>" + menu3.name + "</a></li>";
                                            }
                                        })
                                        html += "</ul>" +
                                            "</li>" +
                                            "  </ul>";
                                    }
                                }
                            )
                            html += "</li>";
                        }
                    html+='</ul>';
                    }
                )
                $(".yiji").append(html);
            }
        )
    })
//天气
    $.ajax({
        type:"get",  //请求方式
        dataType:"json",  //json格式
        url:"http://t.weather.sojson.com/api/weather/city/101230201",  //路径
        success:function (data) {  ////success指的是请求并成功返回信息  data是返回的内容
            var day = new Date().getDate();
            var Datea = data.data.forecast;

            $.each(Datea, function (index, obj) {
                var hight = obj.high.substring(3);//substring截选
                var low = obj.low.substring(3);
                if (obj.date == day) {
                    $("#weather p").text(obj.type);
                    $("#weather span").text(hight + " ~ " + low);
                    $("#weather .comment").text(obj.notice);

                }
            });
        }
        });



//分页
    $(document).ready(function () {
        // $("#paging-selection .dian").click(function () {
            $(document).on('click','#paging-selection .dian',function(){
            $(".dian").hide();
            $(".dian-in").show();
            $(".dian-in").css("display"," inline-block");
            // $(".page-selection").css("margin-left","200px ");
        })
    })


    //点击
    // $(document).ready(function () {
        // $("#content-in .add-to").click(function () {
            $(document).on('click','#content-in .add-to',function(){
                console.log(1);
            $(this).children('a').attr("href","javascript");
        })
    // });
    // 清空点击效果
    $(document).ready(function(){
        $(function(){
            // $('#new .clear-to input').click(function(){
                $(document).on('click','#new .clear-to input',function(){
                $('.Eliminate').val("");
            });
            // $('#new .clear-to1 input').click(function(){
                $(document).on('click','#new .clear-to1 input',function(){
                $('.Eliminate1').val("");
            });
        });
    });
    $(document).ready(function(){
        // $('.clear-to .input').click(function(){
            $(document).on('click','.input',function(){
                console.log(1)
            $('.Eliminate').val("");
            $('.Eliminate-no').val("");
        });
        // $('.clear-to1 .input1').click(function(){
            $(document).on('click','.input1',function(){
            $('.Eliminate-1').val("");
            $('.Eliminate-no-1').val("");
        });
        // $('.clear-to2 .input2').click(function(){
            $(document).on('click','.input2',function(){
            $('.eliminate-2').val("");
            $('.eliminate-no-2').val("");
        });
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
    //负责人点击事件
    $(document).ready(function () {
        // $(".close-in").click(function () {
            $(document).on("click",".close-in",function () {
            $("#choice").hide();
            $("#choice1").hide();
            $("#choice2").hide();
        });
        // $(".add-to").click(function () {
            $(document).on("click",".add-to",function () {
            $("#choice").show();
        });
        // $(".add-to1").click(function () {
            $(document).on("click",".add-to1",function () {
            $("#choice1").show();
        });
        // $(".add-to2").click(function () {
            $(document).on("click",".add-to2",function () {
            $("#choice2").show();
        });

        // $(".upload").click(function () {
                $(document).on("click",".upload",function () {
            var name=$(this).find(".name-block").text();
            var id=$(this).find(".name-none").text();
            $("#choice").hide();
            $(".Eliminate").val(name);
            $(".Eliminate-no").val(id);
        });
        $(" .upload1").click(function () {
            //     $(document).on("click",".upload1",function () {
            var name1=$(this).find(".name-block1").text();
            var id1=$(this).find(".name-none1").text();
            $("#choice1").hide();
            $(".Eliminate-1").val(name1);
            $(".Eliminate-no-1").val(id1);
        });
        $(" .upload-noe").click(function () {
            //     $(document).on("click",".upload-noe",function () {
            var c2,f2,d2,d1;
            var name2=$(this).find(".name-block2").text();
            var id2=$(this).find(".name-none2").text();
            d2=$(".eliminate-2").val();
            d1=$(".eliminate-no-2").val();
            if(d2==""){
                $(".eliminate-2").val(name2);
                $(".eliminate-no-2").val(id2);
            }else {
                c2= d2+","+name2;
                f2= d1+","+id2;
                $(".eliminate-2").val(c2);
                $(".eliminate-no-2").val(f2);
            }
        })
    })

})();