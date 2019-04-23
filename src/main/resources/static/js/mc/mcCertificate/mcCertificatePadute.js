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
            $("#center input").eq(5).val(data[0].annualTime);
            $("#center input").eq(6).val(data[0].state);
            $("#center input").eq(7).val(data[0].borrow);
            $("#center input").eq(8).val(data[0].accessory);
            $(".department option").eq(0).text(data[0].user.dept);
            $(".department1 option").eq(1).text(data[0].type);

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