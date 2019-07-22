/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/stamp/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";

            $("#center input").eq(0).val(data.createtime);
            $("#center input").eq(1).val(data.user.name);
            $("#center input").eq(2).val(data.user.phone);
            $("#center input").eq(3).val(data.content);
            $("#center input").eq(4).val(data.fileNum);
            $("#center input").eq(5).val(data.stampType);
            $("#center input").eq(6).val(data.consigneeAddress);
            $("#center input").eq(7).val(data.consignee);
            $("#center input").eq(8).val(data.consigneePhone);
            if(data.expressageName==undefined){
                $("#center input").eq(9).val("");
            }else {
                $("#center input").eq(9).val(data.expressageName);
            }
            if(data.expressageWaybill==undefined){
                $("#center input").eq(10).val("");
            }else {
                $("#center input").eq(10).val(data.expressageWaybill);
            }


            $(".projectname option").eq(0).text(data.project.abbreviation);
            $(".projectname option").eq(0).val(data.project.id);

            $(".department option").eq(0).text(data.user.company);
            $(".department option").eq(0).val(data.user.deptid);


            $("#center textarea").eq(0).text(data.purpose);
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