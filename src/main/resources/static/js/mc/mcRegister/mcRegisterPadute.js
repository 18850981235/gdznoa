/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/register/query.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        success:function (data) {
            var html="";

            $("#center input").eq(0).val(data[0].id);
            $("#center input").eq(1).val(data[0].recordsName);
            $("#center input").eq(2).val(data[0].createtime);
            $("#center input").eq(3).val(data[0].user.name);
            $("#center input").eq(4).val(data[0].user.id);
            // $("#center input").eq(6).val(data[0].accessory);

            $(".department option").eq(0).text(data[0].user.dept);
            $(".recordsType option").eq(0).text(data[0].recordsType);
            $(".recordsState option").eq(0).text(data[0].recordsState);

            // $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

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