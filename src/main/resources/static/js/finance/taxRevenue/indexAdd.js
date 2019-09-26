/**
 * Created by Administrator on 2019/8/19.
 */
$(document).ready(function () {
    var  project= $.cookie("name");
    var  projectid= $.cookie("id");
    var  ferf= $.cookie("herf");
    // var cook=$.cookie('name')
    $("#projectid").val(projectid)
    $("#project").val(project)
    $("#ferf").val(ferf);
    if(ferf=="设备进项专用发票管理"||ferf=="建安进项专用发票管理"||ferf=="服务进项专用发票管理"){
        $("#inorout").val("收票")
    }else {
        $("#inorout").val("开票")
    }
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/user/useraction/getLoginUser",
        success:function (data) {
            $("#center input").eq(6).val(data.name)
            $("#center input").eq(7).val(data.id)
            // $(".department option").eq(0).val(data.dept.id)
            // $(".department option").eq(0).text(data.dept.name)

        }
    });

    $.ajax({
        type:"post",
        dataType:"json",
        url:"/sd/SdSalesContract/queryContract",
        success:function (data) {
            $.each(data.list,function (index,obj) {
                var html="";
                html+='<option class="pop"  value='+obj.id+'>'+obj.project.name+'</option>';
                $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })
        }
    });
    // $.ajax({
    //     type:"post",
    //     dataType:"json",
    //     url:"/sd/SdSalesContract/queryContract",
    //     success:function (data) {
    //         $.each(data.list,function (index,obj) {
    //             var html="";
    //
    //             html+='<option class="pop"  value='+obj.id+'>'+obj.project.name+'</option>';
    //
    //             $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    //         })
    //     }
    // });

    // $("#ap").change(function () {
    //     var a=$("#ap").val();
    //     var url="/sd/SdSalesContract/querydetailsbyid?id="+a
    //     $.ajax({
    //         type:"post",
    //         dataType:"json",
    //         url:url,
    //         success:function (data) {
    //
    //             $("#center input").eq(0).val(data.SdSalesContract.project.id)
    //             $("#center input").eq(1).val(data.SdSalesContract.contractAmount)
    //             // $("#center input").eq(2).val(data.SdSalesContract.contractAmount)
    //         }
    //     });
    // })
})