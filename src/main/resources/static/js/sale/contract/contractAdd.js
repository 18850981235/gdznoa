/**
 * Created by Administrator on 2019/6/10.
 */
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
$(document).ready(function () {
        var wo=$("#contract").text()
    if(wo==""){
        $("#contract-no").show();
    }else {
        $("#contract-no").hide();
    }

    $("#ap").change(function(){
             $.ajax({
                 type: "post",
                 dataType: "json",
                 url: "/sd/SdSalesContract/getProject",
                 success: function (data) {
                     var html = "";
                        for(i=0;i<data.length;i++){
                            var wq=$('#ap option:selected').text();
                            if(wq==data[i].name){
                                 $("#center input").eq(1).val(data[i].client.name);
                                $("#center input").eq(2).val(data[i].client.id);
                                $("#center input").eq(3).val(data[i].code);
                                $("#center input").eq(5).val(data[i].dept.name);
                                $("#center input").eq(6).val(data[i].dept.id);
                                $("#center input").eq(7).val(data[i].principalUser.name);
                                $("#center input").eq(8).val(data[i].principalUser.id);
                                $("#center input").eq(9).val(data[i].branchuser.name);
                                $("#center input").eq(10).val(data[i].branchuser.id);
                                $("#center input").eq(11).val(data[i].areaManagerUser.name);
                                $("#center input").eq(12).val(data[i].areaManagerUser.id);
                            }
                        }
                 }
             });
    })

});
