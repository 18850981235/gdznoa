
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
        $.getJSON("/page/menu",
            function (date) {
                // console.log($(".inactive"))
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
                    // console.log(obj.high.substring(3));
                }
            });
        }
        });



//分页
    $(document).ready(function () {
        $("#paging-selection .dian").click(function () {
            $(".dian").hide();
            $(".dian-in").show();
            $(".dian-in").css("display"," inline-block");
            // $(".page-selection").css("margin-left","200px ");
        })
    })
//
    $(document).ready(function () {
        $("#content-in .add-to").click(function () {
            $(this).children('a').attr("href","javascript");
        })
    })
  // 清空点击效果
    $(document).ready(function(){
        $(function(){
            $('#new .clear-to input:reset').click(function(){
                $('.Eliminate').val("");
            });
        });
    });
    $(document).ready(function(){
        $(function(){
            $('#content-in .clear-to input:reset').click(function(){
                $('.Eliminate').val("");
            });
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
//ajax  --选择负责人

})();