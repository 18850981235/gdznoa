/**
 * Created by Administrator on 2019/5/5.
 */

    $(document).ready(function () {
        console.log(1)
        var myDate = new Date();
        //获取当前年
        var year=myDate.getFullYear();
        //获取当前月
        var month=myDate.getMonth()+1;
        //获取当前日
        var date=myDate.getDate();
        var riqi=year+"-"+month+"-"+date
        $("#test1").val(riqi)
    });
