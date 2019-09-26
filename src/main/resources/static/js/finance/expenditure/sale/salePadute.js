/**
 * Created by Administrator on 2019/8/12.
 */
/**
 * Created by Administrator on 2019/8/19.
 */
function w() {

    var  id=q("id");
    var url="/ga/payment/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (date) {
            var data=date.gaPayment;
            var html="";
            $("#center input").eq(0).val(data.id);
            if(data.matter=="采购付款"){
                $("#ap option").eq(0).val(data.pdProcurementContract.project.name)
                $("#ap option").eq(0).text(data.pdProcurementContract.id)
                $("#center input").eq(2).val(data.pdProcurementContract.total);
                $("#center input").eq(8).val(data.pdProcurementContract.total-data.paid);
                $("#center input").eq(10).val(data.pdProcurementContract.total-data.ticket);

            }else if(data.matter=="劳务费付款"){
                $("#ap option").eq(0).val(data.serviceContract.project.name)
                $("#ap option").eq(0).text(data.serviceContract.id)
                $("#center input").eq(2).val(data.serviceContract.total);
                $("#center input").eq(8).val(data.serviceContract.total-data.paid);
                $("#center input").eq(10).val(data.serviceContract.total-data.ticket);

            }else if(data.matter=="中标服务费"){
                $("#ap option").eq(0).val(data.salesContract.project.name)
                $("#ap option").eq(0).text(data.salesContract.id)
                $("#center input").eq(2).val(data.salesContract.total);
                $("#center input").eq(8).val(data.salesContract.total-data.paid);
                $("#center input").eq(10).val(data.salesContract.total-data.ticket);

            }

            $("#center input").eq(1).val(data.matter);

            $(".type option").eq(0).val(data.type)
            $(".type option").eq(0).text(data.type)

            $("#center input").eq(3).val(data.createtime);
            $("#center input").eq(4).val(data.user.name);
            $("#center input").eq(5).val(data.user.id);
            $("#center input").eq(6).val(data.paymentMoney);
            $("#center input").eq(7).val(data.paid);



            $("#center input").eq(9).val(data.ticket);
            $("#center input").eq(11).val(data.unit);
            $("#center input").eq(12).val(data.digest);
            $("#center input").eq(13).val(data.bankname);
            $("#center input").eq(14).val(data.bankaccount);

        }
    });

}
$(document).ready(function () {
    w();
    var  project= $.cookie("id");
    var  ferf= $.cookie("herf");
    $("#projectid").val(project)


    var herfs=$("#ferf").val();

    if(herfs=="采购付款"){

        $.ajax({
            type:"post",
            dataType:"json",
            url:"/pd/Procurement/getProcurementAll?id="+project,
            success:function (data1) {

                $.each(data1,function (index,obj) {
                    var html="";
                    html+='<option class="pop"  value='+obj.id+'>'+obj.project.name+'</option>';
                    $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                })
            }
        });


    }else if(herfs=="劳务费付款"){

        $.ajax({
            type:"post",
            dataType:"json",

            url:"/pd/Service/getserviceAll?id="+project,
            success:function (data) {
                $.each(data,function (index,obj) {
                    var html="";
                    html+='<option class="pop"  value='+obj.id+'>'+obj.project.name+'</option>';
                    $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                })
            }
        });
    }else {
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/sd/SdSalesContract/queryContract",
            success:function (data) {
                $.each(data.list,function (index,obj) {
                    var html="";

                    html+='<option class="pop"  value='+obj.id+'>'+obj.project.name+'</option>';

                    $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                })
            }
        });
    }

    $("#ap").change(function () {
        var herfs=$("#ferf").val();
        var a=$("#ap").val();
        if(herfs=="采购付款"){
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/pd/Procurement/getProcurement?id="+a,
                success:function (data) {

                    $("#center input").eq(1).val(data.pdProcurementContract.total)
                    $("#center input").eq(6).val(data.pdProcurementContract.supplierName)
                    // $("#center input").eq(2).val(data.SdSalesContract.contractAmount)
                    //已开发票金额
                    $.ajax({
                        type:"post",
                        dataType:"text",
                        url:"/ga/harvestTicket/sumCost",
                        data:{"contractid":a,"type":herfs},
                        success:function (data1) {
                            $("#yk").val(data1)

                            // var w=Number(q)-Number(data1);
                            var e=data.pdProcurementContract.total-data1;
                            $("#center input").eq(9).val(e)
                        }
                    });

                    // 已付金额
                    $.ajax({
                        type:"post",
                        dataType:"text",
                        url:"/ga/payment/paymentSumPaid",
                        data:{"projectId":project,"id":a,"matter":herfs},
                        success:function (data2) {
                            $("#yf").val(data2)
                            var e=data.pdProcurementContract.total-data2;
                            $("#center input").eq(7).val(e)
                        }
                    });
                }
            });

        }else if(herfs=="劳务费付款"){
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/pd/service/getServiceProcurement?id="+a,
                success:function (data) {

                    $("#center input").eq(1).val(data.Contract.total)
                    $("#center input").eq(6).val(data.Contract.secondName)

                    // $("#center input").eq(2).val(data.SdSalesContract.contractAmount)
                }
            });
            //已开发票金额

            $.ajax({
                type:"post",
                dataType:"text",
                url:"/ga/harvestTicket/sumCost",
                data:{"contractid":a,"type":herfs},
                success:function (data1) {
                    console.log(data1)
                }
            });
            // 已付金额
            $.ajax({
                type:"post",
                dataType:"text",
                url:"/ga/payment/paymentSumPaid",
                data:{"projectId":project,"id":a,"matter":herfs},
                success:function (data2) {
                    console.log(data2)
                }
            });
        }else {
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/sd/SdSalesContract/querydetailsbyid?id="+a,
                success:function (data) {

                    $("#center input").eq(1).val(data.SdSalesContract.contractAmount)
                    // $("#center input").eq(2).val(data.SdSalesContract.contractAmount)
                }
            });
        }

        //获取事由的内容
        var  con=$("#ferf").val()
        if(con=="采购付款"){
            $("#ap").attr("name","procurementid");
            console.log( $("#ap"))
        }else if(con=="劳务费付款"){
            $("#ap").attr("name","labourid");
        }else if(con=="中标服务费"){
            $("#ap").attr("name","marketid");
            console.log( $("#ap"))
        }
    })
})
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