
/**
 * Created by Administrator on 2019/4/15.
 */

function w() {
    var  id=q("id");
    var url="/mc/dispatched/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            $("#center input").eq(0).val(data.id);
            $("#center input").eq(1).val(data.user.name);
            $("#center input").eq(3).val(data.demand);
            $("#center input").eq(4).val(data.evectionTime);
            $("#center input").eq(5).val(data.personnelCondition);
            $("#center input").eq(6).val(data.costStandard);
            $("#center input").eq(7).val(data.evectionBudget);
            $("#center input").eq(8).val(data.practicalTime);
            $("#center input").eq(9).val(data.evectionCondition);
            $("#center input").eq(10).val(data.evectionCost);
            $("#center input").eq(11).val(data.travelCost);

            $(".projectname option").eq(0).text(data.project.abbreviation);
            $(".department option").eq(0).text(data.dept.name);

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