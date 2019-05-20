/**
 * Created by Administrator on 2019/3/6.
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
            time= hh+":"+ mm + ":" +ss;
            $("#daytime").val(daytime);
            $("#day").val(day);
            $("#time").val(time);//$("span").text(time)这是span标签写的方式
        });
    },1000);


})()


