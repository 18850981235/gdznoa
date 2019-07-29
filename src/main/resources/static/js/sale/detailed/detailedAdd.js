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
$(document).ready(function () {
    $("body").on("click","#add",function () {
        var text='<tr style="height: 40px; "><td style="width: 150px; "><input style="width: 140px "name="code"></td><td style="width: 151px;"><input style="width: 143px " name="name"></td><td style="width: 100px; "><input style="width: 95px " name="model"></td><td style="width: 100px; "><input  style="width: 95px " name="parameter"></td><td style="width: 150px; ;padding: 3px "><select style="width: 140px ;height: 30px;margin-right: auto;margin-left:auto" id="trademarkid" name="trademark"><option value="">请选择</option></select></td><td style="width: 100px; "><input style="width: 95px " name="unit"> </td><td style="width: 100px "><input style="width: 95px " name="num"></td><td style="width: 100px; "><input style="width: 95px " name="unitCost"></td><td style="width: 100px; "><input style="width: 95px " name="subtotal"></td><td style="width: 150px; "><input style="width: 140px " name="remarks"></td></tr>'
        $("#con tbody").append(text);
    })
    $("body").on("click","#remove",function () {
        $("#con tr:last").remove();
    })
})