/**
 * Created by Administrator on 2019/5/27.
 */
//用户默认申请人
$.ajax({
    type: "get",
    url: "/util/getUser",
    dataType: "json",
    success: function (data) {
        $(".department option").eq(0).val(data.deptid);
        $(".department option").eq(0).text(data.dept);
        $("#center input").eq(0).val(data.name);
        $("#center input").eq(1).val(data.id);
    }
})
$(document).on("click","#ok",function () {
    if($(".costStandard")==""||$(".costStandard")==null){
        $(".costStandard").attr("name","")
    }
    if($("#test2")==""||$("#test2")==null){
            $("#test2").attr("name","")
    }
    if($(".evectionCost")==""||$(".evectionCost")==null){
        $(".evectionCost").attr("name","")
    }
    if($(".travelCost")==""||$(".travelCost")==null){
        $(".travelCost").attr("name","")
    }
})