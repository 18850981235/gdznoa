/**
 * Created by Administrator on 2019/8/12.
 */
$(document).ready(function () {
    var  project= $.cookie("id");
    var  ferf= $.cookie("herf");
    // var cook=$.cookie('name')
    $("#projectid").val(project)
    $("#ferf").val(ferf);

    $.ajax({
        type:"post",
        dataType:"json",
        url:"/user/useraction/getLoginUser",
        success:function (data) {

            $("#center input").eq(3).val(data.name)
            $("#center input").eq(4).val(data.id)
            // $(".department option").eq(0).val(data.dept.id)
            // $(".department option").eq(0).text(data.dept.name)

        }
    });

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