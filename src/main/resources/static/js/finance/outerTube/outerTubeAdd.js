/**
 * Created by Administrator on 2019/8/5.
 */
$(document).ready(function () {
    var  projectid= $.cookie("id");
    var  ferf= $.cookie("herf");
    // var cook=$.cookie('name')
    $("#projectid").val(projectid);
    $("#ferf").val(ferf);

    $.ajax({
        type:"post",
        dataType:"json",
        url:"/user/useraction/getLoginUser",
        success:function (data) {
            console.log(data.name);
            $("#center input").eq(1).val(data.name);
            $("#center input").eq(2).val(data.id);
            $(".department option").eq(0).val(data.dept.id)
            $(".department option").eq(0).text(data.dept.name)

            console.log(data.dept.id)

            console.log(data.dept.name)

        }
    });
    //采购合同下拉
    $.ajax({
        type:"post",
        dataType:"json",
        url:"",
        success:function (data) {
            $.each(data.list,function (index,obj) {
                var html="";

                html+='<option class="pop"  value='+obj.id+'>'+obj.project.name+'</option>';

                $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })
        }
    });
    //点击下拉
    $("#ap").change(function () {
        var a=$("#ap").val();
        var url=""+a
        $.ajax({
            type:"post",
            dataType:"json",
            url:url,
            success:function (data) {

                $("#center input").eq(0).val(data.SdSalesContract.project.id)
                $("#center input").eq(1).val(data.SdSalesContract.contractAmount)
            }
        });
    })
})