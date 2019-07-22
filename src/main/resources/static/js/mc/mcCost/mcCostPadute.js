
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/datum/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {

            $("#center input").eq(0).val(data.budget);
            $("#center input").eq(1).val(data.user.name);
            $("#center input").eq(2).val(data.user.id);
            // $("#center input").eq(3).val(data.budget);
            $("#center input").eq(4).val(data.createtime);
            $("#center input").eq(5).val(data.mcVerifyCost);
            $("#center input").eq(6).val(data.principalCost);
            $("#center input").eq(7).val(data.accessory);
            $(".projectname option").eq(0).text(data.projectName);

            $(".department option").eq(0).text(data.user.dept);
            console.log(data.user.dept);

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