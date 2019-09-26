/**
 * Created by Administrator on 2019/8/6.
 */
function w() {
    var  id=q("id");
    var url="/ed/EdMassage/QueryOneMassage?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            // var data=obj.pdProcurementContract
            var html="";

            $("#ap option").eq(0).val(data.project.id)
            $("#ap option").eq(0).text(data.project.name)
            // $("#center input").eq(0).val(data.project.code);
            // $("#center input").eq(1).val(data.projectManager);
            // $("#center input").eq(2).val(data.project.code);
            // $("#center input").eq(3).val(data.user.name);
            // $("#center input").eq(4).val(data.user.id);
            // $("#center input").eq(6).val(data.code);
            $(".crm option").eq(0).val(data.client.id)
            $(".crm option").eq(0).text(data.client.name)

            $("#center input").eq(7).val(data.fristDeputy);
            $("#center input").eq(8).val(data.fristPhone);
            $("#center input").eq(9).val(data.agentConstructUnit);
            $("#center input").eq(10).val(data.agentDeputy);
            $("#center input").eq(11).val(data.agentPhone);
            $("#center input").eq(12).val(data.supervisingUnit);
            $("#center input").eq(13).val(data.supervisor);
            $("#center input").eq(14).val(data.supervisorPhone);
            $("#center input").eq(15).val(data.id);
            var ap=$("#ap").val()
            if(ap!=""||ap!=undefined){
                $.ajax({
                    type:"post",
                    dataType:"json",
                    url:"/sd/SdSalesContract/getProject",
                    success:function (data) {
                        $.each(data,function (index,obj) {
                            if(obj.id==ap){
                                $("#center input").eq(0).val(obj.code)
                                $("#center input").eq(1).val(obj.projectManager)
                                $("#center input").eq(2).val(obj.name)
                                $("#center input").eq(3).val(obj.userid)
                                $("#center input").eq(4).val(obj.dept.name)
                                $("#center input").eq(5).val(obj.dept.id)
                                $("#center input").eq(6).val(obj.site)


                            }

                        })
                    }
                });
            }


        }
    });
}
// w();
$(document).ready(function () {
    w();

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

                        console.log($("#center input").eq(0))
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