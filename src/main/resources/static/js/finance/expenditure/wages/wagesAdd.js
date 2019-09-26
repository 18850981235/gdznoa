/**
 * Created by Administrator on 2019/8/15.
 */
$(document).ready(function () {
    // var projectName=$(".projectName").val();
    var  project= $.cookie("name");
    var  projectid= $.cookie("id");
    var  ferf= $.cookie("herf");
    $("#center input").eq(0).val(project)
    $("#center input").eq(1).val(projectid)
    //申请人
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/user/useraction/getLoginUser",
        success:function (data) {
            console.log(data.name)
            $("#center input").eq(4).val(data.name)
            $("#center input").eq(5).val(data.id)
            // $(".department option").eq(0).val(data.dept.id)
            // $(".department option").eq(0).text(data.dept.name)

        }
    });
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
    $(document).on("click","#no",function () {
        var name=$("#center input").eq(2).val()
        var unit=$("#center input").eq(3).val()
        // var type=$("#center input").eq(2).val()
        var userid=$("#center input").eq(5).val()
        var type=$(".type").val();

        var bankname=$("#center input").eq(6).val()
        var bankaccount=$("#center input").eq(7).val()
        var digest=$("#center input").eq(8).val()
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

            "\""+"matter"+"\"" +":"+ "\""+"项目部工资"+"\""+"}"  +"}";
        // }).get().join(",")+ "]" +"}";
        console.log(json)
        $.ajax({
            type:"post",
            dataType:"json",
            contentType:"application/json;charset=UTF-8",
            url:"/ga/payment/addPaymentSalary",
            data:json,
            // "contractid":id,
            success:function(data1){



            }
        });
    })

});