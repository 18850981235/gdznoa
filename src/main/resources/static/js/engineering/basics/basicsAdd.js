/**
 * Created by Administrator on 2019/8/6.
 */
$(document).ready(function () {


    //遍历项目
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
    //项目编号
    $("#ap").change(function () {
        var id=$("#ap").val()
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/sd/SdSalesContract/getProject",
            success:function (data) {
                $.each(data,function (index,obj) {
                    if(obj.id==id){
                        $("#center input").eq(0).val(obj.code)
                        $("#center input").eq(1).val(obj.projectManager)
                        $("#center input").eq(2).val(obj.name)
                        $("#center input").eq(3).val(obj.userid)
                        $("#center input").eq(4).val(obj.dept.name)
                        $("#center input").eq(5).val(obj.dept.id)
                        $("#center input").eq(6).val(obj.site)
                        console.log(obj.dept.id)

                    }

                })
            }
        });
    })
    //建设单位
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getClient",
        success:function (data) {

            $.each(data,function (index,obj) {
                var html="";
                html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

                $(".crm").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })
        }
    });


})