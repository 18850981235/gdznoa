/**
 * Created by Administrator on 2019/6/10.
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
$.ajax({
    type:"post",
    dataType:"json",
    url:"/sd/Inventory/getSupplierTrademark",
    success:function (data) {
        $.each(data,function (index,obj) {
            var html="";
            html+='<option   value='+obj.id+'>'+obj.name+'</option>';
            $("#con #trademarkid").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        })
    }
});
function w() {
    var  id=q("id");
    var url="/sd/Inventory/getInventorybyproject?id="+id;
    var url1="/sd/Inventory/getInventorybyid?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // console.log(data.ContractInventory[0].project.name)
            $("#ap option").eq(0).text(data.ContractInventory[0].project.name);
            $("#ap option").eq(0).val(data.ContractInventory[0].project.id);
            $("#on input").eq(0).val(data.ContractInventory[0].branchName);
            $("#on input").eq(1).val(data.ContractInventory[0].total);
            $(".systemId option").eq(0).val(data.ContractInventory[0].system.id);
            $(".systemId option").eq(0).text(data.ContractInventory[0].system.name);
            $(".subitemId option").eq(0).val(data.ContractInventory[0].subitem.id);
            $(".subitemId option").eq(0).text(data.ContractInventory[0].subitem.name);
        }
    });
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var sdSalesInventoryList=data.sdSalesInventoryList;
            var html="";
            $.each(sdSalesInventoryList,function (index,obj) {
                html+='<tr style="height: 40px  ">';
                html+='<td style="width: 100px ">'+(index+1)+'</td>';
                html+='<td style="width: 150px "><input name="code" value='+obj.code+'></td>';
                html+='<td style="width: 150px "><input name="name" value='+obj.name+'></td>';
                html+='<td style="width: 100px "><input name="model" value='+obj.model+'></td>';
                html+='<td style="width: 100px "><input name="parameter" value='+obj.parameter+'></td>';
                html+='<td style="width: 100px "><select class="brand" name="trademarkid"><option value='+obj.trademarkid+'>'+obj.supplierTrademark.name+'</option></select></td>';
                html+='<td style="width: 100px "><input name="unit" value='+obj.unit+'></td>';
                html+='<td style="width: 100px "><input name="num" value='+obj.num+'></td>';
                html+='<td style="width: 100px "><input name="unitCost" value='+obj.unitCost+'></td>';
                html+='<td style="width: 100px "><input name="subtotal" value='+obj.subtotal+'></td>';
                html+='<td style="width: 100px "><input name="remarks" value='+obj.remarks+'></td>';
                html+='</tr> ';

            })





            $("#con").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            // })
        }
    });
}
// w();
$(document).ready(function () {
    w();
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