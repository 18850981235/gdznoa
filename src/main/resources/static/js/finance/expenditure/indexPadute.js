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
            $("#center input").eq(1).val(data.project.abbreviation);
            $("#center input").eq(2).val(data.project.id);
            $("#center input").eq(3).val(data.matter);
            $("#center input").eq(4).val(data.unit);
            $("#center input").eq(5).val(data.user.name);
            $("#center input").eq(6).val(data.user.id);
            $("#center input").eq(7).val(data.paymentMoney);

            $(".type option").eq(0).val(data.type);
            $(".type option").eq(0).text(data.type);

            $("#center input").eq(8).val(data.digest);
            $("#center input").eq(9).val(data.bankname);
            $("#center input").eq(10).val(data.bankaccount);

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