/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/qualification/querybyid.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        date:{"id":id},
        success:function (data) {
            var html="";
            $("#center input").eq(0).val(data[0].id);
            $("#center input").eq(1).val(data[0].name);
            $("#center input").eq(2).val(data[0].user.name);
            $("#center input").eq(3).val(data[0].user.id);

            $("#center input").eq(5).val(data[0].state);
            $("#center input").eq(6).val(data[0].annualTime);
            $("#center input").eq(7).val(data[0].annualUser.name);
            $("#center input").eq(8).val(data[0].annualUser.id);

            $("#center input").eq(12).val(data[0].accessory);

            $(".zhengshu option").eq(0).text(data[0].type);
            $(".zhengshu option").eq(0).val(data[0].type);


            $(".department option").eq(0).text(data[0].dept.name);
            $(".department option").eq(0).val(data[0].dept.id);

            $(".neiron option").eq(0).text(data[0].content);
            $(".neiron option").eq(0).val(data[0].content);

            $(".state option").eq(0).text(data[0].type);
            $(".state option").eq(0).val(data[0].type);



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