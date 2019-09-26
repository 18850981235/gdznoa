/**
 * Created by Administrator on 2019/6/10.
 */

function w() {
    var  id=q("id");
    $("#api").val(id)
    var url="/sd/SdSalesContract/detailsbyprojectid?id="+id;

    $.ajax({
            type:"get",
            dataType:"json",
            url:url,
            date:{"id":id},
            success:function (data) {
                $("#ap").val(data[0].project.name);
            }
    });

    // $.ajax({
    //     type:"get",
    //     dataType:"json",
    //     url:url,
    //     date:{"id":id},
    //     success:function (data) {
    //         var listInventory=data.listInventory;
    //         var html="";
    //         $("#id").val(data.Listcontract[0].id)
    //         $("#ap").val(data.Listcontract[0].project.abbreviation)
    //         $(".type").val(data.Listcontract[0].type)
    //         $(".systemId").val(data.Listcontract[0].systemBean.name)
    //         $(".he").val(data.Listcontract[0].total)
    //         $.each(listInventory,function (index,obj) {
    //             var html="";
    //             // html+='<tr style="height: 40px  ">';
    //             // html+='<td style="width: 100px ">'+(index+1)+'</td>';
    //             // html+='<td style="width: 150px ">'+obj.code+'</td>';
    //             // html+='<td style="width: 150px ">'+obj.name+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.model+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.parameter+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.supplierTrademark.name+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.unit+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.num+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.unitCost+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.subtotal+'</td>';
    //             // html+='<td style="width: 100px ">'+obj.remarks+'</td>';
    //             // html+='</tr> ';
    //             // '+obj.+'
    //             html+='<tr class="huo" style="height: 40px; ">';
    //             html+='<td style="width: 40px; "> '+obj.serialnum+'</td>';
    //             html+='<td style="width: 130px; "> '+obj.code+'</td> ';
    //             html+='<td style="width: 131px;"> '+obj.name+'</td> ';
    //             html+='<td style="width: 100px; "> '+obj.model+'</td> ';
    //             html+='<td style="width: 100px; "> '+obj.parameter+'</td> ';
    //             html+='<td style="width: 150px;padding: 3px "> '+obj.trademark+'</td> ';
    //             html+='<td style="width: 100px; "> '+obj.unit+'</td> ';
    //             html+='<td style="width: 100px "> '+obj.num+'</td> ';
    //             html+='<td style="width: 100px; "> '+obj.unitCost+'</td> ';
    //             html+='<td style="width: 100px; "> '+obj.subtotal+'</td> ';
    //             html+='<td style="width: 150px; "> '+obj.remarks+'</td> ';
    //             html+='</tr> ';
    //
    //             $("#con").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    //         })
    //
    //
    //
    //
    //
    //         // })
    //     }
    // });
}

$(document).ready(function () {
    w();
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
    $(".systemId").change(function () {
        $("#con").html(value="");
        var o=$(".systemId").val()
        var api=$("#api").val();
        $.ajax({
            type:"get",
            dataType:"json",
            url:"/sd/SdSalesContract/detailsbyprojectid?id="+api,
            success:function (data) {
                $.each(data,function (index1,obj1) {
                    if(o==obj1.systemBean.id){
                        var pid=obj1.id;
                        console.log(pid);
                        $.ajax({
                            type:"get",
                            dataType:"json",
                            url:"/sd/SdSalesContract/QuerydetailsbyInt?id="+pid,
                            success:function (date) {
                                console.log(1)
                                $.each(date,function (index,obj) {
                                    console.log(obj)
                                    var html="";
                                    html += '<tr class="huo" style="height: 40px;display:block;text-align: center ">';
                                    html += ' <td style="width: 40px;height: 40px; ">'+obj.serialnum+'</td>';
                                    html += '<td style="width: 130px;height: 40px; ">'+obj.code+'</td>';
                                    html += '<td style="width: 130px;height: 40px;">'+obj.name+'</td>';
                                    html += '<td style="width: 100px;height: 40px; ">'+obj.model+'</td>';
                                    html += '<td style="width: 100px;height: 40px; ">'+obj.parameter+'</td>';
                                    html += '<td style="width:150px;height: 40px;padding:3px">'+obj.trademark+'</td>';
                                    html += '<td style="width: 100px;height: 40px; ">'+obj.unit+'</td>';
                                    html += '<td style="width: 100px;height: 40px; ">'+obj.num+'</td>';
                                    html += '<td style="width: 100px;height: 40px; ">'+obj.unitCost+'</td>';
                                    html += '<td style="width: 100px;height: 40px; ">'+obj.subtotal+'</td>';
                                    html += '<td style="width: 150px;height: 40px; ">'+obj.remarks+'</td>';
                                    html += '</tr>';
                                    $("#con").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                                })
                            }
                        })
                    }
                })
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