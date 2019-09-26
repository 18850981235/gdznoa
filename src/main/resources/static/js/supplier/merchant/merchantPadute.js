/**
 * Created by Administrator on 2019/7/25.
 */
function w() {
    var  id=q("id");
    var url="/supplier/supplier2/QuerySupplierById?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            $("#center input").eq(0).val(data.id);
            $("#center input").eq(1).val(data.name);
            $("#center input").eq(2).val(data.code);
            $("#center input").eq(3).val(data.legalPerson);
            $("#center input").eq(4).val(data.registeredCapital);
            $("#center input").eq(5).val(data.registeredAddress);
            $("#center input").eq(6).val(data.establishTime);
            $("#center input").eq(7).val(data.phone);
            $("#center input").eq(8).val(data.fax);
            $("#center input").eq(9).val(data.email);
            $("#center input").eq(10).val(data.postalCode);

            $(".type option").eq(0).val(data.type);
            $(".type option").eq(0).text(data.type);

            $("#center input").eq(11).val(data.grade);
            $("#center input").eq(12).val(data.supplierTrademarks[0].supplierTrademark.name);
            $("#center input").eq(13).val(data.supplierTrademarks[0].supplierTrademark.id);
            // $("#center input").eq(14).val();
            $("#center input").eq(15).val(data.url);
            $("#center input").eq(16).val(data.bankname);
            $("#center input").eq(17).val(data.bankaccount);
            $("#center input").eq(18).val(data.bankaddress);
            $("#center input").eq(19).val(data.tfn);
            $("#center input").eq(20).val(data.credentialAccessory);



            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        date:{"id":id},
        success:function (data) {
            var html="";



            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
}
$(document).ready(function () {
    w();
    $("body").on("click","#add",function () {
        var text='<tr style="height:40px;"><td style="width:200px"><input style="width: 180px;text-align: center " placeholder="请输入时间" name=""></td><td colspan="3"> <input style="width:700px " placeholder="请输入" name=""></td></tr>'
        $("#con tbody").append(text);
    })
    $("body").on("click","#remove",function () {
        $("#con tr:last").remove();
    })
    $("body").on("click",".block",function () {
        $("#none").slideDown();
        $(".none").show();
        $(".block").hide();
    })
    $("body").on("click",".none",function () {
        $("#none").slideUp();
        $(".block").show();
        $(".none").hide();
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