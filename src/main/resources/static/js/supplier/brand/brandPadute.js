/**
 * Created by Administrator on 2019/8/2.
 */
function w() {
    var  id=q("id");
    var url="/supplier/trademark/QueryTrademarkByid?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // console.log(data.ContractInventory[0].project.name)
            console.log(data.id)
            $("#center input").eq(0).val(data.id)

            $(".contacts option").eq(0).val(data.system.id);
            $(".contacts option").eq(0).text(data.system.name);

            $("#center input").eq(1).val(data.product)
            $("#center input").eq(2).val(data.name)
            $("#center input").eq(3).val(data.englishName)
            $("#center input").eq(4).val(data.enterpriseName)
            $("#center input").eq(5).val(data.originPlace)
            $("#center input").eq(6).val(data.url)

        }
    });
}
$(document).ready(function () {
    w();

    $.ajax({
        type:"post",
        dataType:"json",
        url:"/supplier/trademark/getAllSysytem",
        success:function (data) {
            $.each(data,function (index,obj) {
                var html="";
                if(obj.f_id==0||obj.f_id=="0"){
                    html+='<option value='+obj.id+'>';
                    html+='<span>'+obj.name+'</span>';
                    html+='</option>';
                }
                $(".contacts").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
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