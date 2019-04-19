
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="http://192.168.1.191:8080/mc/materials/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            $("#center input").eq(0).val(data.id);
            $("#center input").eq(1).val(data.createtime);
            $("#center input").eq(2).val(data.consignee);
            $("#center input").eq(3).val(data.consigneePhone);
            $("#center input").eq(4).val(data.consigneeAddress);
            $("#center input").eq(5).val(data.content);
            $("#center input").eq(6).val(data.purpose);
            console.log(data.dept.id)
            $(".department option").eq(0).text(data.dept.name);
            $(".department1 option").eq(0).text(data.offerTpye);


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