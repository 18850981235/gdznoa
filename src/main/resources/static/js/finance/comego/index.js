/**
 * Created by Administrator on 2019/8/19.
 */
$(document).ready(function () {
    var  project= $.cookie("name");
    var  projectid= $.cookie("id");
    var  ferf= $.cookie("herf");
    var  ferf2= $.cookie("herf2");
    // var cook=$.cookie('name')
    $("#projectid").val(projectid)
    $("#project").val(project)
    $("#ferf").val(ferf);
    $("#ferf2").val(ferf2);

    $.ajax({
        type:"post",
        dataType:"json",
        url:"/user/useraction/getLoginUser",
        success:function (data) {
            $("#center input").eq(4).val(data.name)
            $("#center input").eq(5).val(data.id)
            // $(".department option").eq(0).val(data.dept.id)
            // $(".department option").eq(0).text(data.dept.name)

        }
    });
    console.log(ferf)
    if(ferf=="往来款现金"){
        $(".type1 option").eq(1).remove()
    }else if(ferf=="往来款银行"){
        $(".type1 option").eq(0).remove()
    }



})