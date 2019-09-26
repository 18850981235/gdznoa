/**
 * Created by Administrator on 2019/7/19.
 */
//流水号  日期加随机数
    $(document).ready(function () {
        var myDate = new Date();
//获取当前年
        var year=myDate.getFullYear();
//获取当前月
        if(myDate.getMonth()+1<10){
            var month1=myDate.getMonth()+1;
            var month="0"+month1
        }else {
            var month=myDate.getMonth()+1;
        }
//获取当前日
        if(date1=myDate.getDate()<10){
            var date1=myDate.getDate();
            var date="0"+date1;
        }else {
            var date=myDate.getDate();
        }
//获取当小时
        var hours=myDate.getHours()

        var arr = [];//容器
        for(var i =0;i<3;i++){//循环3次
            var num = Math.random()*9;//Math.random();每次生成(0-1)之间的数;
            num = parseInt(num,10);
            arr.push(num);
        }
        var ar=arr.join("");
0
        var number=  year +""+ month+""+date+""+hours+""+ar;
        $("#number").val(number);

        var xdata= year +""+ month+""+date
        var xdataLX="LX"+ year +""+ month+""+date
        var contract="LW"+ year +""+ month+""+date
        var affair="CG"+ year +""+ month+""+date
        $("#xdataLX").val(number);
        $("#xdata").val(xdata);
        $("#contract").val(contract);
        $("#affair").val(affair);
    })
