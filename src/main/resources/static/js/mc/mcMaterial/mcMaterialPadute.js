
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/materials/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            $("#center input").eq(0).val(data.id);
            $("#center input").eq(1).val(data.createtime);
            $("#center input").eq(2).val(data.user.name);
            $("#center input").eq(3).val(data.user.id);
            $("#center input").eq(4).val(data.user.account);
            $("#center input").eq(5).val(data.accessory);

            $("#center textarea").eq(0).text(data.content);
            $("#center textarea").eq(1).text(data.purpose);

            $(".department option").eq(0).text(data.dept.name);
            $(".department option").eq(0).val(data.dept.id);

            $(".projectname option").eq(0).text(data.projectName);
            $(".projectname option").eq(0).val(data.projectid);



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