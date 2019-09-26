/**
 * Created by Administrator on 2019/8/19.
 */
function w() {
    var  id=q("id");
    var url="/ga/harvestTicket/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (date) {
            var data=date.gaHarvestTicket;
            var html="";
            $("#center input").eq(0).val(data.project.name);
            $("#center input").eq(1).val(data.project.id);
            $("#center input").eq(2).val(data.companyName);
            $("#center input").eq(3).val(data.name);
            $("#center input").eq(4).val(data.createtime);
            $("#center input").eq(5).val(data.accountname);
            $("#center input").eq(6).val(data.user.name);
            $("#center input").eq(7).val(data.user.id);

            $("#center input").eq(8).val(data.cost);
            $("#center input").eq(9).val(data.phone);
            $("#center input").eq(10).val(data.identifyNumber);
            $("#center input").eq(11).val(data.content);

            $("#center input").eq(12).val(data.bankname);
            $("#center input").eq(13).val(data.bankaccount);

            $("#center input").eq(14).val(data.payaccount);
            $("#center input").eq(15).val(data.proceedsaccount);

            $("#center input").eq(16).val(data.accessory);
            $("#center input").eq(17).val(data.id);
            $("#center input").eq(18).val(data.inorout);

            $(".type option").eq(0).val(data.type)
            $(".type option").eq(0).text(data.type)

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