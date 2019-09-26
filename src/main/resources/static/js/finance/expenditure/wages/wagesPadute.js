/**
 * Created by Administrator on 2019/8/15.
 */
function w() {
    var  id=q("id");
    var url="/ga/paymentSalaryUpdate/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        success:function (date) {
            var html="";
            var data=date.payment

            $("#center input").eq(0).val(data.project.abbreviation);
            $("#center input").eq(1).val(data.project.id)
            $("#center input").eq(2).val(data.name)
            $("#center input").eq(3).val(data.unit)
            $("#center input").eq(4).val(data.user.name)
            $("#center input").eq(5).val(data.user.id)

            $(".type option").eq(0).val(data.type)
            $(".type option").eq(0).text(data.type)

            $("#center input").eq(6).val(data.bankname)
            $("#center input").eq(7).val(data.bankaccount)
            $("#center input").eq(8).val(data.digest)
            $("#center input").eq(9).val(data.id)

            $(".he input").eq(0).val(data.paymentMoney)

            $.each(date.list,function (index,obj) {
                var html="";
                console.log(1)
                html+='<tr style="height: 35px ;">';
                html+='<td style="width:100px;display: none"><input style="width: 94px;text-align: center" value='+obj.id+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.name+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.post+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.clockinIn+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.salary+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.time+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.socialSecurity+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.leave+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.insurance+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.rests+'></td>';
                html+='<td style="width:100px;"><input style="width: 94px;text-align: center" value='+obj.netPay+'></td> ';
                html+='</tr>';
                $("#con tbody").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内
            })
        }
    });
}

$(document).ready(function () {
    w();

    $("body").on("click","#add",function () {
        var text='<tr style="height: 35px "><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td><td style="width:100px;"><input style="width: 94px;text-align: center "></td></tr>'

        $("#con tbody").append(text);
    });


    $("body").on("click","#remove",function () {
        var c=$("#con tr").length

        if(c==1){
            alert("不可删除")
        }else {
            $("#con tr:last").remove();
        }

    })

    $(document).on("click","#ok",function () {
        var projectid=$("#center input").eq(1).val()
        var name=$("#center input").eq(2).val()
        var unit=$("#center input").eq(3).val()
        // var type=$("#center input").eq(2).val()
        var userid=$("#center input").eq(5).val()
        var type=$(".type").val();

        var bankname=$("#center input").eq(6).val()
        var bankaccount=$("#center input").eq(7).val()
        var digest=$("#center input").eq(8).val()
        var id=$("#center input").eq(9).val()
        var paymentMoney=$(".he input").eq(0).val()
        var titles = $("#con").find("tr:first td");  //获得表头td数组
        //遍历非表头的，tr、td...拼装json
        var json = "{" + "\"" + "list" + "\"" + ":" + "[" + $("#con").find("tr:not(:first)").map(function(i, e) {
                return "{" + $(e).children("td").children("input").map(function(j, el) {
                        return "\""+$(titles[j]).html()+"\"" + ":" + "\"" + $(el).val() + "\"";
                    }).get().join(",") + "}";
            }).get().join(",")+ "]" +","+ "\""+"payment"+"\"" + ":" + "{"+
            "\""+"name"+"\"" +":"+ "\""+name+"\""+","+
            "\""+"unit"+"\"" +":"+ "\""+unit+"\""+","+
            "\""+"userid"+"\"" +":"+ "\""+userid+"\""+","+
            "\""+"digest"+"\"" +":"+ "\""+digest+"\""+","+
            "\""+"type"+"\"" +":"+ "\""+type+"\""+","+
            "\""+"bankname"+"\"" +":"+ "\""+bankname+"\""+","+
            "\""+"bankaccount"+"\"" +":"+ "\""+bankaccount+"\""+","+
            "\""+"paymentMoney"+"\"" +":"+ "\""+paymentMoney+"\""+","+
            "\""+"projectid"+"\"" +":"+ "\""+projectid+"\""+","+
            "\""+"id"+"\"" +":"+ "\""+id+"\""+","+
            "\""+"matter"+"\"" +":"+ "\""+"项目部工资"+"\""+"}"  +"}";
        // }).get().join(",")+ "]" +"}";
        console.log(json)
        $.ajax({
            type:"post",
            dataType:"json",
            contentType:"application/json;charset=UTF-8",
            url:"/ga/paymentSalaryUpdate/update",
            data:json,
            // "contractid":id,
            success:function(data1){
            }
        });
    })

});
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