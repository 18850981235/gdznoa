/**
 * Created by Administrator on 2019/9/2.
 */
/**
 * Created by Administrator on 2019/9/2.
 */
var  projectid= $.cookie("id");
var  ferf= $.cookie("herf");
$.ajax({
    type: "get",
    url: "/ga/payment/bankFlow.json?projectid="+projectid+"&type="+ferf,
    // data: {"projectName":projectName,"deptid":deptid,"start":start,"end":end},
    dataType: "json",
    success: function (data) {
        // var list = data.list;
        // var page = data.page;
        var html = "";

        $.each(data, function (index1, obj1) {

            if(obj1.out=="收入"){

                html+='<tr class="seal" style="height: 40px " >';
                html+='<td style="width: 100px ">'+obj1.createtime+'</td>';
                html+='<td style="width: 100px ">'+obj1.id+'</td>';
                html+='<td style="width: 150px ">'+obj1.matter+'</td>';
                if(obj1.user==0){
                    html+='<td style="width: 100px "></td>';

                }else {
                    html+='<td style="width: 100px ">'+obj1.user.company+'</td>';

                }

                html+='<td style="width: 250px ">'+obj1.unit+'</td>';
                html+='<td style="width: 250px ">'+obj1.digest+'</td>';
                html+='<td style="width: 150px ">'+obj1.payment_money+'</td>';
                html+='<td style="width: 150px "></td>';
                html+='<td style="width: 150px "></td>';
                html+='</tr>';
            }else if(obj1.out=="支出"){

                html+='<tr class="seal" style="height: 40px" >';
                html+='<td style="width: 100px ">'+obj1.createtime+'</td>';
                html+='<td style="width: 100px ">'+obj1.id+'</td>';
                html+='<td style="width: 150px ">'+obj1.matter+'</td>';
                console.log(obj1.user)
                if(obj1.userid==0){
                    html+='<td style="width: 100px "></td>';

                }else if(obj1.userid!=0) {
                    html+='<td style="width: 100px ">'+obj1.user.company+'</td>';

                }
                html+='<td style="width: 250px ">'+obj1.unit+'</td>';
                html+='<td style="width: 250px ">'+obj1.digest+'</td>';
                html+='<td style="width: 150px "></td>';
                html+='<td style="width: 150px ">'+obj1.payment_money+'</td>';
                html+='<td style="width: 150px "></td>';
                html+='</tr>';
            }

        });
        $(".sea2").append(html);

    }

})
$(document).ready(function () {

    $(".AD").click(function () {
        var vues =0;
        var len=$('.sea2 tr').length;
        for(var i=len-1;i>-1;i--){
            var r=$(".sea2 tr").eq(i).find("td").eq(8).text()
            var q = $(".sea2 tr").eq(i).find("td").eq(6).text()
            var w = $(".sea2 tr").eq(i).find("td").eq(7).text()
            var e = $(".sea2 tr").eq(i+1).find("td").eq(8).text()
            // var vue=$('#con tr').eq(i).find("td").eq(9).text();

            vues =e+q-w;
            $(".sea2 tr").eq(i).find("td").eq(8).text(vues)
        }
    })
    // $("#dian").click(function () {
    //     //计算总和
    //     var vues =0;
    //     var len=$('#con tr:not(:first)').length;
    //     for(var i=1;i<len+1;i++){
    //
    //         var vue=$('#con tr').eq(i).find("td").eq(9).text();
    //
    //         vues += Number(vue);
    //
    //     }
    //     $("#heji").val(vues)
    // })
})