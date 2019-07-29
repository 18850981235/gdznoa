
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/sd/SdSalesContract/querydetailsbyid?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (obj) {
        var data=obj.SdSalesContract
            var html="";
        console.log(data.project.client.name)
            $("#center input").eq(0).val(data.id);

            $("#ap option").eq(0).val(data.project.id);
            $("#ap option").eq(0).text(data.project.name);

            $("#center input").eq(1).val(data.project.client.name);
            $("#center input").eq(2).val(data.project.client.id);

            $("#center input").eq(4).val(data.project.code);
            $("#center input").eq(5).val(data.code);

            $(".department option").eq(0).text(data.dept.name);
            $(".department option").eq(0).val(data.dept.id)

            $("#center input").eq(6).val(data.principalUser.name);
            $("#center input").eq(7).val(data.principalUser.id);

            $("#center input").eq(9).val(data.branchUseruser.name);
            $("#center input").eq(10).val(data.branchUseruser.id);

            $("#center input").eq(12).val(data.areaManagerUser.name);
            $("#center input").eq(13).val(data.areaManagerUser.id);

            $(".invoiceType option").eq(0).val(data.invoiceType);
            $(".invoiceType option").eq(0).text(data.invoiceType);

            $("#center input").eq(15).val(data.contractAmount);
            $("#center input").eq(16).val(data.addAmount);

            $(".addList option").eq(0).val(data.addList);
            $(".addList option").eq(0).text(data.addList);

            $("#center input").eq(17).val(data.reductionAmount);
            $(".addList option").eq(0).val(data.reductionList);
            $(".addList option").eq(0).text(data.reductionList);

            $("#center input").eq(18).val(data.managementRate);
            $("#center input").eq(19).val(data.bidiingTime);

            $("#center input").eq(20).val(data.accessory);



        }
    });
}
// w();
$(document).ready(function () {
    w();
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/sd/SdSalesContract/getProject",
        success:function (data) {
            $.each(data,function (index,obj) {
                var html="";

                html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

                $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })
        }
    });
    $("#ap").change(function () {
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/sd/SdSalesContract/getProject",
            success:function (data) {
                $.each(data,function (index,obj) {
                    var html="";
                    var qo=$("#ap").val()
                    if(obj.id==qo){
                        $("#number").val(obj.code)
                    }
                })
            }
        });
    })
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
