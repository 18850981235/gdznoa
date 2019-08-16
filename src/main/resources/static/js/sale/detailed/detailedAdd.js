/**
 * Created by Administrator on 2019/6/12.
 */
$.ajax({
    type:"post",
    dataType:"json",
    url:"http://192.168.1.236:8080/sd/SdSalesContract/getProject",
    success:function (data) {
        $.each(data,function (index,obj) {
            var html="";
            html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

            $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        })
    }
});

$(document).ready(function () {

    // $.ajax({
    //     type:"post",
    //     dataType:"json",
    //     url:"http://192.168.1.236:8080/sd/Inventory/getSupplierTrademark",
    //     success:function (data) {
    //         $.each(data,function (index,obj) {
    //             var html="";
    //             html+='<option   value='+obj.id+'>'+obj.name+'</option>';
    //             $("#con #trademarkid").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    //         })
    //     }
    // });
    $.ajax({
        type:"post",
        dataType:"json",
        url:"http://192.168.1.236:8080/sd/Inventory/getallsystem",
        success:function (data) {
            $.each(data,function (index,obj) {
                var html="";
                if(obj.f_id==0){
                    html+='<option   value='+obj.id+'>'+obj.name+'</option>';
                }

                $(".systemId").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })
        }
    });
    // $.ajax({
    //     type:"post",
    //     dataType:"json",
    //     url:"http://192.168.1.236:8080/sd/Inventory/getContractByPid",
    //     success:function (data) {
    //         $.each(data,function (index,obj) {
    //             var html="";
    //             if(obj.f_id==0){
    //                 html+='<option   value='+obj.id+'>'+obj.name+'</option>';
    //             }
    //
    //             $(".contract").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    //         })
    //     }
    // });
    // $(document).on("click","#no",function () {
    //     var File=$(".File").val()
    //     var formData = new FormData($('#uploadForm')[0]);
    //     console.log(1)
    // $.ajax({
    //     type:"post",
    //     dataType:"json",
    //     url:"http://192.168.1.236:8080/sd/Inventory/Excelto",
    //     data:formData,
    //     cache: false,
    //     processData: false,
    //     contentType: false,
    //     success:function (data1) {
    //         console.log(2)
    //         console.log(data1)
    //
    //     }
    // });
    // });
    // $(document).on("click",".File-in",function () {
    //     var ap=$("#ap").val()
    //     var typpe=$(".type").val()
    //     var systemId=$(".systemId").val()
    //     var File=$(".File").val()
    //     // console.log(ap+"+"+typpe+"+"+"+")
    //     $.ajax({
    //         type:"post",
    //         dataType:"json",
    //         url:"http://192.168.1.236:8080/sd/Inventory/addContractInventory",
    //         data:{"projectId":ap,"system":systemId,"type":typpe},
    //         cache: false,
    //         processData: false,
    //         contentType: false,
    //         success:function (data) {
    //          // console.log(data)
    //             console.log(1)
    //                 // $.ajax({
    //                 //     type:"post",
    //                 //     dataType:"json",
    //                 //     url:"http://192.168.1.236:8080/sd/Inventory/Excelto",
    //                 //     data:{"file":File},
    //                 //     success:function (data1) {
    //                 //         console.log(2)
    //                 //           console.log(data1)
    //                 //
    //                 //     }
    //                 // });
    //
    //         }
    //     });
    //
    //     var titles = $("#con").find("tr:first td");  //获得表头td数组
    //     //遍历非表头的，tr、td...拼装json
    //     var json = "[" + $("#con").find("tr:not(:first)").map(function(i, e) {
    //             return "{" + $(e).children("td").map(function(j, el) {
    //                     return "\""+$(titles[j]).html()+"\""+ ":" + "\""+$(el).html()+"\"";
    //                     // return "\""+$(titles[j]).html()+"\""+ ":" +$(el).html();
    //                 }).get().join(",") + "}";
    //         }).get().join(",") + "]";
    //     // console.log(json)
    //
    // })






    // function tabToJSONForJquery(id) {
    //     var titles = $("#" + id).find("tr:first td");  //获得表头td数组
    //     //遍历非表头的，tr、td...拼装json
    //     var json = "[" + $("#" + id).find("tr:not(:first)").map(function(i, e) {
    //             return "{" + $(e).children("td").map(function(j, el) {
    //                     return $(titles[j]).html() + ":" + $(el).html();
    //                 }).get().join(",") + "}";
    //         }).get().join(",") + "]";
    //     $("#test").html(json);
    // }



    $("#upfile").click(function () {
        var formData = new FormData($('#on')[0]);
        $.ajax({
            type: 'post',
            url: "http://192.168.1.236:8080/sd/Inventory/addContractInventory",
            data: formData,
            dataType:"json",
            cache: false,
            processData: false,
            contentType: false,
            success:function (data) {
                $("#id").val(data.id)
                $.each(data.List,function (index,obj) {
                var html="";
                html+='<tr class="huo" style="height: 40px;text-align: center">';
                html+='<td style="width: 150px; ">'+obj.编号+'</td>';
                html+='<td style="width: 151px;">'+obj.名称+'</td>';
                html+='<td style="width: 100px; ">'+obj.规格型号+'</td>';
                html+='<td style="width: 100px; ">'+obj.技术参数+'</td>';
                html+='<td style="width: 150px;padding:3px">'+obj.品牌名称+'</td>';
                html+='<td style="width: 100px; ">'+obj.单位+'</td>';
                html+='<td style="width: 100px ">'+obj.数量+'</td>';
                html+='<td style="width: 100px; ">'+obj.单价+'</td>';
                html+='<td style="width: 100px; ">'+obj.小计+'</td>';
                html+='<td style="width: 150px; ">'+obj.备注+'</td>';
                html+='</tr>';
                $("#con").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                })
            }
        })
    });
    $(document).on("click","#ok",function () {
        var co=$("#id").val();
        var titles = $("#con").find("tr:first td");  //获得表头td数组
        //遍历非表头的，tr、td...拼装json
        var json = "{" +
            "\"" + "list" + "\"" + ":" + "[" + $("#con").find("tr:not(:first)").map(function(i, e) {
                return "{" + $(e).children("td").map(function(j, el) {
                        return "\""+$(titles[j]).html()+"\"" + ":" + "\"" + $(el).html() + "\"";
                    }).get().join(",") + "}";
            }).get().join(",")+ "]" +","+ "\""+"contractid"+"\"" + ":" + co +"}";

        console.log(json);
        $.ajax({
            type:"post",
            dataType:"json",
            contentType:"application/json;charset=UTF-8",
            url:"http://192.168.1.236:8080/sd/Inventory/addInvenbywight",
            data:json,
            // "contractid":id,
            success:function(data1){
            console.log(data1)

            }
        });

    })


})