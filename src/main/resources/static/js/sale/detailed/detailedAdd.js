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
        var text=' <tr style="height: 40px  "> <td style="width: 100px "><input name=""></td> <td style="width: 150px "><input name="code"></td> <td style="width: 150px "><input name="name"></td> <td style="width: 100px "><input name="model"></td> <td style="width: 100px "><input name="parameter"></td> <td style="width: 100px "><select class="brand" name="trademarkid"><option>请选择</option></select></td> <td style="width: 100px "><input name="unit"></td> <td style="width: 100px "><input name="num"></td> <td style="width: 100px "><input name="unitCost"></td> <td style="width: 100px "><input name="subtotal"></td> <td style="width: 100px "><input name="remarks"></td> </tr>'
        $("#con").append(text);
    })
})