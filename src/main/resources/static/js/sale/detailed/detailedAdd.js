/**
 * Created by Administrator on 2019/6/12.
 */
$.ajax({
    type:"post",
    dataType:"json",
    url:"/sd/SdSalesContract/getProject",
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
    //     url:"/sd/Inventory/getSupplierTrademark",
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
        url:"/sd/Inventory/getallsystem",
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
    //     url:"/sd/Inventory/getContractByPid",
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
    //     url:"/sd/Inventory/Excelto",
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
    //         url:"/sd/Inventory/addContractInventory",
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
    //                 //     url:"/sd/Inventory/Excelto",
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
            url: "/sd/Inventory/addContractInventory",
            data: formData,
            dataType:"json",
            cache: false,
            processData: false,
            contentType: false,
            success:function (data) {
                $("#id").val(data.id)
                var html="";
                // <tr class="huo" style="height: 40px;display:none; ">
                //     <td style="width: 40px; ">serialnum</td>
                //     <td style="width: 130px; ">code</td>
                //     <td style="width: 131px;">name</td>
                //     <td style="width: 100px; ">model</td>
                //     <td style="width: 100px; ">parameter</td>
                //     <td style="width: 150px;padding: 3px">trademark</td>
                //     <td style="width: 100px; ">unit</td>
                //     <td style="width: 100px ">num</td>
                //     <td style="width: 100px; ">unitCost</td>
                //     <td style="width: 100px; ">subtotal</td>
                //     <td style="width: 150px; ">remarks</td>
                //     </tr>
                html+='<tr class="huo" style="height: 40px;display:none; ">';
                html+=' <td style="width: 40px; ">serialnum</td>';
                html+='<td style="width: 130px; ">code</td>';
                html+='<td style="width: 131px;">name</td>';
                html+='<td style="width: 100px; ">model</td>';
                html+='<td style="width: 100px; ">parameter</td>';
                html+='<td style="width:150px;padding:3px">trademark</td>';
                html+='<td style="width: 100px; ">unit</td>';
                html+='<td style="width: 100px ">num</td>';
                html+='<td style="width: 100px; ">unitCost</td>';
                html+='<td style="width: 100px; ">subtotal</td>';
                html+='<td style="width: 150px; ">remarks</td>';
                html+='</tr>';
                $("#con").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                $.each(data.List,function (index,obj) {
                    var html="";
                html+='<tr class="huo" style="height: 40px;text-align: center">';
                    html+=' <td style="width: 40px; ">'+obj.序号+'</td>';
                html+='<td style="width: 130px; ">'+obj.编号+'</td>';
                html+='<td style="width: 131px;">'+obj.名称+'</td>';
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
                });

            }
        })
    });

    $("#dian").click(function () {
        //计算总和
        var vues =0;
        var len=$('#con tr:not(:first)').length;
        for(var i=1;i<len+1;i++){

            var vue=$('#con tr').eq(i).find("td").eq(9).text();

            vues += Number(vue);

        }
        $("#heji").val(vues)
    })
    $(document).on("click","#ok",function () {
        var co=$("#id").val();
        var total=$("#heji").val()
        var titles = $("#con").find("tr:first td");  //获得表头td数组
        //遍历非表头的，tr、td...拼装json
        var json = "{" + "\"" + "list" + "\"" + ":" + "[" + $("#con").find("tr:not(:first)").map(function(i, e) {
                return "{" + $(e).children("td").map(function(j, el) {
                        return "\""+$(titles[j]).html()+"\"" + ":" + "\"" + $(el).html() + "\"";
                    }).get().join(",") + "}";
            }).get().join(",")+ "]" +","+ "\""+"contractid"+"\"" + ":" + co+","+ "\""+"total"+"\"" + ":" + total +"}";

        // console.log(json);
        $.ajax({
            type:"post",
            dataType:"text",
            contentType:"application/json;charset=UTF-8",
            url:"/sd/Inventory/addInvenbywight",
            data:json,
            // "contractid":id,
            success:function(data){

           if(data=="yes"){
               alert("添加成功！");
               window.location.href="/sd/salesinventory/query";
           }else{
               alert("添加失败！")
           }

            }
        });

    })


})